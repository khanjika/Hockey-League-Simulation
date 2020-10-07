package states;

import statemachine.StateMachine;

public class ImportJsonState implements ITransition {
    StateMachine stateMachine;

    public ImportJsonState(StateMachine newStateMachine) {
        stateMachine = newStateMachine;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void entry() {
        System.out.println("Parse Json Import");
    }

    @Override
    public void task() {
        System.out.println("instantiate and configure league model");
    }

    @Override
    public void exit() {
        System.out.println("persist to database");
        stateMachine.setCurrentState(stateMachine.fileImported());
    }
}
