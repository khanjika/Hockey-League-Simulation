package statemachine.states.statemachine.statesTest;

import leagueobjectmodel.TrainingModel;
import org.junit.jupiter.api.Test;
import statemachine.states.statemachine.StateMachine;
import statemachine.states.statemachine.states.ImportJsonState;
import statemachine.states.statemachine.states.TradingState;
import statemachine.states.statemachine.states.TrainingState;

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
