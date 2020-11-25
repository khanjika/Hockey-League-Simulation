package statemachine.states;

import leagueobjectmodel.*;
import statemachine.StateMachine;
import java.util.Random;

public class SimulateGameState implements ITransition {
    StateMachine stateMachine;
    ILeagueModel leagueModel;
    ITeamsModel teamOne;
    ITeamsModel teamTwo;
    ITeamsModel winnerTeam;
    ITeamsModel losserTeam;
    ILeagueModel iLeagueModel;

    public SimulateGameState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        iLeagueModel = LeagueObjectModelAbstractFactory.getInstance().getLeague();
    }

//    public SimulateGameState(StateMachine stateMachine, LeagueModel leagueModel, TeamsModel teamsModelOne, TeamsModel teamsModelTwo) {
//        this.stateMachine = stateMachine;
//        this.leagueModel = leagueModel;
//        this.teamOne = teamsModelOne;
//        this.teamTwo = teamsModelTwo;
//    }

    public void updateSimulateGameStateValue(StateMachine stateMachine, ILeagueModel leagueModel, ITeamsModel teamsModelOne, ITeamsModel teamsModelTwo){
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
        this.teamOne = teamsModelOne;
        this.teamTwo = teamsModelTwo;
    }
    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
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


        iLeagueModel.storeLeagueInformation(leagueModel);

    }

    @Override
    public void exit() {
    }

    public float getTeamStrength(ITeamsModel teamsModel) {
        teamsModel.calculateTeamStrength(teamsModel);
        return teamsModel.getTeamStrength();
    }
}
