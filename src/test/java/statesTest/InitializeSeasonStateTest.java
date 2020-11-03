package statesTest;

import org.junit.jupiter.api.Test;
import statemachine.StateMachine;
import states.InitializeSeasonState;

import static org.junit.jupiter.api.Assertions.fail;

class InitializeSeasonStateTest {

    @Test
    void isState() {
        try {
            StateMachine stateMachine = new StateMachine();
            InitializeSeasonState initializeSeasonState = new InitializeSeasonState(stateMachine);
            stateMachine.setCurrentState(initializeSeasonState);

        } catch (Exception exception) {
            fail("State is not valid. Got an Exception");
        }
    }


}
