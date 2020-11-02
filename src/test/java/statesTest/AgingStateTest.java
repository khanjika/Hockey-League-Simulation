package statesTest;

import conference.ConferenceModel;
import divison.DivisonModel;
import league.LeagueModel;
import org.junit.jupiter.api.Test;
import players.PlayerModel;
import statemachine.StateMachine;
import states.AgingState;
import teams.TeamsModel;
import trade.MockLeague;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AgingStateTest {


    @Test
    void entry() {
        StateMachine stateMachine = new StateMachine();
        stateMachine.setCurrentDate(LocalDate.now());
        LeagueModel leagueModel=MockLeague.getLeagueObject();
        AgingState agingState = new AgingState(stateMachine,leagueModel);
        agingState.entry();
        for(ConferenceModel conferenceModel:leagueModel.getConferences()){
            for(DivisonModel divisonModel:conferenceModel.getDivisions()){
                for(TeamsModel teamsModel:divisonModel.getTeams()){
                    for(PlayerModel playerModel:teamsModel.getPlayers()){
                        assertEquals(1,playerModel.getDays());
                    }
                }
            }
        }
    }

}
