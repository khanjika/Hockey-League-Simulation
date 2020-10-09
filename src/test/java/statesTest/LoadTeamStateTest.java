//
//package statesTest;
//
//import org.junit.Ignore;
//import org.junit.jupiter.api.Test;
//import statemachine.StateMachine;
//import states.LoadTeamState;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@Ignore
//public class LoadTeamStateTest {
//    @Ignore
//    @Test
//    void isState(){
//        try{
//            StateMachine stateMachine = new StateMachine();
//            LoadTeamState loadTeamState = new LoadTeamState((stateMachine));
//            loadTeamState.setStateMachine(stateMachine);
//            stateMachine.setCurrentState(stateMachine.getLoadTeam());
//            StateMachine currentState = loadTeamState.getStateMachine();
//            assertNotNull(currentState);
//        }
//        catch(Exception exception){
//            fail("State is not valid. Got an Exception");
//        }
//    }
//
//    @Ignore
//    @Test
//    void setState(){
//        try{
//            StateMachine stateMachine = new StateMachine();
//            stateMachine.setCurrentState(stateMachine.getLoadTeam());
//            LoadTeamState loadTeamState = new LoadTeamState(stateMachine);
//            loadTeamState.setStateMachine(stateMachine);
//            StateMachine currentState = loadTeamState.getStateMachine();
//            assertNotNull(currentState);
//        }
//        catch(Exception exception){
//            fail("State not set for load team. Got an Exception");
//        }
//    }
//}
