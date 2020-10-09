package cli;

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
    void fromJson() {
        assertTrue(false);
    }
}
