package statemachine.states.statesTest;

import org.junit.jupiter.api.Test;
import statemachine.states.StateMachine;
import statemachine.states.states.AgingState;

import static org.junit.jupiter.api.Assertions.*;

class AgingStateTest {

    @Test
    void getAgingState() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getAgingState());
            assertTrue(stateMachine.getCurrentState() instanceof AgingState);
        } catch (Exception exception) {
            fail("State is not valid. Got an Exception");
        }
    }

    @Test
    void setStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getAgingState());
            assertTrue(stateMachine.getCurrentState() instanceof AgingState);
        } catch (Exception exception) {
            fail("State not set for create team. Got an Exception");
        }
    }


}
