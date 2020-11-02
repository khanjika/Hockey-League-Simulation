package serializeObject;

import cli.CliCommunication;
import league.LeagueModel;
import league.LeagueModelTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SerializeObjectTest {
    @Test
    void serializeLeagueObjectTest() {
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        SerializeObject serializeObject = new SerializeObject();
        serializeObject.serializeLeagueObject(leagueModel);
        CliCommunication cliCommunication = new CliCommunication();
        assertNotNull(cliCommunication.parseJson("test.JSON"));
    }
}