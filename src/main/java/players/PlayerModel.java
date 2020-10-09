package players;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerModel implements  IPlayerModel{

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
        //get last inserted player if
        int lastInsertedPLayerId = iPlayerPersistent.addPlayerInformation(playerModel.getPlayerName(), playerModel.getPosition(), playerModel.isCaptain(), teamId);
        if (lastInsertedPLayerId != 0) {
          iPlayerPersistent.storePlayerId(lastInsertedPLayerId, teamId);
        }

    }
}
