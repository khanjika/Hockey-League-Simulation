package statesTest;

import league.LeagueModel;
import org.junit.jupiter.api.Test;
import statemachine.StateMachine;
import states.PersistLeagueState;

import static org.junit.jupiter.api.Assertions.*;

class PersistLeagueStateTest {

    @Test
    void entryTest(){

        LeagueModel leagueModel=new LeagueModel();
        StateMachine stateMachine =new StateMachine();
        PersistLeagueState persistLeagueState = new PersistLeagueState(stateMachine);
        stateMachine.setCurrentState(persistLeagueState);
        stateMachine.setPersistLeagueStae(persistLeagueState);
        PersistLeagueState persistLeagueState1= (PersistLeagueState) stateMachine.getPersistLeagueStae();
        assertTrue(persistLeagueState1 instanceof PersistLeagueState);

    }
}
