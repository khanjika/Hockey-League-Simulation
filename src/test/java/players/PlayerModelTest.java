package players;

import freeagent.FreeAgentModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerModelTest {

    @Test
    void getPlayerName() {
        PlayerModel playerModel =new PlayerModel();
        playerModel.setPlayerName("player one");
        assertEquals("player one",playerModel.getPlayerName(),"Failed to get player name in player object");
    }

    @Test
    void setPlayerName() {
        PlayerModel playerModel =new PlayerModel();
        playerModel.setPlayerName("player one");
        assertEquals("player one",playerModel.getPlayerName(),"Failed to set player name in player object");
    }

    @Test
    void getPosition() {
        PlayerModel playerModel =new PlayerModel();
        playerModel.setPosition("player one");
        assertEquals("player one", playerModel.getPosition(), "Failed to get player position in player object");
    }

    @Test
    void setPosition() {
        PlayerModel playerModel =new PlayerModel();
        playerModel.setPosition("player one");
        assertEquals("player one",playerModel.getPosition(),"Failed to set player position in player object");
    }

    @Test
    void isCaptain() {
        PlayerModel playerModel =new PlayerModel();
        playerModel.setCaptain(true);
        assertTrue(playerModel.isCaptain(),"Failed check player is captain or not in player object");
    }

    @Test
    void setCaptain() {
       PlayerModel playerModel=new PlayerModel();
        playerModel.setCaptain(true);
        assertTrue(playerModel.isCaptain(),"Failed set player is captain or not in  player object");
    }

    public static PlayerModel getPlayerModel(String playerName, String position, boolean iscaptain){
        PlayerModel playerModel = new PlayerModel();
        playerModel.setCaptain(iscaptain);
        playerModel.setPlayerName(playerName);
        playerModel.setPosition(position);

        return playerModel;
    }
}