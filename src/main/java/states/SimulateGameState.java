package states;

import conference.ConferenceModel;
import divison.DivisonModel;
import gameplayconfig.GamePlayConfigModel;
import gameplayconfig.GameResolverModel;
import league.LeagueModel;
import statemachine.StateMachine;
import teams.ITeamsModel;
import teams.TeamsModel;
import java.util.Random;

public class SimulateGameState implements ITransition {
    StateMachine stateMachine;
    LeagueModel leagueModel;
    TeamsModel teamOne;
    TeamsModel teamTwo;
    TeamsModel winnerTeam;
    TeamsModel losserTeam;
    ITransition injuryCheckState;
    ITeamsModel teamsModel;

    public SimulateGameState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public SimulateGameState(StateMachine stateMachine, LeagueModel leagueModel, TeamsModel teamsModelOne, TeamsModel teamsModelTwo) {
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
        float randomChanceToWin = gameResolverModel.getRandomWinChance();
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

        injuryCheckState = new InjuryCheckState(stateMachine, leagueModel, teamOne);
        stateMachine.setInjuryCheckState(injuryCheckState);
        stateMachine.setCurrentState(stateMachine.getInjuryCheckState());
        stateMachine.getCurrentState().entry();

        injuryCheckState = new InjuryCheckState(stateMachine, leagueModel, teamTwo);
        stateMachine.setSimulateGameState(injuryCheckState);
        stateMachine.setCurrentState(stateMachine.getInjuryCheckState());
        stateMachine.getCurrentState().entry();



    }

    @Override
    public void exit() {
    }

   public float getTeamStrength(TeamsModel teamsModel) {
        teamsModel.calculateTeamStrength(teamsModel);
        return teamsModel.getTeamStrength();
    }
}
