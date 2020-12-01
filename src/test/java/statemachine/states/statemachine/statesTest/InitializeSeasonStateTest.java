package statemachine.states.statemachine.statesTest;

import org.junit.jupiter.api.Test;
import statemachine.states.statemachine.StateMachine;
import statemachine.states.statemachine.states.ImportJsonState;
import statemachine.states.statemachine.states.InitializeSeasonState;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class InitializeSeasonStateTest {

    @Test
    void getStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getInitlailizeSeasonState());
            assertTrue(stateMachine.getCurrentState() instanceof InitializeSeasonState);
        } catch (Exception exception) {
            fail("State is not valid. Got an Exception");
        }
    }

    @Test
    void setStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getInitlailizeSeasonState());
            assertTrue(stateMachine.getCurrentState() instanceof InitializeSeasonState);
        } catch (Exception exception) {
            fail("State not set for import Json. Got an Exception");
        }
    }

}
