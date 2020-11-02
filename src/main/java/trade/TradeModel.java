package trade;

import players.PlayerModel;

import java.util.List;

public class TradeModel implements ITradeModel {
    List<PlayerModel> offeredPlayer;
    List<PlayerModel> requestedPlayers;

    @Override
    public List<PlayerModel> getOfferedPlayer() {
        return offeredPlayer;
    }

    @Override
    public void setOfferedPlayer(List<PlayerModel> offeredPlayer) {
        this.offeredPlayer = offeredPlayer;
    }

    @Override
    public List<PlayerModel> getRequestedPlayers() {
        return requestedPlayers;
    }

    @Override
    public void setRequestedPlayers(List<PlayerModel> requestedPlayers) {
        this.requestedPlayers = requestedPlayers;
    }
}
