package states;

import statemachine.StateMachine;
import states.ITransition;

public class PlayerSeasonsChoiceState implements ITransition {
    StateMachine stateMachine;

    public PlayerSeasonsChoiceState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void entry() {
        System.out.println("Output choice to user");
    }

    @Override
    public void task() {
        System.out.println("Wait for input");
    }

    @Override
    public void exit() {
        System.out.println("Transition to choice");
        // get choice from user and pass as parameter
        stateMachine.setCurrentState(stateMachine.simulateSeasons());
    }
}

