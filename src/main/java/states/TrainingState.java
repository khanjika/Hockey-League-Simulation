package states;

import league.LeagueModel;
import statemachine.StateMachine;

import java.time.LocalDate;

public class TrainingState implements ITransition {

    StateMachine stateMachine;

    public TrainingState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public TrainingState(LeagueModel leagueModel, LocalDate currentDate, LocalDate deadline) {

    }


    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {

    }

    @Override
    public void exit() {

    }
}
