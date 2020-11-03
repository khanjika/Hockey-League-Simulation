package cli;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class loadTeamCliTest {

    @Test
    void getUserInputTest(){
        ByteArrayInputStream userinput = new ByteArrayInputStream("test".getBytes());
        System.setIn(userinput);
        loadTeamCli loadTeamCli = new loadTeamCli();
        String output = loadTeamCli.getUserInput("Team");
        assertEquals(output,"test");
    }
}
