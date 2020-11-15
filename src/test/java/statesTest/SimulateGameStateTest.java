package statesTest;

import conference.ConferenceModel;
import divison.DivisonModel;
import league.LeagueModel;
import org.junit.jupiter.api.Test;
import statemachine.StateMachine;
import teams.TeamsModel;
import trade.MockLeague;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimulateGameStateTest {


    @Test
    void task() {
        StateMachine stateMachine = new StateMachine();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        TeamsModel teamOne = null;
        TeamsModel teamTwo = null;
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                for (TeamsModel teamsModel : divisonModel.getTeams()) {
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
