package states;

import gameplayconfig.GamePlayConfigModel;
import gameplayconfig.GameResolverModel;
import league.LeagueModel;
import statemachine.StateMachine;
import teams.TeamsModel;

import java.time.LocalDate;
import java.util.Random;

public class SimulateGameState implements ITransition {
    StateMachine stateMachine;
    LeagueModel leagueModel;
    TeamsModel teamOne;
    TeamsModel teamTwo;
    TeamsModel winnerTeam;
    ITransition injuryCheckState;

    public SimulateGameState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public SimulateGameState(StateMachine stateMachine, LeagueModel leagueModel,TeamsModel teamsModelOne, TeamsModel teamsModelTwo) {
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
        this.teamOne = teamsModelOne;
        this.teamTwo = teamsModelTwo;
    }
//    public void setTeamModelInformation(TeamsModel teamsModelOne, TeamsModel teamsModelTwo) {
//        this.teamOne = teamsModelOne;
//        this.teamTwo = teamsModelTwo;
//    }

    @Override
    public void entry() {
        System.out.println("Inside Simulate Game state league model address=>"+leagueModel);
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
        //and once that complete i need to call injury check with three argument. LeagueModel, TeamModel, Date
        injuryCheckState=new InjuryCheckState(stateMachine,leagueModel,teamOne);
        stateMachine.setSimulateGameState(injuryCheckState);
        stateMachine.setCurrentState(stateMachine.getInjuryCheckState());
        stateMachine.getCurrentState().entry();

        //Second team
        injuryCheckState=new InjuryCheckState(stateMachine,leagueModel,teamTwo);
        stateMachine.setSimulateGameState(injuryCheckState);
        stateMachine.setCurrentState(stateMachine.getInjuryCheckState());
        stateMachine.getCurrentState().entry();

    }

    @Override
    public void exit() {

    }


    //Dummy Method for team strength calculation Will be replaced By zankruts Code
    int dummyTeamStrenght(TeamsModel teamsModel) {
        return 0;
    }
}
