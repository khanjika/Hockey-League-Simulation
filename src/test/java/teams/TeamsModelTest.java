package teams;

import org.junit.jupiter.api.Test;
import players.PlayerModel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TeamsModelTest {

    @Test
    void getTeamName() {
        TeamsModel teamsModel =new TeamsModel();
        teamsModel.setTeamName("TeamName one");
        assertEquals("TeamName one",teamsModel.getTeamName(),"Failed to get teamname in TeamModel Object");
    }

    @Test
    void setTeamName() {
        TeamsModel teamsModel =new TeamsModel();
        teamsModel.setTeamName("TeamName one");
        assertEquals("TeamName one",teamsModel.getTeamName(),"Failed to get teamname in TeamModel Object");
    }

    @Test
    void getGeneralManager() {
        TeamsModel teamsModel =new TeamsModel();
        teamsModel.setGeneralManager("Manager one");
        assertEquals("Manager one",teamsModel.getGeneralManager(),"Failed to get GeneralManager in TeamModel Object");
    }

    @Test
    void setGeneralManager() {
        TeamsModel teamsModel =new TeamsModel();
        teamsModel.setGeneralManager("Manager one");
        assertEquals("Manager one",teamsModel.getGeneralManager(),"Failed to set GeneralManager in TeamModel Object");
    }

    @Test
    void getHeadCoach() {
        TeamsModel teamsModel =new TeamsModel();
        teamsModel.setHeadCoach("Head coach one");
        assertEquals("Head coach one",teamsModel.getHeadCoach(),"Failed to get head coach name in TeamModel Object");
    }

    @Test
    void setHeadCoach() {
        TeamsModel teamsModel =new TeamsModel();
        teamsModel.setHeadCoach("Head coach one");
        assertEquals("Head coach one",teamsModel.getHeadCoach(),"Failed to set head coach name in TeamModel Object");
    }

    @Test
    void getPlayers() {
        TeamsModel teamsModel =new TeamsModel();
        teamsModel.setPlayers(new ArrayList<PlayerModel>());
       assertNotNull(teamsModel.getPlayers(),"failed to set player object in teams object");
    }

    @Test
    void setPlayers() {
        TeamsModel teamsModel =new TeamsModel();
        teamsModel.setPlayers(new ArrayList<PlayerModel>());
        assertNotNull(teamsModel.getPlayers(),"failed to set player object in teams object");
    }
}