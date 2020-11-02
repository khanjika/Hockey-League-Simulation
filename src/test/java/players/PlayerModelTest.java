package players;

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

    @Test
    void getAge(){
        PlayerModel playerModel = new PlayerModel();
        playerModel.setAge(27);
        assertEquals(27,playerModel.getAge(),"Failed get Age in player object");
    }

    @Test
    void setAge(){
        PlayerModel playerModel = new PlayerModel();
        playerModel.setAge(27);
        assertEquals(27,playerModel.getAge(),"Failed set Age in player object");
    }

    @Test
    void getSkating(){
        PlayerModel playermodel = new PlayerModel();
        playermodel.setSkating(15);
        assertEquals(15,playermodel.getSkating(),"Failed get skating in player object");
    }

    @Test
    void setSkating(){
        PlayerModel playermodel = new PlayerModel();
        playermodel.setSkating(15);
        assertEquals(15,playermodel.getSkating(),"Failed get skating in player object");
    }

    @Test
    void getShooting(){
        PlayerModel playerModel = new PlayerModel();
        playerModel.setShooting(18);
        assertEquals(18,playerModel.getShooting(),"Failed get shooting in player object");
    }

    @Test
    void setShooting(){
        PlayerModel playerModel = new PlayerModel();
        playerModel.setShooting(18);
        assertEquals(18,playerModel.getShooting(),"Failed set shooting in player object");
    }

    @Test
    void getChecking(){
        PlayerModel playerModel = new PlayerModel();
        playerModel.setChecking(10);
        assertEquals(10,playerModel.getChecking(),"Failed get checing in player object");
    }

    @Test
    void setChecking(){
        PlayerModel playerModel = new PlayerModel();
        playerModel.setChecking(10);
        assertEquals(10,playerModel.getChecking(),"Failed get shooting in player object");
    }

    @Test
    void getSaving(){
        PlayerModel playerModel = new PlayerModel();
        playerModel.setSaving(1);
        assertEquals(1,playerModel.getSaving(),"Failed get saving in player object");
    }

    @Test
    void setSaving(){
        PlayerModel playerModel = new PlayerModel();
        playerModel.setSaving(1);
        assertEquals(1,playerModel.getSaving(),"Failed set saving in player object");
    }

    public static PlayerModel getPlayerModel(String playerName, String position, boolean iscaptain,int age, float skating, float shooting, float checking, float saving){
        PlayerModel playerModel = new PlayerModel();
        playerModel.setCaptain(iscaptain);
        playerModel.setPlayerName(playerName);
        playerModel.setPosition(position);
        playerModel.setAge(age);
        playerModel.setSkating(skating);
        playerModel.setChecking(checking);
        playerModel.setShooting(shooting);
        playerModel.setSaving(saving);
        return playerModel;
    }
}