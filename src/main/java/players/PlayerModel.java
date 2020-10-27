package players;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.runtime.ECMAException;
import teams.TeamPojo;

import java.util.ArrayList;

public class PlayerModel implements IPlayerModel {

    private IPlayerPersistent iPlayerPersistent;

    public PlayerModel() {
        iPlayerPersistent = new PlayerPersistent();
    }
    private String playerName;
    private String position;
    @JsonProperty(required = true)
    private Boolean captain;
    private int age;
    private float skating;
    private float shooting;
    private float checking;
    private float saving;
    private float playerStrength;

    public PlayerModel(String playerName, String position, Boolean captain, int age, float skating, float shooting, float checking, float saving) {
        this.playerName = playerName;
        this.position = position;
        this.captain = captain;
        this.age = age;
        this.skating = skating;
        this.shooting = shooting;
        this.checking = checking;
        this.saving = saving;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean isCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public float getSkating() { return skating; }

    public void setSkating(float skating) { this.skating = skating; }

    public float getShooting() { return shooting;}

    public void setShooting(float shooting) { this.shooting = shooting; }

    public float getChecking() { return checking; }

    public void setChecking(float checking) { this.checking = checking; }

    public float getSaving() { return saving; }

    public void setSaving(float saving) { this.saving = saving; }

    public float getPlayerStrength() { return playerStrength; }

    //public void setPlayerStrength(float playerStrength) throws Exception { this.playerStrength = playerStrength; }


    public void storePlayerInformation(PlayerModel playerModel, int teamId) {
        iPlayerPersistent.addPlayerInformation(playerModel.getPlayerName(), playerModel.getPosition(), playerModel.isCaptain(), teamId);
    }

    @Override
    public void calculatePlayerStrength(PlayerModel playerModel) {
        if(playerModel.getPosition().equals(PlayerPosition.FORWARD.toString())){
            playerModel.playerStrength = getSkating()+ getShooting() + (getChecking()/2);
        }
        else if(playerModel.getPosition().equals(PlayerPosition.DEFENSE.toString())){
            playerModel.playerStrength = getSkating() + getChecking() + (getShooting()/2);
        }
        else if(playerModel.getPosition().equals(PlayerPosition.GOALIE.toString())){
            playerModel.playerStrength = getSkating() + getShooting();
        }
    }

    @Override
    public ArrayList<PlayerModel> getPlayerInformation(int teamId) {
        return iPlayerPersistent.getPlayerInformation(teamId);
    }
}
