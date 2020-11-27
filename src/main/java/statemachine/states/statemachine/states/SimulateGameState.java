package statemachine.states.statemachine.states;

import leagueobjectmodel.*;
import statemachine.states.statemachine.states.simulateGame.GameSimulationAbstractFactory;
import statemachine.states.statemachine.states.simulateGame.GameSimulationAbstractFactoryConcrete;
import statemachine.states.statemachine.states.simulateGame.IStartSimulation;
import statemachine.states.statemachine.states.simulateGame.StartSimulation;

import statemachine.states.statemachine.StateMachine;

import java.util.Random;

public class SimulateGameState implements ITransition {
    StateMachine stateMachine;
    LeagueModel leagueModel;
    TeamsModel teamOne;
    TeamsModel teamTwo;
    boolean isThisPlayOff;
    TeamsModel winnerTeam;
    TeamsModel losserTeam;
    ITransition injuryCheckState;
    ITeamsModel teamsModel;

    public SimulateGameState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

//    public SimulateGameState(StateMachine stateMachine, LeagueModel leagueModel, TeamsModel teamsModelOne, TeamsModel teamsModelTwo) {
//        this.stateMachine = stateMachine;
//        this.leagueModel = leagueModel;
//        this.teamOne = teamsModelOne;
//        this.teamTwo = teamsModelTwo;
//    }

    GameSimulationAbstractFactory gameSimulationAbstractFactory=new GameSimulationAbstractFactoryConcrete();
    public void updateSimulateGameStateValue(StateMachine stateMachine, LeagueModel leagueModel, TeamsModel teamsModelOne, TeamsModel teamsModelTwo,boolean isPlayOff){
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
        this.teamOne = teamsModelOne;
        this.teamTwo = teamsModelTwo;
        isThisPlayOff=isPlayOff;
    }
    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
//        float teamOneStrength = getTeamStrength(teamOne);
//        float teamTwoStrength = getTeamStrength(teamTwo);
//
//        GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
//        GameResolverModel gameResolverModel = gamePlayConfigModel.getGameResolver();
//        float randomChanceToWin = gameResolverModel.getRandomWinChance();
//        Random randomObj = new Random();
//        float floatRandomValue = randomObj.nextFloat();
//        if (teamOneStrength > teamTwoStrength) {
//            if (floatRandomValue > randomChanceToWin) {
//                winnerTeam = teamOne;
//                losserTeam = teamTwo;
//            } else {
//                winnerTeam = teamTwo;
//                losserTeam = teamOne;
//            }
//        } else {
//            if (floatRandomValue > randomChanceToWin) {
//                winnerTeam = teamTwo;
//                losserTeam = teamOne;
//            } else {
//                winnerTeam = teamOne;
//                losserTeam = teamTwo;
//            }
//        }
//        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
//            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
//                for (TeamsModel teamsModel : divisonModel.getTeams()) {
//                    if (teamsModel.getTeamName().equals(winnerTeam.getTeamName())) {
//                        teamsModel.setWinPoint(teamsModel.getWinPoint() + 2);
//                    }
//                    if (teamsModel.getTeamName().equals(losserTeam.getTeamName())) {
//                        teamsModel.setLossPoint(teamsModel.getLossPoint() + 1);
//                        teamsModel.setLossPointForTrading(teamsModel.getLossPointForTrading() + 1);
//
//                    }
//                }
//            }
//        }
//
//        stateMachine.getUpdateStateValue().updateInjuryCheckStateValue(stateMachine, leagueModel, teamOne);
//        stateMachine.setCurrentState(stateMachine.getInjuryCheckState());
//        stateMachine.getCurrentState().entry();
//
//        stateMachine.getUpdateStateValue().updateInjuryCheckStateValue(stateMachine, leagueModel, teamTwo);
//        stateMachine.setCurrentState(stateMachine.getInjuryCheckState());
//        stateMachine.getCurrentState().entry();
//
        float teamOneStrength = getTeamStrength(teamOne);
        float teamTwoStrength = getTeamStrength(teamTwo);

        GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GameResolverModel gameResolverModel = gamePlayConfigModel.getGameResolver();
       //Change Value

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
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                for (TeamsModel teamsModel : divisonModel.getTeams()) {
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

        stateMachine.getUpdateStateValue().updateInjuryCheckStateValue(stateMachine, leagueModel, teamOne);
        stateMachine.setCurrentState(stateMachine.getInjuryCheckState());
        stateMachine.getCurrentState().entry();

        stateMachine.getUpdateStateValue().updateInjuryCheckStateValue(stateMachine, leagueModel, teamTwo);
        stateMachine.setCurrentState(stateMachine.getInjuryCheckState());
        stateMachine.getCurrentState().entry();
        IStartSimulation obj = null;
        obj = GameSimulationAbstractFactory.getGameSimulationInstance().getStartSimulation();
        try {
           obj.setRequiredAttributeForSimulation(teamOne,teamTwo,leagueModel,isThisPlayOff,gameSimulationAbstractFactory);
            obj.separatePlayerByPosition();
            obj.setAverageShotsOnGoal();
            obj.initializeShifts();
        }catch (NullPointerException exception){
            System.out.println("Exception in the game simulation abstract factory"+exception.getMessage());
        }
        catch (Exception e){
            System.out.println("Exception while initializing constructor of the game simulation "+e.getMessage());
        }

    }

    @Override
    public void exit() {
    }

    public float getTeamStrength(TeamsModel teamsModel) {
        teamsModel.calculateTeamStrength(teamsModel);
        return teamsModel.getTeamStrength();
    }
}
