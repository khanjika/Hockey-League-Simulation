package states;

import statemachine.StateMachine;

public class CreateTeamState implements ITransition {
    StateMachine stateMachine;

    public CreateTeamState(StateMachine stateMachine) {
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
        System.out.println("prompt for team data");
    }

    @Override
    public void task() {
        System.out.println("instantiate league model");
    }

    @Override
    public void exit() {
        System.out.println("persist data");
        stateMachine.setCurrentState(stateMachine.newTeamCreated());
    }
}
