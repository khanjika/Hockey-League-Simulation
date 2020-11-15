package statesTest;

import org.junit.jupiter.api.Test;
import statemachine.StateMachine;
import statemachine.states.ITransition;
import statemachine.states.TradingState;

import static org.junit.jupiter.api.Assertions.*;

class TradingStateTest {
//
//    @Test
//    void task() {
//        StateMachine stateMachine = new StateMachine();
//        LeagueModel leagueModel = MockLeague.getLeagueObject();
//        TradingState tradingState = new TradingState(stateMachine, leagueModel);
//        stateMachine.setCurrentState(tradingState);
//        tradingState.entry();
//
//    }

    @Test
    void getStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            TradingState tradingState = new TradingState(stateMachine);
            stateMachine.setCurrentState(tradingState);
            ITransition currentState = stateMachine.getCurrentState();
            assertNotNull(currentState);
            assertTrue(currentState instanceof ITransition);
        } catch (Exception exception) {
            fail("State is not valid. Got an Exception");
        }
    }

}
