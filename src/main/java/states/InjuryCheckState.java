package states;

import league.LeagueModel;
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
    TeamsModel teamsModel;
    LocalDate currentDate;
    public InjuryCheckState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }
    public InjuryCheckState(StateMachine stateMachine, LeagueModel leagueModel,TeamsModel teamsModel) {
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
        this.teamsModel=teamsModel;
        currentDate =stateMachine.getCurrentDate();
        System.out.println(currentDate);
    }

    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        //there is no need to retun anything.
        checkPlayerInjury(leagueModel,teamsModel,currentDate);
    }

    @Override
    public void exit() {
    }
    //Dummy method that will be replaced by zankrut's code
    public LeagueModel checkPlayerInjury(LeagueModel leagueModel, TeamsModel teamsModel, LocalDate date) {
        //this method will check for injury and if any injury has occured it will modify the league model object
        return leagueModel;
    }
}
