package statemachine.trade;

import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindTeamToSwap implements IFindTeamToSwap {

    private static final Logger logger = Logger.getLogger (FindTeamToSwap.class);
    private static int flag = 0;
    private ITeamsModel teamsModel;
    private ITradeModel model;
    private ICalculateStrength calculateStrength;
    private IAcceptRejectTrade acceptRejectTrade;
    private IUserTradeCli userTradeCli;
    private ITeamsModel offeredTeam;

    private enum playerPosition {
        forward,
        defense,
        goalie
    }

    public FindTeamToSwap() {
        teamsModel = LeagueObjectModelAbstractFactory.getInstance ().getTeams ();
        model = TradeAbstractFactory.instance ().createTradeModel ();
        calculateStrength = TradeAbstractFactory.instance ().createStrength ();
        acceptRejectTrade = TradeAbstractFactory.instance ().createAcceptRejectTrade ();
        userTradeCli = TradeAbstractFactory.instance ().createUserTradeCli ();
    }

    @Override
    public ILeagueModel find(ILeagueModel league, int totalCounter, ITeamsModel team) {
        findTeamToTradePLayer (league, totalCounter, team);
        if (offeredTeam.isUserCreatedTeam ()) {
            int userInput = userTradeCli.displayTeamDetails ();
            if (userInput == 1) {
                league = acceptRejectTrade.tradeAccepted (league, team, offeredTeam);
            }
        } else {
            league = acceptRejectTrade.acceptRejectTrade (league, team, offeredTeam);
        }
        return league;
    }

    @Override
    public ITeamsModel findTeamToTradePLayer(ILeagueModel league, int totalCounter, ITeamsModel teamInitiatingTrade) {
        for (IConferenceModel conference : league.getConferences ()) {
            for (IDivisonModel division : conference.getDivisions ()) {
                for (ITeamsModel team : division.getTeams ()) {
                    if (team.equals (teamInitiatingTrade)) {
                    } else {
                        if (totalCounter < 1) {
                            findTeamToTradePick (team, teamInitiatingTrade);
                        } else {
                            if (totalCounter > 0) {
                                HashMap<String, Float> strengthMap = calculateStrength.findPositionStrength (team);
                                int totalStrengthCounter = calculateStrength.totalStrengthCounter (team, strengthMap, league);
                                if (totalStrengthCounter > 0) {
                                    selectTeam (team, teamInitiatingTrade);
                                }
                            } else {
                                findTeamToTradePick (team, teamInitiatingTrade);
                            }
                        }
                    }
                    if (flag == 1) {
                        offeredTeam = team;
                        break;
                    }
                }
                if (flag == 1) {
                    break;
                }
            }
            if (flag == 1) {
                flag = 0;
                break;
            }
        }
        return offeredTeam;
    }

    public void findTeamToTradePick(ITeamsModel team, ITeamsModel teamInitiating) {
        List<PlayerModel> listOfPlayers = new ArrayList<> ();
        float teamOfferedStrength = calculateStrength.findTeamStrength (team.getPlayers ());
        float teamInitiatingStrength = calculateStrength.findTeamStrength (teamInitiating.getPlayers ());
        if (teamOfferedStrength > teamInitiatingStrength) {
            List<PlayerModel> offeredTeamPlayer = teamsModel.sortPlayersOfTeamDescending (team.getPlayers ());
            ITeamsModel[] roundPick = teamInitiating.getDraftTrade ();
            for (int i = 6; i >= 0; i--) {
                if (roundPick[i] == null) {
                    roundPick[i] = team;
                    PlayerModel player = offeredTeamPlayer.get (i);
                    listOfPlayers.add (player);
                    model.setRequestedPlayers (listOfPlayers);
                    flag = 1;
                    break;
                }
            }
        }
    }

    @Override
    public List<PlayerModel> selectTeam(ITeamsModel team, ITeamsModel teamInitiatingTrade) {
        List<PlayerModel> requestedPlayers = new ArrayList<> ();
        if (teamInitiatingTrade.getIsGoalieStrong () == 0) {
            logger.debug ("Need a goalie to make the team strong !!");
            if (team.getIsGoalieStrong () == 1) {
                findSuitablePlayers (team, playerPosition.goalie.toString (), requestedPlayers, teamInitiatingTrade);
            }
        }
        if (teamInitiatingTrade.getIsForwardStrong () == 0) {
            logger.debug ("Need a forward player to make the team strong !!");
            if (team.getIsForwardStrong () == 1) {
                findSuitablePlayers (team, playerPosition.forward.toString (), requestedPlayers, teamInitiatingTrade);
            }
        }
        if (teamInitiatingTrade.getIsDefenseStrong () == 0) {
            logger.debug ("Need a defense player to make the team strong !!");
            if (team.getIsDefenseStrong () == 1) {
                findSuitablePlayers (team, playerPosition.defense.toString (), requestedPlayers, teamInitiatingTrade);
            }
        }
        return requestedPlayers;
    }

    public void findSuitablePlayers(ITeamsModel teams, String position, List<PlayerModel> requestedPlayers, ITeamsModel teamInitiatingTrade) {
        float initiatingWeakPositionStrength = 0;
        float possiblePlayerStrength;
        int counter = 0;

        List<PlayerModel> initiatingTeamPlayers = teamsModel.sortPlayersOfTeamDescending (teamInitiatingTrade.getPlayers ());
        List<PlayerModel> offeredTradeTeamPlayers = teamsModel.sortPlayersOfTeamDescending (teams.getPlayers ());
        List<PlayerModel> offeredPlayers = model.getOfferedPlayer ();
        List<PlayerModel> playersOfThatPosition = new ArrayList<> ();

        float teamStrength = calculateStrength.findTeamStrength (teams.getPlayers ());
        float offeredPlayerStrength = calculateStrength.findTeamStrength (offeredPlayers);

        for (int i = 0; i < initiatingTeamPlayers.size (); i++) {
            if (initiatingTeamPlayers.get (i).getPosition ().equals (position)) {
                if (counter == 1) {
                    initiatingWeakPositionStrength = initiatingTeamPlayers.get (i).getPlayerStrength ();
                    break;
                }
                counter += 1;
            }
        }

        for (int i = 0; i < offeredTradeTeamPlayers.size (); i++) {
            if (offeredTradeTeamPlayers.get (i).getPosition ().equals (position)) {
                playersOfThatPosition.add (offeredTradeTeamPlayers.get (i));
            }
        }

        for (int i = 1; i < playersOfThatPosition.size (); i++) {
            logger.debug ("Entered");
            possiblePlayerStrength = playersOfThatPosition.get (i).getPlayerStrength ();
            if (possiblePlayerStrength < initiatingWeakPositionStrength) {
                break;
            } else {
                float strength = teamStrength + offeredPlayerStrength - possiblePlayerStrength;
                if (strength > teamStrength) {
                    flag = 1;
                    PlayerModel p = playersOfThatPosition.get (i);
                    requestedPlayers.add (p);
                    model.setRequestedPlayers (requestedPlayers);
                    break;
                } else {
                    break;
                }
            }
        }
    }
}
