package states;

import league.LeagueModel;
import statemachine.StateMachine;

import java.time.LocalDate;

public class TrainingState implements ITransition {

    StateMachine stateMachine;
    LeagueModel leagueModel;

    public TrainingState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public TrainingState(StateMachine stateMachine,LeagueModel leagueModel) {
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
    }


    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        //call the method to perform training.
    }

    @Override
    public void exit() {

    }


    //Dummy method will be replaced by Arth's code
    void performTraining(LeagueModel leagueModel){
        //perform task
    }
}
