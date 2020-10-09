package cli;

import league.LeagueModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CliCommunicationTest {

    @Test
    void isFileExist() {
        CliCommunication cliCommunication = new CliCommunication();
       assertTrue(cliCommunication.isFileExist("src/test/java/resources/TestJson.txt"));
       assertFalse(cliCommunication.isFileExist("xyz.txt"));
    }

    @Test
    void parseJson(){
        CliCommunication cliCommunication = new CliCommunication();
      LeagueModel leagueModel=cliCommunication.parseJson("src/test/java/resources/TestJson.txt");
      assertNull(leagueModel);
    }
}
