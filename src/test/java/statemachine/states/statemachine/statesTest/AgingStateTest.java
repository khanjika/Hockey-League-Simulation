package statemachine.states.statemachine.statesTest;

import leagueobjectmodel.*;
import org.junit.jupiter.api.Test;
import statemachine.states.statemachine.StateMachine;
import statemachine.states.statemachine.states.AgingState;
import statemachine.states.statemachine.states.CreateTeamState;
import trade.MockLeague;

import java.time.LocalDate;

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
