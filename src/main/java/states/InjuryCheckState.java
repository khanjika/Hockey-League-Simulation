package states;

import statemachine.StateMachine;

public class InjuryCheckState implements ITransition {
    StateMachine stateMachine;

    public InjuryCheckState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    //here first i need to pass two parameter first will be the leageu model object so
    // the the placyer can be injured the second will be the teammodel object.

    //this thing will be called for both the team model.
    @Override
    public void entry() {

    }

    @Override
    public void task() {

    }

    @Override
    public void exit() {

    }
}
