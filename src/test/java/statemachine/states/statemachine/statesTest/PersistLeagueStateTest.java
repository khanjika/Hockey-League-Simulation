//package statemachine.states.statemachine.statesTest;
//
//import leagueobjectmodel.LeagueModel;
//import org.junit.jupiter.api.Test;
//import statemachine.states.statemachine.StateMachine;
//import statemachine.states.statemachine.states.PersistLeagueState;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//class PersistLeagueStateTest {
//
//    @Test
//    void entryTest() {
//
//        LeagueModel leagueModel = new LeagueModel();
//        StateMachine stateMachine = new StateMachine();
//        PersistLeagueState persistLeagueState = new PersistLeagueState(stateMachine);
//        stateMachine.setCurrentState(persistLeagueState);
//        stateMachine.setPersistLeagueStae(persistLeagueState);
//        PersistLeagueState persistLeagueState1 = (PersistLeagueState) stateMachine.getPersistLeagueState();
//        assertTrue(persistLeagueState1 instanceof PersistLeagueState);
//
//    }
//}
