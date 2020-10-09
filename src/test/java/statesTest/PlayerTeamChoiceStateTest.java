//package statesTest;
//
//import org.junit.jupiter.api.Test;
//import statemachine.StateMachine;
//import states.PlayerTeamChoiceState;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.fail;
//
//public class PlayerTeamChoiceStateTest {
//    @Test
//    void isState(){
//        try{
//            StateMachine stateMachine = new StateMachine();
//            PlayerTeamChoiceState playerTeamChoiceState = new PlayerTeamChoiceState(stateMachine);
//            playerTeamChoiceState.setStateMachine(stateMachine);
//            stateMachine.setCurrentState(stateMachine.getPlayerTeamChoice());
//            StateMachine currentState = playerTeamChoiceState.getStateMachine();
//            assertNotNull(currentState);
//        }
//        catch(Exception exception){
//            fail("State is not valid. Got an Exception");
//        }
//    }
//
//    @Test
//    void setState(){
//        try{
//            StateMachine stateMachine = new StateMachine();
//            stateMachine.setCurrentState(stateMachine.getPlayerTeamChoice());
//            PlayerTeamChoiceState playerTeamChoiceState = new PlayerTeamChoiceState(stateMachine);
//            playerTeamChoiceState.setStateMachine(stateMachine);
//            StateMachine currentState = playerTeamChoiceState.getStateMachine();
//            assertNotNull(currentState);
//        }
//        catch(Exception exception){
//            fail("State not set for player team choice. Got an Exception");
//        }
//    }
//}
