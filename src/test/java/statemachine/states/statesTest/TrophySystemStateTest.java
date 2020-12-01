package statemachine.states.statesTest;

import org.junit.jupiter.api.Test;
import statemachine.states.StateMachine;
import statemachine.states.states.TrophySystemState;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrophySystemStateTest {

    @Test
    void getStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getTrophySystemState());
            assertTrue(stateMachine.getCurrentState() instanceof TrophySystemState);
        } catch (Exception exception) {
            fail("State is not valid. Got an Exception");
        }
    }

    @Test
    void setStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getTrophySystemState());
            assertTrue(stateMachine.getCurrentState() instanceof TrophySystemState);
        } catch (Exception exception) {
            fail("State not set for import Json. Got an Exception");
        }
    }
}
