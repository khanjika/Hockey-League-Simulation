package cli;

import league.LeagueModel;
import league.LeagueModelTest;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.jupiter.api.Assertions.*;

class CreateTeamCliTest {
    @Rule
    public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    void createNewTeam() {
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        ByteArrayInputStream teamMockData = new ByteArrayInputStream("Eastern Conference\nAtlantic\ntest\n1\n1\n1\n1\n2\n2\n3\n3\n4\n4\n5\n5\n6\n6\n7\n7\n8\n8\n9\n9\n1\n1\n1".getBytes());
        System.setIn(teamMockData);
        CreateTeamCli createTeamCli = new CreateTeamCli();
        assertNotNull(createTeamCli.createNewTeam(leagueModel));
    }

}
