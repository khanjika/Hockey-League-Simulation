package statemachine.createteam;

import cli.CliAbstractFactory;
import cli.ICli;
import cli.MockCli;
import leagueobjectmodel.ILeagueModel;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateTeamTest {
    @Test
    void createNewTeamTest() {
        ByteArrayInputStream userinput = new ByteArrayInputStream("eastern conference\natlantic\ntestTeam\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1".getBytes());
        System.setIn(userinput);
        ICli cli = new MockCli();
        CliAbstractFactory.getInstance().setCli(cli);
        ICreateTeam createTeam = CreateTeamAbstractFactory.instance().createCreateTeam();
    }
}
