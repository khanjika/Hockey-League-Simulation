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
    public ILeagueModel acceptRejectTrade(ILeagueModel leagueModel, ITeamsModel initiateTeam, ITeamsModel offeredTeam) {
        float offeredPlayerStrength = 0;
        float requestedPlayerStrength = 0;

        if (model.getOfferedPlayer ().isEmpty () == true) {
            logger.info ("Trade Accepted");
            leagueModel = tradeAccepted (leagueModel, initiateTeam, offeredTeam);
        } else {
            for (int i = 0; i < model.getOfferedPlayer ().size (); i++) {
                offeredPlayerStrength += model.getOfferedPlayer ().get (i).getPlayerStrength ();
            }

            for (int i = 0; i < model.getRequestedPlayers ().size (); i++) {
                requestedPlayerStrength += model.getRequestedPlayers ().get (i).getPlayerStrength ();
            }

            if (offeredPlayerStrength > requestedPlayerStrength) {
                logger.info ("Trade Accepted");
                leagueModel = tradeAccepted (leagueModel, initiateTeam, offeredTeam);
            } else {
                leagueModel = tradeRejected (leagueModel, initiateTeam, offeredTeam);
            }
        }
        return leagueModel;
    }

    @Override
    public ILeagueModel tradeRejected(ILeagueModel leagueModel, ITeamsModel initiateTeam, ITeamsModel offeredTeam) {
        float randomAcceptanceChance = leagueModel.getGameplayConfig ().getTrading ().getRandomAcceptanceChance ();

        if (Math.random () < randomAcceptanceChance) {
            System.out.println ("Trade Accepted");
            leagueModel = tradeAccepted (leagueModel, initiateTeam, offeredTeam);
        } else {
            System.out.println ("Trade Rejected");
        }
        return leagueModel;
    }


    public ILeagueModel tradeAccepted(ILeagueModel league, ITeamsModel initiateTeam, ITeamsModel offeredTeam) {

        logger.info ("Players requested:");
        System.out.println ("Players requested:");
        for (int i = 0; i < model.getRequestedPlayers ().size (); i++) {
            System.out.println ("Player name:" + model.getRequestedPlayers ().get (i).getPlayerName ());
            System.out.println ("Player position:" + model.getRequestedPlayers ().get (i).getPosition ());
        }
        boolean successTeam1 = false;
        boolean successTeam2 = false;

        for (ConferenceModel conference : league.getConferences ()) {
            for (DivisonModel division : conference.getDivisions ()) {
                for (TeamsModel team : division.getTeams ()) {
                    if (team.equals (initiateTeam)) {
                        successTeam1 = swapTeam (team, model.getRequestedPlayers (), model.getOfferedPlayer ());
                        teamsValidator.isCaptainPresent (team.getPlayers ());
                        teamsValidator.NoOfPlayersInTeam (team.getPlayers (), league);
                        team.calculateTeamStrength (team);
                    }
                    if (team.equals (offeredTeam)) {
                        successTeam2 = swapTeam (team, model.getOfferedPlayer (), model.getRequestedPlayers ());
                        teamsValidator.isCaptainPresent (team.getPlayers ());
                        teamsValidator.NoOfPlayersInTeam (team.getPlayers (), league);
                        team.calculateTeamStrength (team);
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
        if (team1.isEmpty () == false) {
            for (int i = 0; i < team1.size (); i++) {
                PlayerModel player1 = team1.get (i);
                t1.add (player1);
            }
        }

        if (team2.isEmpty () == false) {
            for (int i = 0; i < team2.size (); i++) {
                PlayerModel player2 = team2.get (i);
                for (int j = 0; j < t1.size (); j++) {
                    if (player2.equals (t1.get (j))) {
                        t1.remove (player2);
                        break;
                    }
                }
            }
        }
        team.setPlayers (t1);
        return true;
    }
}



