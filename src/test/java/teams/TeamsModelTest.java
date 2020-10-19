package teams;

import org.junit.jupiter.api.Test;
import players.PlayerModel;
import players.PlayerModelTest;
import players.PlayerValidator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeamsModelTest {

    @Test
    void getTeamName() {
        TeamsModel teamsModel = new TeamsModel();
        teamsModel.setTeamName("TeamName one");
        assertEquals("TeamName one", teamsModel.getTeamName(), "Failed to get teamname in TeamModel Object");
    }

    @Test
    void setTeamName() {
        TeamsModel teamsModel = new TeamsModel();
        teamsModel.setTeamName("TeamName one");
        assertEquals("TeamName one", teamsModel.getTeamName(), "Failed to get teamname in TeamModel Object");
    }

    @Test
    void getGeneralManager() {
        TeamsModel teamsModel = new TeamsModel();
        teamsModel.setGeneralManager("Manager one");
        assertEquals("Manager one", teamsModel.getGeneralManager(), "Failed to get GeneralManager in TeamModel Object");
    }

    @Test
    void setGeneralManager() {
        TeamsModel teamsModel = new TeamsModel();
        teamsModel.setGeneralManager("Manager one");
        assertEquals("Manager one", teamsModel.getGeneralManager(), "Failed to set GeneralManager in TeamModel Object");
    }

//    @Test
//    void getHeadCoach() {
//        TeamsModel teamsModel = new TeamsModel();
//        teamsModel.setHeadCoach("Head coach one");
//        assertEquals("Head coach one", teamsModel.getHeadCoach(), "Failed to get head coach name in TeamModel Object");
//    }
//
//    @Test
//    void setHeadCoach() {
//        TeamsModel teamsModel = new TeamsModel();
//        teamsModel.setHeadCoach("Head coach one");
//        assertEquals("Head coach one", teamsModel.getHeadCoach(), "Failed to set head coach name in TeamModel Object");
//    }

    @Test
    void getPlayers() {
        TeamsModel teamsModel = new TeamsModel();
        teamsModel.setPlayers(new ArrayList<PlayerModel>());
        assertNotNull(teamsModel.getPlayers(), "failed to set player object in teams object");
    }

    @Test
    void setPlayers() {
        TeamsModel teamsModel = new TeamsModel();
        teamsModel.setPlayers(new ArrayList<PlayerModel>());
        assertNotNull(teamsModel.getPlayers(), "failed to set player object in teams object");
    }


    public static TeamsModel getTeamsObject() {
        TeamsModel teamsModel = new TeamsModel();
        //teamsModel.setHeadCoach("Mary Smith");
        teamsModel.setGeneralManager("Mister Fred");
        teamsModel.setTeamName("Boston");
        boolean isCaptain = true;
        String playerName = "A";
        List<PlayerModel> playerModelObjectList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            playerName = playerName + i;
            PlayerModel playerModel = PlayerModelTest.getPlayerModel(playerName, "forward", isCaptain);
            isCaptain = false;
            playerModelObjectList.add(playerModel);
        }
        teamsModel.setPlayers(playerModelObjectList);
        return teamsModel;
    }

    @Test
    void isTeamAlreadyExist() {
        MockTeamsPersistent mock = new MockTeamsPersistent();
        assertTrue(mock.isTeamNameExist());
    }

    @Test
    void getTeamId() {
        MockTeamsPersistent mock = new MockTeamsPersistent();
        assertEquals(mock.getTeamId(), 1);
    }

    @Test
    void getTeamInformation() {
        MockTeamsPersistent mock = new MockTeamsPersistent();
        TeamPojo teamPojo = mock.getTeamInformation();
        assertEquals(teamPojo.getTeamId(),1);
        assertEquals(teamPojo.getHeadCoach(),"Rob");
    }

}
