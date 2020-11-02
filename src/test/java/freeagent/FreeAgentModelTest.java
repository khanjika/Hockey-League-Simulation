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
    void setAge(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setAge(18);
        assertEquals(18,freeAgentModel.getAge(),"Failed to set age in Free Agent Object");
    }

    @Test
    void getAge(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setAge(18);
        assertEquals(18,freeAgentModel.getAge(),"Failed to set age in Free Agent Object");
    }

    @Test
    void getShooting(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setShooting(5.5f);
        assertEquals(5.5f,freeAgentModel.getShooting(),"Failed to set shooting stats in Free Agent Object");
    }

    @Test
    void setShooting(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setShooting(5.5f);
        assertEquals(5.5f,freeAgentModel.getShooting(),"Failed to set shooting stats in Free Agent Object");
    }
    @Test
    void getSaving(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setSaving(5.5f);
        assertEquals(5.5f,freeAgentModel.getSaving(),"Failed to set Saving stats in Free Agent Object");
    }

    @Test
    void setSaving(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setSaving(5.5f);
        assertEquals(5.5f,freeAgentModel.getSaving(),"Failed to set Saving stats in Free Agent Object");
    }
    @Test
    void getSkating(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setSkating(5.5f);
        assertEquals(5.5f,freeAgentModel.getSkating(),"Failed to set Skating stats in Free Agent Object");
    }
    @Test
    void setSkating(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setSkating(5.5f);
        assertEquals(5.5f,freeAgentModel.getSkating(),"Failed to set Skating stats in Free Agent Object");
    }
    @Test
    void getChecking(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setChecking(5.5f);
        assertEquals(5.5f,freeAgentModel.getChecking(),"Failed to set Checking stats in Free Agent Object");
    }
    @Test
    void setChecking(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setChecking(5.5f);
        assertEquals(5.5f,freeAgentModel.getChecking(),"Failed to set Checking stats in Free Agent Object");
    }
    public static FreeAgentModel getFreeAgentModel(String playerName, String position, int age,float saving,float shooting,float checking,float skating){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setPlayerName(playerName);
        freeAgentModel.setPosition(position);
        freeAgentModel.setChecking(checking);
        freeAgentModel.setSkating(skating);
        freeAgentModel.setSaving(saving);
        freeAgentModel.setShooting(shooting);
        freeAgentModel.setAge(age);

        return freeAgentModel;
    }
}
