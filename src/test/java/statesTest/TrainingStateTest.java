package statesTest;

import league.LeagueModel;
import org.junit.jupiter.api.Test;
import statemachine.StateMachine;
import states.TradingState;
import states.TrainingState;
import trade.MockLeague;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrainingStateTest {

    @Test
    void entry() {
        StateMachine stateMachine =new StateMachine();
        LeagueModel leagueModel= MockLeague.getLeagueObject();
        stateMachine.setCurrentDate(LocalDate.now());
        TrainingState trainingState = new TrainingState(stateMachine,leagueModel);
        trainingState.entry();

    }



}
