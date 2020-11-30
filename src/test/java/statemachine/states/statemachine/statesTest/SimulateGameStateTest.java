package statemachine.states.statemachine.statesTest;

import leagueobjectmodel.*;
import org.junit.jupiter.api.Test;
import statemachine.states.statemachine.StateMachine;
import trade.MockLeague;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimulateGameStateTest {


    @Test
    void task() {
        StateMachine stateMachine = new StateMachine();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        ITeamsModel teamOne = null;
        ITeamsModel teamTwo = null;
        for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                for (ITeamsModel teamsModel : divisonModel.getTeams()) {
                    if (teamOne == null) {
                        teamOne = teamsModel;
                    } else {
                        teamTwo = teamsModel;
                    }

                }
            }
        }
//        SimulateGameState simulateGameState = new SimulateGameState(stateMachine, leagueModel, teamOne, teamTwo);
//        stateMachine.setCurrentState(simulateGameState);
//        stateMachine.setCurrentDate(LocalDate.now());
//        simulateGameState.entry();
//
//        float strength = simulateGameState.getTeamStrength(teamOne);
//        assertEquals(75.0, strength);
    }


}
