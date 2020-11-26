package statemachine.states.trade;


import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindOfferedPlayers implements IFindOfferedPlayers {

    private ITeamsModel teamsModel;
    private IFreeAgentModel freeAgentModel;
    private ITradeModel model;
    private ICalculateStrength calculateStrength;
    private ITradeTeamPojo teamDetails;
    private IFindTeamToSwap findTeamToSwap;
    private ITradeTeamPojo teamPojo;

    public FindOfferedPlayers() {
        freeAgentModel = LeagueObjectModelAbstractFactory.getInstance ().getFreeAgent ();
        findTeamToSwap = TradeAbstractFactory.getUniqueInstance ().getTeamToSwap ();
        teamsModel = LeagueObjectModelAbstractFactory.getInstance ().getTeams ();
        teamDetails = TradeAbstractFactory.getInstance ().getTeamPojo ();
        model = TradeAbstractFactory.getUniqueInstance ().getTradeModel ();
        calculateStrength = TradeAbstractFactory.getUniqueInstance ().getStrength ();
        teamPojo = TradeAbstractFactory.getUniqueInstance ().getTeamPojo ();
    }

    private static final Logger logger = Logger.getLogger (FindOfferedPlayers.class);

    private enum playerPosition {
        forward,
        defense,
        goalie
    }

    @Override
    public void findStrength(ILeagueModel league, ITeamsModel team, ITradeModel tradingTeamDetails) {
        HashMap<String, Float> strengthMap = calculateStrength.findStrength (team);
        identifyTypeOfTrade (strengthMap, league);
    }

    public void identifyTypeOfTrade(HashMap strengthMap, ILeagueModel league) {
        int totalCounter = calculateStrength.findStrengthWeakness (teamPojo, strengthMap);
        List<PlayerModel> offeredPlayer = new ArrayList<> ();
        model.setTradeInitiatingTeam (teamPojo);

        if (totalCounter == 1 || totalCounter == 2) {
            if (model.getTradeInitiatingTeam ().getIsForwardStrong () == 1) {
                settingOfferedPlayers (playerPosition.forward.toString (), offeredPlayer, league);
            }
            if (model.getTradeInitiatingTeam ().getIsDefenseStrong () == 1) {
                settingOfferedPlayers (playerPosition.defense.toString (), offeredPlayer, league);
            }
            if (model.getTradeInitiatingTeam ().getIsGoalieStrong () == 1) {
                settingOfferedPlayers (playerPosition.goalie.toString (), offeredPlayer, league);
            }
            findTeamToSwap.find (league);
        } else {
            logger.debug ("Draft pick");
        }
    }

    public void settingOfferedPlayers(String position, List<PlayerModel> offeredPlayer, ILeagueModel league) {
        List<FreeAgentModel> freeAgents = league.getFreeAgents ();
        int maxPlayersToTrade = league.getGameplayConfig ().getTrading ().getMaxPlayersPerTrade ();
        List<PlayerModel> playerList = model.getTradeInitiatingTeam ().getPlayersList ();
        float playerStrength;
        float freeAgentStrength = 0;
        int counter = 0;

        teamsModel.sortPlayersOfTeamDescending (playerList);

        for (FreeAgentModel agent : freeAgents) {
            agent.calculateFreeAgentStrength (agent);
        }

        freeAgentModel.sortFreeAgentDescending (freeAgents);
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
                            break;
                        }
                    }
                }
                counter += 1;
            }
        }
    }
}
