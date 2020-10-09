package statesTest;

import org.junit.jupiter.api.Test;
import statemachine.StateMachine;
import states.ImportJsonState;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class ImportJsonStateTest {

        @Test
        void getStateMachine() {
            try {
                StateMachine stateMachine = new StateMachine();
                ImportJsonState importJsonState = new ImportJsonState(stateMachine);
                importJsonState.setStateMachine(stateMachine);
                stateMachine.setCurrentState(stateMachine.getImportJson());
                StateMachine currentState = importJsonState.getStateMachine();
                assertNotNull(currentState);
            } catch (Exception exception) {
                fail("State is not valid. Got an Exception");
            }
        }

        @Test
        void setStateMachine() {
            try {
                StateMachine stateMachine = new StateMachine();
                stateMachine.setCurrentState(stateMachine.getImportJson());
                ImportJsonState importJsonState = new ImportJsonState(stateMachine);
                importJsonState.setStateMachine(stateMachine);
                StateMachine currentState = importJsonState.getStateMachine();
                assertNotNull(currentState);
            } catch (Exception exception) {
                fail("State not set for import Json. Got an Exception");
            }
        }
    }

