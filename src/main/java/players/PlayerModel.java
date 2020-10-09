package players;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    public void storePlayerInformation(PlayerModel playerModel, int teamId) {
        iPlayerPersistent.addPlayerInformation(playerModel.getPlayerName(), playerModel.getPosition(), playerModel.isCaptain(), teamId);
    }

    @Override
    public ArrayList<PlayerModel> getPlayerInformation(int teamId) {
        return iPlayerPersistent.getPlayerInformation(teamId);
    }


}
