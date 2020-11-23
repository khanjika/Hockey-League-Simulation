package leagueobjectmodel;

import org.junit.jupiter.api.Test;

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

//    @Test
//    void getGeneralManager() {
//        TeamsModel teamsModel = new TeamsModel();
//        //teamsModel.setGeneralManager("Manager one");
//        assertEquals("Manager one", teamsModel.getGeneralManager(), "Failed to get GeneralManager in TeamModel Object");
//    }

//    @Test
//    void setGeneralManager() {
//        TeamsModel teamsModel = new TeamsModel();
//        //teamsModel.setGeneralManager("Manager one");
//        assertEquals("Manager one", teamsModel.getGeneralManager(), "Failed to set GeneralManager in TeamModel Object");
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

    @Test
    void getHeadCoach() {
        HeadCoachModel headCoachModel = new HeadCoachModel();
        headCoachModel.setName("Mary Smith");
        headCoachModel.setSkating(0.5f);
        headCoachModel.setShooting(0.8f);
        headCoachModel.setChecking(0.3f);
        headCoachModel.setSaving(0.5f);
        TeamsModel teamsModel = new TeamsModel();
        teamsModel.setHeadCoach(headCoachModel);
        assertEquals(headCoachModel, teamsModel.getHeadCoach(), "failed to set player object in teams object");
    }

    public static TeamsModel getTeamsObject() {
        TeamsModel teamsModel = new TeamsModel();
        HeadCoachModel headCoachModel = new HeadCoachModel();
        headCoachModel.setName("Mary Smith");
        headCoachModel.setSkating(0.5f);
        headCoachModel.setShooting(0.8f);
        headCoachModel.setChecking(0.3f);
        headCoachModel.setSaving(0.5f);
        teamsModel.setHeadCoach(headCoachModel);
        //teamsModel.setGeneralManager("Mister Fred");
        teamsModel.setTeamName("Boston");
        boolean isCaptain = true;
        String playerName = "A";
        List<PlayerModel> playerModelObjectList = new ArrayList<>();
        for (int i = 0; i < 18; i++) {

            playerName = playerName + i;
            PlayerModel playerModel = PlayerModelTest.getPlayerModel(playerName, "forward", isCaptain, 20, 10, 10, 10, 10);
            isCaptain = false;
            playerModelObjectList.add(playerModel);
        }
        PlayerModel playerModel;
        playerModel = PlayerModelTest.getPlayerModel(playerName + 19, "goalie", false, 20, 10, 10, 10, 10);
        playerModelObjectList.add(playerModel);
        playerModel = PlayerModelTest.getPlayerModel(playerName + 19, "goalie", false, 20, 10, 10, 10, 10);
        playerModelObjectList.add(playerModel);
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
        assertEquals(teamPojo.getTeamId(), 1);
        assertEquals(teamPojo.getHeadCoach(), "Rob");
    }

}
