package statemachine.states.states;

import leagueobjectmodel.*;
import org.apache.log4j.Logger;
import statemachine.states.StateMachine;
import statemachine.simulateGame.GameSimulationAbstractFactory;
import statemachine.simulateGame.IStartSimulation;

import java.util.Random;

public class SimulateGameState implements ITransition {
    StateMachine stateMachine;
    LeagueModel leagueModel;
    TeamsModel teamOne;
    TeamsModel teamTwo;
    boolean isThisPlayOff;
    TeamsModel winnerTeam;
    TeamsModel losserTeam;
    ILeagueModel iLeagueModel;
    final static Logger logger = Logger.getLogger(SimulateGameState.class);

    public SimulateGameState(StateMachine stateMachine) {
        logger.info("Initializing SimulateGame State");
        this.stateMachine = stateMachine;
        iLeagueModel = LeagueObjectModelAbstractFactory.getInstance().getLeague();
    }

    public void updateSimulateGameStateValue(StateMachine stateMachine, ILeagueModel leagueModel, ITeamsModel teamsModelOne, ITeamsModel teamsModelTwo, boolean isPlayOff) {
        this.stateMachine = stateMachine;
        this.leagueModel = (LeagueModel) leagueModel;
        this.teamOne = (TeamsModel) teamsModelOne;
        this.teamTwo = (TeamsModel) teamsModelTwo;
        isThisPlayOff = isPlayOff;
    }

    @Override
    public void entry() throws Exception {
        task();
    }

    @Override
    public void task() throws Exception {
        float teamOneStrength = getTeamStrength(teamOne);
        float teamTwoStrength = getTeamStrength(teamTwo);

        IGamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        float randomChanceToWin = 0.1f;
        Random randomObj = new Random();
        float floatRandomValue = randomObj.nextFloat();
        if (teamOneStrength > teamTwoStrength) {
            if (floatRandomValue > randomChanceToWin) {
                winnerTeam = teamOne;
                losserTeam = teamTwo;
            } else {
                winnerTeam = teamTwo;
                losserTeam = teamOne;
            }
        } else {
            if (floatRandomValue > randomChanceToWin) {
                winnerTeam = teamTwo;
                losserTeam = teamOne;
            } else {
                winnerTeam = teamOne;
                losserTeam = teamTwo;
            }
        }

        try {
        for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                for (ITeamsModel teamsModel : divisonModel.getTeams()) {
                    if (teamsModel.getTeamName().equals(winnerTeam.getTeamName())) {
                        teamsModel.setWinPoint(teamsModel.getWinPoint() + 2);
                    }
                    if (teamsModel.getTeamName().equals(losserTeam.getTeamName())) {
                        teamsModel.setLossPoint(teamsModel.getLossPoint() + 1);
                        teamsModel.setLossPointForTrading(teamsModel.getLossPointForTrading() + 1);
                        }
                    }
                }
            }
        }catch (Exception e){
            logger.error("Exception while parsing the league model object");
            throw e;
        }


        stateMachine.getUpdateStateValue().updateInjuryCheckStateValue(stateMachine, leagueModel, teamOne);
        stateMachine.setCurrentState(stateMachine.getInjuryCheckState());
        stateMachine.getCurrentState().entry();

        stateMachine.getUpdateStateValue().updateInjuryCheckStateValue(stateMachine, leagueModel, teamTwo);
        stateMachine.setCurrentState(stateMachine.getInjuryCheckState());
        stateMachine.getCurrentState().entry();
        exit();

    }

    @Override
    public void exit() throws Exception {
        IStartSimulation startSimulationObj = GameSimulationAbstractFactory.getGameSimulationInstance().getStartSimulation();
        try {
            startSimulationObj.setRequiredAttributeForSimulation(teamOne, teamTwo, leagueModel, isThisPlayOff, GameSimulationAbstractFactory.getGameSimulationInstance());
            startSimulationObj.separatePlayerByPosition();
            startSimulationObj.setAverageShotsOnGoal();
            startSimulationObj.initializeShifts();
        } catch (Exception exception) {
            logger.error("Exception while simulating game");
            throw exception;
        }
    }

    public float getTeamStrength(ITeamsModel teamsModel) {
        if(teamsModel==null){
            logger.error("TeamModel is not intialized int the getTeamStregth");
            throw new NullPointerException();
        }
        teamsModel.calculateTeamStrength(teamsModel);
        return teamsModel.getTeamStrength();
    }
}
