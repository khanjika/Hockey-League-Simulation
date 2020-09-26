package league;

import conference.ConferenceModel;
import divison.DivisonModel;
import freeagent.FreeAgentModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LeagueModelTest {

    @Test
    void getLeagueNameTest() {
        LeagueModel leagueModel = new LeagueModel();
        leagueModel.setLeagueName("League one");
        assertEquals("League one",leagueModel.getLeagueName(),"Failed to get league name in division object");
    }

    @Test
    void setLeagueNameTest() {
        LeagueModel leagueModel = new LeagueModel();
        leagueModel.setLeagueName("League one");
        assertEquals("League one",leagueModel.getLeagueName(),"Failed to set league name in division object");
    }

    @Test
    void getConferencesTest() {
        LeagueModel leagueModel = new LeagueModel();
        leagueModel.setConferences(new ArrayList<ConferenceModel>());
        assertNotNull(leagueModel.getConferences(),"Failed to get Conferences in Division object");
    }

    @Test
    void setConferencesTest() {
        LeagueModel leagueModel = new LeagueModel();
        leagueModel.setConferences(new ArrayList<ConferenceModel>());
        assertNotNull(leagueModel.getConferences(),"Failed to set Conferences in Division object");
    }

    @Test
    void getFreeAgentsTest() {
        LeagueModel leagueModel = new LeagueModel();
        leagueModel.setFreeAgents(new ArrayList<FreeAgentModel>());
        assertNotNull(leagueModel.getFreeAgents(),"Failed to get FreeAgents in Division object");
    }

    @Test
    void setFreeAgentsTest() {
        LeagueModel leagueModel = new LeagueModel();
        leagueModel.setFreeAgents(new ArrayList<FreeAgentModel>());
        assertNotNull(leagueModel.getFreeAgents(),"Failed to set Free agents in Division object");
    }
}