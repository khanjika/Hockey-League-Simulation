package states;

import conference.ConferenceModel;
import divison.DivisonModel;
import league.LeagueModel;
import players.IPlayerModel;
import players.PlayerModel;
import statemachine.StateMachine;
import teams.TeamsModel;

import java.time.LocalDate;

//here first i need to pass two parameter first will be the leageu model object so
// the the placyer can be injured the second will be the teammodel object.
//this thing will be called for both the team model.
//the third argument will be the date at which the player is injured.

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
     //   System.out.println("Injury check state constructor "+leagueModel+"      " + stateMachine+"  "+ teamsModel);
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
        this.teamsModelTemp=teamsModel;
        currentDate =stateMachine.getCurrentDate();
    }

    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
      //  System.out.println("Inside injury check method:"+leagueModel);

        //recover Player(LeagueMOdel, TeamModel,LocalDATE)
        //there is no need to retun anything.
        playerModel=new PlayerModel();
      //  playerModel.checkPlayerInjury();
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
        //checkPlayerInjury(leagueModel,teamsModel,currentDate);
    }

    @Override
    public void exit() {
    }
}
