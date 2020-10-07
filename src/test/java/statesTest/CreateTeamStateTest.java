package statesTest;

import org.junit.jupiter.api.Test;
import statemachine.StateMachine;
import states.CreateTeamState;


import static org.junit.jupiter.api.Assertions.*;
public class CreateTeamStateTest {
    @Test
    void isState(){
        try{
            StateMachine stateMachine = new StateMachine();
            CreateTeamState teamState = new CreateTeamState(stateMachine);
            teamState.setStateMachine(stateMachine);
            stateMachine.setCurrentState(stateMachine.getCreateTeam());
            StateMachine currentState = teamState.getStateMachine();
            assertNotNull(currentState);
        }
        catch(Exception exception){
            fail("State is not valid. Got an Exception");
        }
    }

    @Test
    void setState(){
        try{
            StateMachine stateMachine = new StateMachine();
            stateMachine.setCurrentState(stateMachine.getCreateTeam());
            CreateTeamState teamState = new CreateTeamState(stateMachine);
            teamState.setStateMachine(stateMachine);
            StateMachine currentState = teamState.getStateMachine();
            assertNotNull(currentState);
        }
        catch(Exception exception){
            fail("State not set for create team. Got an Exception");
        }
    }
}