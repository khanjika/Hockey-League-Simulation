package cli;

import leagueobjectmodel.MockTeam;
import org.junit.jupiter.api.Test;

public class DisplayTest {
    IDisplay display = CliAbstractFactory.getInstance().getDisplayPersons();
    @Test
    void displayTeamPlayersTest(){
        display.displayTeamPlayers(MockTeam.validTeamPlayers());
    }
//    @Test
//    void displayCoachesTest(){
//        display.displayCoaches(MockCoach.getInvalidCoachModel());
//    }
//    @Test
//    void displayManagersTest(){
//        display.displayManagers(MockGeneralManagers.getGeneralManagersModel());
//    }
//    @Test
//    void displayFreeAgentsTest(){
//       display.displayFreeAgents(MockFreeAgent.getFreeAgentModel());
//    }
}
