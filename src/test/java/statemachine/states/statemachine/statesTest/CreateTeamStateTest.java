package statemachine.states.statemachine.statesTest;

import org.junit.jupiter.api.Test;
import statemachine.states.statemachine.StateMachine;
import statemachine.states.statemachine.states.AgingState;
import statemachine.states.statemachine.states.CreateTeamState;

import static org.junit.jupiter.api.Assertions.*;

public class CreateTeamStateTest {
    @Test
    void isStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getCreateTeam());
            assertTrue(stateMachine.getCurrentState() instanceof CreateTeamState);
        } catch (Exception exception) {
            fail("State is not valid. Got an Exception");
        }
    }

    @Test
    void setStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getCreateTeam());
            assertTrue(stateMachine.getCurrentState() instanceof CreateTeamState);
        } catch (Exception exception) {
            fail("State not set for create team. Got an Exception");
        }
    }


}


