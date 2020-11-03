package statesTest;

import league.LeagueModel;
import org.junit.jupiter.api.Test;
import statemachine.StateMachine;
import states.TrainingState;
import trade.MockLeague;

import java.time.LocalDate;

class TrainingStateTest {

    @Test
    void entry() {
        StateMachine stateMachine = new StateMachine();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        stateMachine.setCurrentDate(LocalDate.now());
        TrainingState trainingState = new TrainingState(stateMachine, leagueModel);
        trainingState.entry();

    }


}
