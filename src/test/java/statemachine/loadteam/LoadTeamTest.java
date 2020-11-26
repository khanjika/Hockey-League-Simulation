package statemachine.loadteam;

import cli.CliAbstractFactory;
import cli.ICli;
import cli.MockCli;
import leagueobjectmodel.ILeagueModel;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoadTeamTest {
    @Test
    void getUserInputTest() {
        ByteArrayInputStream userinput = new ByteArrayInputStream("testing".getBytes());
        System.setIn(userinput);
        ICli cli = new MockCli();
        CliAbstractFactory.getInstance().setCli(cli);
        ILoadTeam loadTeamCli = LoadTeamAbstractFactory.getInstance().getLoadTeam();
        ILeagueModel leagueModel = loadTeamCli.getData();
        assertNotNull(leagueModel);
    }


}
