package states;

import gameplayconfig.GamePlayConfigModel;
import gameplayconfig.GameResolverModel;
import league.LeagueModel;
import statemachine.StateMachine;
import teams.TeamsModel;

import java.util.Random;

public class SimulateGameState implements ITransition {
    StateMachine stateMachine;
    LeagueModel leagueModel;
    TeamsModel teamOne;
    TeamsModel teamTwo;
    TeamsModel winnerTeam;

    public SimulateGameState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public SimulateGameState(StateMachine stateMachine, LeagueModel leagueModel) {
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
    }

    public void SetTeamModelInformation(TeamsModel teamsModelOne, TeamsModel teamsModelTwo) {
        this.teamOne = teamsModelOne;
        this.teamTwo = teamsModelTwo;
    }

    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        int teamOneStrength = dummyTeamStrenght(teamOne);
        int teamTwoStrength = dummyTeamStrenght(teamTwo);
        GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GameResolverModel gameResolverModel = gamePlayConfigModel.getGameResolver();
        float randomChanceToWin = gameResolverModel.getRandomWinChance();
        Random randomObj =new Random();
        float floatRandomValue= randomObj.nextFloat();
        if(teamOneStrength>teamTwoStrength){
                if(floatRandomValue>randomChanceToWin){
                        winnerTeam=teamOne;
                }
                else
                {
                    winnerTeam=teamTwo;
                }
        }
        //here once the match is complete i need to increment the loss count value and win count value.
    }

    @Override
    public void exit() {

    }


    //Dummy Method for team strength calculation
    int dummyTeamStrenght(TeamsModel teamsModel) {
        return 0;
    }
}
