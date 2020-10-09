//package statesTest;
//
//import org.junit.jupiter.api.Test;
//import statemachine.StateMachine;
//import states.SimulateState;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.fail;
//
//public class SimulateStateTest {
//    @Test
//    void isState(){
//        try{
//            StateMachine stateMachine = new StateMachine();
//            SimulateState simulateState = new SimulateState(stateMachine);
//            simulateState.setStateMachine(stateMachine);
//            stateMachine.setCurrentState(stateMachine.getSimulate());
//            StateMachine currentState = simulateState.getStateMachine();
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
//            stateMachine.setCurrentState(stateMachine.getSimulate());
//            SimulateState simulateState = new SimulateState(stateMachine);
//            simulateState.setStateMachine(stateMachine);
//            StateMachine currentState = simulateState.getStateMachine();
//            assertNotNull(currentState);
//        }
//        catch(Exception exception){
//            fail("State not set for simulate state. Got an Exception");
//        }
//    }
//}
