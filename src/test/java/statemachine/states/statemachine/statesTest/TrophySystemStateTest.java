package statemachine.states.statemachine.statesTest;

import org.junit.jupiter.api.Test;
import statemachine.states.statemachine.StateMachine;
import statemachine.states.statemachine.states.TrophySystemState;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class TrophySystemStateTest {

    @Test
    void isStateMachine(){
        try{

            StateMachine stateMachine = new StateMachine();
            TrophySystemState trophySystemState = new TrophySystemState(stateMachine);
            trophySystemState.setStateMachine(stateMachine);
            stateMachine.setCurrentState(stateMachine.getCreateTeam());
            StateMachine currentState = trophySystemState.getStateMachine();
            assertNotNull(currentState);
        }catch (Exception exception) {
            fail("State is not valid. Got an Exception");
        }
    }

    @Test
    void setStateMachine(){
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getCreateTeam());
            TrophySystemState trophySystemState = new TrophySystemState(stateMachine);
            trophySystemState.setStateMachine(stateMachine);
            StateMachine currentState = trophySystemState.getStateMachine();
            assertNotNull(currentState);
        } catch (Exception exception) {
            fail("State not set for create team. Got an Exception");
        }
    }
}
