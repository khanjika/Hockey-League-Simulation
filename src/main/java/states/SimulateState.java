package states;

import statemachine.NestedSimulator;
import statemachine.StateMachine;
//import states.ITransition;
//import sun.security.rsa.RSAUtil;

public class SimulateState implements ITransition {
    StateMachine stateMachine;
    NestedSimulator nestedSimulator;
    PlayerSeasonsChoiceState playerSeasonsChoiceState;

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public NestedSimulator getNestedSimulator() {
        return nestedSimulator;
    }

    public void setNestedSimulator(NestedSimulator nestedSimulator) {
        this.nestedSimulator = nestedSimulator;
    }

    public SimulateState(StateMachine newStateMachine){
        stateMachine = newStateMachine;
    }

    @Override
    public void entry() {
        System.out.println("Simulation started");
        nestedSimulator = new NestedSimulator(playerSeasonsChoiceState.getEnteredInput());
        task();
    }

    @Override
    public void task() {

    }

    @Override
    public void exit() {

    }
}
