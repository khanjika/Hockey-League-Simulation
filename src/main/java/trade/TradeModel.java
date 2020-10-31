package trade;

import players.PlayerModel;

import java.util.List;

public class TradeModel {
    List<PlayerModel> offeredPlayer;
    List<PlayerModel> requestedPlayers;

    public List<PlayerModel> getOfferedPlayer() {
        return offeredPlayer;
    }

    public void setOfferedPlayer(List<PlayerModel> offeredPlayer) {
        this.offeredPlayer = offeredPlayer;
    }

    public List<PlayerModel> getRequestedPlayers() {
        return requestedPlayers;
    }

    public void setRequestedPlayers(List<PlayerModel> requestedPlayers) {
        this.requestedPlayers = requestedPlayers;
    }
}
