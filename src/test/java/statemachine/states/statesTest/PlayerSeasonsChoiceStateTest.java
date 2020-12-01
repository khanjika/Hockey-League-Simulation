package statemachine.states.statesTest;

import org.junit.jupiter.api.Test;
import statemachine.states.StateMachine;
import statemachine.states.states.PlayerSeasonsChoiceState;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerSeasonsChoiceStateTest {

    @Test
    void getStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getPlayerSeasonsChoice());
            assertTrue(stateMachine.getCurrentState() instanceof PlayerSeasonsChoiceState);
        } catch (Exception exception) {
            fail("State is not valid. Got an Exception");
        }
    }

    @Test
    void setStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getPlayerSeasonsChoice());
            assertTrue(stateMachine.getCurrentState() instanceof PlayerSeasonsChoiceState);
        } catch (Exception exception) {
            fail("State not set for import Json. Got an Exception");
        }
    }
}
