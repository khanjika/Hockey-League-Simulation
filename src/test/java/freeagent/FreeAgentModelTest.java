package freeagent;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import players.PlayerModel;

import static org.junit.jupiter.api.Assertions.*;

public class FreeAgentModelTest {

    @Test
    void getPlayerName() {
        FreeAgentModel freeAgentModel =new FreeAgentModel();
        freeAgentModel.setPlayerName("player one");
        assertEquals("player one",freeAgentModel.getPlayerName(),"Failed to get player name in Free agent object");
    }

    @Test
    void setPlayerName() {
        FreeAgentModel freeAgentModel =new FreeAgentModel();
        freeAgentModel.setPlayerName("player one");
        assertEquals("player one",freeAgentModel.getPlayerName(),"Failed to set player name in Free agent object");
    }

    @Test
    void getPosition() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setPosition("player one");
        assertEquals("player one", freeAgentModel.getPosition(), "Failed to get player position in Free agent object");
    }

    @Test
    void setPosition() {
        FreeAgentModel freeAgentModel =new FreeAgentModel();
        freeAgentModel.setPosition("player one");
        assertEquals("player one",freeAgentModel.getPosition(),"Failed to set player position in Free agent object");
    }

    @Test
    void isCaptain() {
        FreeAgentModel freeAgentModel =new FreeAgentModel();
        freeAgentModel.setCaptain(true);
        assertTrue(freeAgentModel.isCaptain(),"Failed check player is captain or not in Free agent object");
    }

    @Test
    void setCaptain() {
        FreeAgentModel freeAgentModel =new FreeAgentModel();
        freeAgentModel.setCaptain(true);
        assertTrue(freeAgentModel.isCaptain(),"Failed set player is captain or not in Free agent object");
    }

    public static FreeAgentModel getFreeAgentModel(String playerName, String position, boolean iscaptain){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setCaptain(iscaptain);
        freeAgentModel.setPlayerName(playerName);
        freeAgentModel.setPosition(position);

        return freeAgentModel;
    }
}
