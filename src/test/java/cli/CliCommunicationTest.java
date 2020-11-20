package cli;

import league.LeagueModel;
import league.LeagueModelTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CliCommunicationTest {

    @Test
    void isFileExist() {
        CliCommunication cliCommunication = new CliCommunication();
        assertTrue(cliCommunication.isFileExist("src/test/java/resources/TestJson.txt"));
        assertFalse(cliCommunication.isFileExist("xyz.txt"));
    }

//    @Test
//    void parseJson() {
//        CliCommunication cliCommunication = new CliCommunication();
//        LeagueModel leagueModel = cliCommunication.parseJson("src/test/java/resources/TestJson.txt");
//        assertNotNull(leagueModel);
//    }

    @Test
    void calculateStrength() {
        CliCommunication cliCommunication = new CliCommunication();
        LeagueModel testModel = LeagueModelTest.getLeagueObject();
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        LeagueModel updatedleagueModel = cliCommunication.calculateStrength(leagueModel);
        assertNotNull(updatedleagueModel);
        assertNotEquals(testModel.toString(), updatedleagueModel.toString());
    }
}
