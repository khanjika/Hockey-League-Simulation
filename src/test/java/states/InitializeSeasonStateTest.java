package states;

import org.junit.jupiter.api.Test;
import statemachine.StateMachine;

import static org.junit.jupiter.api.Assertions.*;

class InitializeSeasonStateTest {

    @Test
    void isState(){
        try{
            StateMachine stateMachine = new StateMachine();
            InitializeSeasonState initializeSeasonState = new InitializeSeasonState(stateMachine);
            stateMachine.setCurrentState(initializeSeasonState);
            //assertNotNull(currentState);
        }
        catch(Exception exception){
            fail("State is not valid. Got an Exception");
        }
    }


}
