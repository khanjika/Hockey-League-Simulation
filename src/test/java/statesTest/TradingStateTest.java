package statesTest;

import league.LeagueModel;
import org.junit.jupiter.api.Test;
import statemachine.StateMachine;
import states.ITransition;
import states.ImportJsonState;
import states.TradingState;
import states.TrainingState;
import trade.MockLeague;

import static org.junit.jupiter.api.Assertions.*;

class TradingStateTest {

    @Test
    void task() {
        StateMachine stateMachine = new StateMachine();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        TradingState tradingState=new TradingState(stateMachine,leagueModel);
        stateMachine.setCurrentState(tradingState);
        tradingState.entry();

    }

    @Test
    void getStateMachine() {
        try {
            StateMachine stateMachine = new StateMachine();
            TradingState tradingState = new TradingState(stateMachine);
            stateMachine.setCurrentState(tradingState);
            ITransition currentState =stateMachine.getCurrentState();
            assertNotNull(currentState);
            assertTrue(currentState instanceof ITransition);
        } catch (Exception exception) {
            fail("State is not valid. Got an Exception");
        }
    }

}
