package states;

import league.LeagueModel;
import statemachine.StateMachine;

import java.time.LocalDate;

public class AgingState implements ITransition{

    StateMachine stateMachine;
    LeagueModel leagueModel;
    LocalDate currentDate;

    public AgingState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }
    public AgingState(StateMachine stateMachine, LeagueModel leagueModel) {
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
    }
    void setCurrentDate(LocalDate date){
        this.currentDate=date;
    }
    @Override
    public void entry() {
        task();
    }
    @Override
    public void task() {
        System.out.println("In the task method Of the Aging State");
    }
    @Override
    public void exit() {

    }
    //Dummy method which will be replaced by zankrut's method
    void performAging(LeagueModel leagueModel,LocalDate date){
        //perform task
    }


}
