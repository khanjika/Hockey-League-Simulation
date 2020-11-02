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
//    public void setTeamModelInformation(TeamsModel teamsModelOne, TeamsModel teamsModelTwo) {
//        this.teamOne = teamsModelOne;
//        this.teamTwo = teamsModelTwo;
//    }

    @Override
    public void entry() {
        //   System.out.println("Inside Simulate Game state league model address=>"+leagueModel);
        task();
    }

    //Here somewhere i need to update league Model with win and loss points
    @Override
    public void task() {
        float teamOneStrength = getTeamStrenght(teamOne);
        float teamTwoStrength = getTeamStrenght(teamTwo);
        //  System.out.println("team One name is "+teamOne.getTeamName()+"And Strength is "+teamOneStrength);
        //   System.out.println("team One name is "+teamTwo.getTeamName()+"And Strength is "+teamTwoStrength);
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
        //Updating Win and Loss Point
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                for (TeamsModel teamsModel : divisonModel.getTeams()) {
                    if (teamsModel.getTeamName().equals(winnerTeam.getTeamName())) {
                        teamsModel.setWinPoint(teamsModel.getWinPoint() + 2);
                    }
                    if (teamsModel.getTeamName().equals(losserTeam.getTeamName())) {
                        teamsModel.setLossPoint(teamsModel.getLossPoint() + 1);
                    }
                }
            }
        }

        //System.out.println("Calling Injury From the simulate state");
        //here once the match is complete i need to increment the loss count value and win count value.
        //and once that complete i need to call injury check with three argument. LeagueModel, TeamModel, Date
        // System.out.println("Calling Injury check from simulate game state"+teamOne.getTeamName());
        injuryCheckState = new InjuryCheckState(stateMachine, leagueModel, teamOne);
        stateMachine.setInjuryCheckState(injuryCheckState);
        stateMachine.setCurrentState(stateMachine.getInjuryCheckState());
        stateMachine.getCurrentState().entry();

        //Second team
        // System.out.println("Calling Injury check from simulate game state"+teamTwo.getTeamName());
        injuryCheckState = new InjuryCheckState(stateMachine, leagueModel, teamTwo);
        stateMachine.setSimulateGameState(injuryCheckState);
        stateMachine.setCurrentState(stateMachine.getInjuryCheckState());
        stateMachine.getCurrentState().entry();

    }

    @Override
    public void exit() {

    }

    float getTeamStrenght(TeamsModel teamsModel) {
        teamsModel.calculateTeamStrength(teamsModel);
        return teamsModel.getTeamStrength();
    }
}
