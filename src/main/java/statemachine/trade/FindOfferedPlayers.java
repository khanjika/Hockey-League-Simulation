package statemachine.trade;

import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindOfferedPlayers implements IFindOfferedPlayers {

    private static final Logger logger = Logger.getLogger (FindOfferedPlayers.class);
    private ITeamsModel teamsModel;
    private IFreeAgentModel freeAgent;
    private ITradeModel model;
    private ICalculateStrength calculateStrength;
    private IFindTeamToSwap findTeamToSwap;

    private enum playerPosition {
        forward,
        defense,
        goalie
    }

    public FindOfferedPlayers() {
        freeAgent = LeagueObjectModelAbstractFactory.getInstance ().getFreeAgent ();
        teamsModel = LeagueObjectModelAbstractFactory.getInstance ().getTeams ();
        findTeamToSwap = TradeAbstractFactory.instance ().createTeamToSwap ();
        model = TradeAbstractFactory.instance ().createTradeModel ();
        calculateStrength = TradeAbstractFactory.instance ().createStrength ();
    }

    @Override
    public ILeagueModel findPossibleTrade(ILeagueModel league, ITeamsModel team) {
        List<FreeAgentModel> freeAgents = league.getFreeAgents ();

        for (FreeAgentModel agent : freeAgents) {
            agent.calculateFreeAgentStrength (agent);
        }

        HashMap<String, Float> strengthMap = calculateStrength.findPositionStrength (team);
        int totalCounter = identifyTypeOfTrade (strengthMap, league, team);
        league = findTeamToSwap.find (league, totalCounter, team);
        return league;
    }

    @Override
    public int identifyTypeOfTrade(HashMap strengthMap, ILeagueModel league, ITeamsModel team) {
        int totalCounter = calculateStrength.totalStrengthCounter (team, strengthMap, league);
        List<PlayerModel> offeredPlayer = new ArrayList<> ();

        if (totalCounter > 0) {
            logger.info ("Trade Player");
            if (team.getIsForwardStrong () == 1) {
                setOfferedPlayers (playerPosition.forward.toString (), offeredPlayer, league, team);
            }
            if (team.getIsDefenseStrong () == 1) {
                setOfferedPlayers (playerPosition.defense.toString (), offeredPlayer, league, team);
            }
            if (team.getIsGoalieStrong () == 1) {
                setOfferedPlayers (playerPosition.goalie.toString (), offeredPlayer, league, team);
            }
        } else {
            logger.info ("Trade Draft pick");
        }
        return totalCounter;
    }

    @Override
    public List<PlayerModel> setOfferedPlayers(String position, List<PlayerModel> offeredPlayer, ILeagueModel league, ITeamsModel team) {
        float playerStrength;
        float freeAgentStrength = 0;
        int counter = 0;
        List<FreeAgentModel> freeAgents = league.getFreeAgents ();
        int maxPlayersToTrade = league.getGameplayConfig ().getTrading ().getMaxPlayersPerTrade ();
        List<PlayerModel> playerList = team.getPlayers ();

        teamsModel.sortPlayersOfTeamDescending (playerList);
        freeAgent.sortFreeAgentDescending (freeAgents);

        for (int i = 0; i < freeAgents.size (); i++) {
            if (freeAgents.get (i).getPosition ().equals (position)) {
                freeAgentStrength = freeAgents.get (i).getFreeAgentStrength ();
                break;
            }
        }

        for (int i = 0; i < playerList.size (); i++) {
            if (playerList.get (i).getPosition ().equals (position)) {
                if (counter >= 1) {
                    playerStrength = playerList.get (i).getPlayerStrength ();
                    if (freeAgentStrength >= playerStrength) {
                        PlayerModel p = playerList.get (i);
                        offeredPlayer.add (p);
                        model.setOfferedPlayer (offeredPlayer);
                        if (counter == 1 || model.getOfferedPlayer ().size () == 2 || model.getOfferedPlayer ().size () == maxPlayersToTrade) {
                            return offeredPlayer;
                        }
                    }
                }
                counter += 1;
            }
        }
        return offeredPlayer;
    }
}
