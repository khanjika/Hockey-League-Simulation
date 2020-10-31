package trade;

import players.PlayerModel;

import java.util.List;

public interface ISortTeams {
    List<PlayerModel> sortPlayersDescending(List<PlayerModel> players);

    List<PlayerModel> sortPlayersAscending(List<PlayerModel> players);
}
