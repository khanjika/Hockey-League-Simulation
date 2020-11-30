package statemachine.trade;

import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.List;

public class AcceptRejectTrade implements IAcceptRejectTrade {

    private ITradeModel model;
    private ITeamsValidator teamsValidator;
    private static final Logger logger = Logger.getLogger (AcceptRejectTrade.class);

    public AcceptRejectTrade() {
        model = TradeAbstractFactory.instance ().createTradeModel ();
        teamsValidator = LeagueObjectModelAbstractFactory.getInstance ().getTeamsValidator ();
    }

    @Override
    public ILeagueModel acceptRejectTrade(ILeagueModel leagueModel) {
        float offeredPlayerStrength = 0;
        float requestedPlayerStrength = 0;

        for (int i = 0; i < model.getOfferedPlayer ().size (); i++) {
            offeredPlayerStrength += model.getOfferedPlayer ().get (i).getPlayerStrength ();
        }

        for (int i = 0; i < model.getRequestedPlayers ().size (); i++) {
            requestedPlayerStrength += model.getRequestedPlayers ().get (i).getPlayerStrength ();
        }

        if (offeredPlayerStrength > requestedPlayerStrength) {
            logger.debug ("Trade Accepted");
            leagueModel = tradeAccepted (leagueModel);
        } else {
            logger.debug ("Trade Rejected by team:" + model.getTradeOfferedTeam ().getTeamName ());
            leagueModel = tradeRejected (leagueModel);
        }
        return leagueModel;
    }

    @Override
    public ILeagueModel tradeRejected(ILeagueModel leagueModel) {
        float randomAcceptanceChance = leagueModel.getGameplayConfig ().getTrading ().getRandomAcceptanceChance ();

        if (Math.random () < randomAcceptanceChance) {
            leagueModel = tradeAccepted (leagueModel);
        }
        return leagueModel;
    }

    @Override
    public ILeagueModel tradeAccepted(ILeagueModel league) {
        logger.info ("Players offered:");
        for (int i = 0; i < model.getOfferedPlayer ().size (); i++) {
            logger.info ("Player name:" + model.getOfferedPlayer ().get (i).getPlayerName ());
            logger.info ("Player position:" + model.getOfferedPlayer ().get (i).getPosition ());
        }
        logger.info ("Players requested:");
        for (int i = 0; i < model.getRequestedPlayers ().size (); i++) {
            logger.info ("Player name:" + model.getRequestedPlayers ().get (i).getPlayerName ());
            logger.info ("Player position:" + model.getRequestedPlayers ().get (i).getPosition ());
        }
        boolean successTeam1 = false;
        boolean successTeam2 = false;

        String TradingTeam1 = model.getTradeInitiatingTeam ().getTeamName ();
        String TradingDivision1 = model.getTradeInitiatingTeam ().getDivisionName ();
        String TradingConference1 = model.getTradeInitiatingTeam ().getConferenceName ();

        String TradingTeam2 = model.getTradeOfferedTeam ().getTeamName ();
        String TradingDivision2 = model.getTradeOfferedTeam ().getDivisionName ();
        String TradingConference2 = model.getTradeOfferedTeam ().getConferenceName ();

        for (ConferenceModel conference : league.getConferences ()) {
            for (DivisonModel division : conference.getDivisions ()) {
                for (TeamsModel team : division.getTeams ()) {
                    String teamName = team.getTeamName ();
                    String divisionName = division.getDivisionName ();
                    String conferenceName = conference.getConferenceName ();
                    if (teamName.equals (TradingTeam1) && divisionName.equals (TradingDivision1) && conferenceName.equals (TradingConference1)) {
                        successTeam1 = swapTeam (team, model.getRequestedPlayers (), model.getOfferedPlayer ());
                        team.calculateTeamStrength (team);
                        teamsValidator.isCaptainPresent (team.getPlayers ());
                        teamsValidator.NoOfPlayersInTeam (team.getPlayers (), league);
                    }
                    if (teamName.equals (TradingTeam2) && divisionName.equals (TradingDivision2) && conferenceName.equals (TradingConference2)) {
                        successTeam2 = swapTeam (team, model.getOfferedPlayer (), model.getRequestedPlayers ());
                        team.calculateTeamStrength (team);
                        teamsValidator.isCaptainPresent (team.getPlayers ());
                        teamsValidator.NoOfPlayersInTeam (team.getPlayers (), league);
                    }
                    if (successTeam1 && successTeam2) {
                        break;
                    }

                }
            }
        }
        return league;
    }

    @Override
    public boolean swapTeam(ITeamsModel team, List<PlayerModel> team1, List<PlayerModel> team2) {
        List<PlayerModel> t1 = team.getPlayers ();
        for (int i = 0; i < team1.size (); i++) {
            PlayerModel player1 = team1.get (i);
            t1.add (player1);
        }
        for (int i = 0; i < team2.size (); i++) {
            PlayerModel player2 = team2.get (i);
            for (int j = 0; j < t1.size (); j++) {
                if (player2.equals (t1.get (j))) {
                    t1.remove (player2);
                    break;
                }
            }
        }
        team.setPlayers (t1);
        return true;
    }
}



