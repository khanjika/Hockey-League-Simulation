package statemachine.loadteam;

import cli.CliAbstractFactory;
import cli.ICli;
import cli.MockCli;
import leagueobjectmodel.ILeagueModel;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertNull;

public class LoadTeamTest {
    @Test
    void getUserInputTest() {
        ByteArrayInputStream userinput = new ByteArrayInputStream("test Team".getBytes());
        System.setIn(userinput);
        ICli cli = new MockCli();
        CliAbstractFactory.getInstance().setCli(cli);
        ILoadTeam loadTeamCli = LoadTeamAbstractFactory.instance().createLoadTeam();
        ILeagueModel leagueModel = loadTeamCli.getData();
        assertNull(leagueModel);
    }
}
