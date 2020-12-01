package statemachine.states.statesTest;

import org.junit.jupiter.api.Test;
import statemachine.states.StateMachine;
import statemachine.states.states.TradingState;
import statemachine.states.states.TrainingState;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class TrainingStateTest {
    @Test
    void getStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getTradingState());
            assertTrue(stateMachine.getCurrentState() instanceof TradingState);
        } catch (Exception exception) {
            fail("State is not valid. Got an Exception");
        }
    }

    @Test
    void setStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getTrainingState());
            assertTrue(stateMachine.getCurrentState() instanceof TrainingState);
        } catch (Exception exception) {
            fail("State not set for import Json. Got an Exception");
        }
    }

}
