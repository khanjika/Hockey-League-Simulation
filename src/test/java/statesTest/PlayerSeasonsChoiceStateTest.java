//package statesTest;
//
//import org.junit.Ignore;
//import org.junit.jupiter.api.Test;
//import statemachine.StateMachine;
//import states.PlayerSeasonsChoiceState;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.fail;
//
//public class PlayerSeasonsChoiceStateTest {
//    @Test
//    void isState(){
//        try{
//            StateMachine stateMachine = new StateMachine();
//            PlayerSeasonsChoiceState playerSeasonsChoiceState = new PlayerSeasonsChoiceState(stateMachine);
//            playerSeasonsChoiceState.setStateMachine(stateMachine);
//            stateMachine.setCurrentState(stateMachine.getPlayerSeasonsChoice());
//            StateMachine currentState = playerSeasonsChoiceState.getStateMachine();
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
//            stateMachine.setCurrentState(stateMachine.getPlayerSeasonsChoice());
//            PlayerSeasonsChoiceState playerSeasonsChoiceState = new PlayerSeasonsChoiceState(stateMachine);
//            playerSeasonsChoiceState.setStateMachine(stateMachine);
//            StateMachine currentState = playerSeasonsChoiceState.getStateMachine();
//            assertNotNull(currentState);
//        }
//        catch(Exception exception){
//            fail("State not set for player seasons choice. Got an Exception");
//        }
//    }
//}
