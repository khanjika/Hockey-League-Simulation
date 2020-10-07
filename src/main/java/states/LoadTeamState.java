package states;

import statemachine.StateMachine;
import states.ITransition;

public class LoadTeamState implements ITransition {
    StateMachine stateMachine;

    public LoadTeamState(StateMachine stateMachine) {
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
        System.out.println("Prompt for team name");
    }

    @Override
    public void task() {
        System.out.println("load team data");
    }

    @Override
    public void exit() {
        System.out.println("instantiate model objects");
        stateMachine.setCurrentState(stateMachine.teamLoaded());
    }
}
