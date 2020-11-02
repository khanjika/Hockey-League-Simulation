package states;

import conference.ConferenceModel;
import divison.DivisonModel;
import league.LeagueModel;
import players.IPlayerModel;
import players.PlayerModel;
import statemachine.StateMachine;
import teams.TeamsModel;

import java.time.LocalDate;

public class InjuryCheckState implements ITransition {
    StateMachine stateMachine;
    LeagueModel leagueModel;
    TeamsModel teamsModelTemp;
    LocalDate currentDate;
    IPlayerModel playerModel;
    public InjuryCheckState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }
    public InjuryCheckState(StateMachine stateMachine, LeagueModel leagueModel,TeamsModel teamsModel) {
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
        this.teamsModelTemp=teamsModel;
        currentDate =stateMachine.getCurrentDate();
        System.out.println(currentDate);
    }

    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        playerModel=new PlayerModel();
        for(ConferenceModel conferenceModel:leagueModel.getConferences()){
            for(DivisonModel divisonModel:conferenceModel.getDivisions()){
                for(TeamsModel teamsModel:divisonModel.getTeams()){
                    if(teamsModel.getTeamName().equals(teamsModelTemp)){
                       for(PlayerModel playerModelTemp:teamsModel.getPlayers()){
                           playerModel.checkPlayerInjury(playerModelTemp,currentDate);
                       }
                    }
                }
            }
        }
    }

    @Override
    public void exit() { }
}
