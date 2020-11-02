package trade;

import players.PlayerModel;

import java.util.List;

public interface ITradeModel {
    List<PlayerModel> getOfferedPlayer();

    List<PlayerModel> getRequestedPlayers();

    void setOfferedPlayer(List<PlayerModel> offeredPlayer);

    void setRequestedPlayers(List<PlayerModel> requestedPlayers);
}
