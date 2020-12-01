package statemachine.states.statesTest;

import org.junit.jupiter.api.Test;
import statemachine.states.StateMachine;
import statemachine.states.states.PersistLeagueState;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class PersistLeagueStateTest {

    @Test
    void getStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getPersistLeagueState());
            assertTrue(stateMachine.getCurrentState() instanceof PersistLeagueState);
        } catch (Exception exception) {
            fail("State is not valid. Got an Exception");
        }
    }

    @Test
    void setStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getPersistLeagueState());
            assertTrue(stateMachine.getCurrentState() instanceof PersistLeagueState);
        } catch (Exception exception) {
            fail("State not set for import Json. Got an Exception");
        }
    }
}
