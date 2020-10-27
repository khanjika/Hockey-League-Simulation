package cli;

import conference.ConferenceModel;
import divison.DivisonModel;
import league.LeagueModel;
import league.LeagueModelTest;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.jupiter.api.Test;
import teams.TeamsModel;

import java.io.ByteArrayInputStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.jupiter.api.Assertions.*;

class CreateTeamCliTest {
    @Rule
    public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

//    @Test
//    void createNewTeam() {
//        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
//        ByteArrayInputStream teamMockData = new ByteArrayInputStream("Eastern Conference\nAtlantic\nxyz\npqr\nabc".getBytes());
//        System.setIn(teamMockData);
//        CreateTeamCli createTeamCli = new CreateTeamCli();
//        assertNotNull(createTeamCli.createNewTeam(leagueModel));
//
//    }

    @Test
    void isConferenceNameValid() {
        ByteArrayInputStream validConfNameTest = new ByteArrayInputStream("Eastern Conferenc \nEastern Conference".getBytes());
        System.setIn(validConfNameTest);
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        CreateTeamCli createTeamCli = new CreateTeamCli();
        assertTrue(createTeamCli.isConferenceNameValid(leagueModel));
    }

    @Test
    void isDivisionNameValid() {
        ByteArrayInputStream validDivisionNameTest = new ByteArrayInputStream("Atlanti\nAtlantic".getBytes());
        System.setIn(validDivisionNameTest);
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        CreateTeamCli createTeamCli = new CreateTeamCli();
        assertTrue(createTeamCli.isDivisionNameValid(leagueModel));
    }

//    @Test
//    void isTeamInformationSetProperly() {
//        ByteArrayInputStream teamInfoTest = new ByteArrayInputStream("Boston1\nMister Fred\nMary Smith".getBytes());
//        ByteArrayInputStream falilingTeamInfoTest = new ByteArrayInputStream("\nABC\n\nXYZ\n\nPQR\nABC\nMNOP".getBytes());
//        System.setIn(falilingTeamInfoTest);
//        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
//        CreateTeamCli createTeamCli = new CreateTeamCli();
//        assertTrue(createTeamCli.isTeamInformationSetProperly(leagueModel));
//
//    }

}
