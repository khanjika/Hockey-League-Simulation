package trade;

import com.google.gson.annotations.Expose;
import leagueobjectmodel.PlayerModel;

import java.util.List;

public class TradeModel implements ITradeModel {
    @Expose
    List<PlayerModel> offeredPlayer;

    @Expose
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
