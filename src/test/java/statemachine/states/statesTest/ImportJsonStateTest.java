package statemachine.states.statesTest;

import org.junit.jupiter.api.Test;
import statemachine.states.StateMachine;
import statemachine.states.states.ImportJsonState;

import static org.junit.jupiter.api.Assertions.*;

public class ImportJsonStateTest {

    @Test
    void getStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getImportJson());
            assertTrue(stateMachine.getCurrentState() instanceof ImportJsonState);
        } catch (Exception exception) {
            fail("State is not valid. Got an Exception");
        }
    }

    @Test
    void setStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getImportJson());
            assertTrue(stateMachine.getCurrentState() instanceof ImportJsonState);
        } catch (Exception exception) {
            fail("State not set for import Json. Got an Exception");
        }
    }
}

