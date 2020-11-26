package statesTest;

import org.junit.jupiter.api.Test;
import statemachine.states.statemachine.StateMachine;
import statemachine.states.statemachine.states.LoadTeamState;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;


public class LoadTeamStateTest {
    @Test
    void isState() {
        try {
            StateMachine stateMachine = new StateMachine();
            LoadTeamState loadTeamState = new LoadTeamState((stateMachine));
            loadTeamState.setStateMachine(stateMachine);
            stateMachine.setCurrentState(stateMachine.getLoadTeam());
            StateMachine currentState = loadTeamState.getStateMachine();
            assertNotNull(currentState);
        } catch (Exception exception) {
            fail("State is not valid. Got an Exception");
        }
    }


    @Test
    void setState() {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getLoadTeam());
            LoadTeamState loadTeamState = new LoadTeamState(stateMachine);
            loadTeamState.setStateMachine(stateMachine);
            StateMachine currentState = loadTeamState.getStateMachine();
            assertNotNull(currentState);
        } catch (Exception exception) {
            fail("State not set for load team. Got an Exception");
        }
    }
}
