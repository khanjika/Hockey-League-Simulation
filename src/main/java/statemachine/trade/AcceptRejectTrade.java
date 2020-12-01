package statemachine.trade;

import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.List;

public class AcceptRejectTrade implements IAcceptRejectTrade {

    private static final Logger logger = Logger.getLogger (AcceptRejectTrade.class);
    private ITradeModel model;
    private ITeamsValidator teamsValidator;

    public AcceptRejectTrade() {
        model = TradeAbstractFactory.instance ().createTradeModel ();
        teamsValidator = LeagueObjectModelAbstractFactory.getInstance ().getTeamsValidator ();
    }

    @Override
    public ILeagueModel acceptRejectTrade(ILeagueModel leagueModel, ITeamsModel initiateTeam, ITeamsModel offeredTeam) {
        float offeredPlayerStrength = 0;
        float requestedPlayerStrength = 0;

        logger.info ("Players requested in the trade from " + offeredTeam.getTeamName ());
        for (int i = 0; i < model.getRequestedPlayers ().size (); i++) {
            logger.info ("Player name: " + model.getRequestedPlayers ().get (i).getPlayerName ());
            logger.info ("Player position: " + model.getRequestedPlayers ().get (i).getPosition ());
        }

        if (model.getOfferedPlayer ().isEmpty () == true) {
            leagueModel = tradeAccepted (leagueModel, initiateTeam, offeredTeam);
        } else {

            logger.info ("Players offered in the trade by " + initiateTeam.getTeamName ());
            for (int i = 0; i < model.getOfferedPlayer ().size (); i++) {
                logger.info ("Player name: " + model.getOfferedPlayer ().get (i).getPlayerName ());
                logger.info ("Player position: " + model.getOfferedPlayer ().get (i).getPosition ());
            }

            for (int i = 0; i < model.getOfferedPlayer ().size (); i++) {
                offeredPlayerStrength += model.getOfferedPlayer ().get (i).getPlayerStrength ();
            }

            for (int i = 0; i < model.getRequestedPlayers ().size (); i++) {
                requestedPlayerStrength += model.getRequestedPlayers ().get (i).getPlayerStrength ();
            }

            if (offeredPlayerStrength > requestedPlayerStrength) {
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
            leagueModel = tradeAccepted (leagueModel, initiateTeam, offeredTeam);
        } else {
            logger.info ("Trade is rejected by team: " + offeredTeam.getTeamName ());
        }
        return leagueModel;
    }


    public ILeagueModel tradeAccepted(ILeagueModel league, ITeamsModel initiateTeam, ITeamsModel offeredTeam) {
        logger.info ("Trade is accepted by team: " + offeredTeam.getTeamName ());
        boolean successTeam1 = false;
        boolean successTeam2 = false;

        for (IConferenceModel conference : league.getConferences ()) {
            for (IDivisonModel division : conference.getDivisions ()) {
                for (ITeamsModel team : division.getTeams ()) {
                    if (team.equals (initiateTeam)) {
                        successTeam1 = swapTeam (team, model.getRequestedPlayers (), model.getOfferedPlayer ());
                        teamsValidator.isCaptainPresent (team.getPlayers ());
                        teamsValidator.NoOfPlayersInTeam (team.getPlayers (), league);
                        logger.info ("The number of players in " + team.getTeamName () + " after resolving the team's roaster: " + team.getPlayers ().size ());
                        team.calculateTeamStrength (team);
                    }
                    if (team.equals (offeredTeam)) {
                        successTeam2 = swapTeam (team, model.getOfferedPlayer (), model.getRequestedPlayers ());
                        teamsValidator.isCaptainPresent (team.getPlayers ());
                        teamsValidator.NoOfPlayersInTeam (team.getPlayers (), league);
                        logger.info ("The number of players in " + team.getTeamName () + " after resolving the team's roaster: " + team.getPlayers ().size ());
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



