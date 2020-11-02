package trade;

import players.PlayerModel;

import java.util.Comparator;
import java.util.List;

public class SortTeams implements ISortTeams {
    @Override
    public List<PlayerModel> sortPlayersAscending(List<PlayerModel> players) {
        players.sort (Comparator.comparing (PlayerModel::getPlayerStrength));
        return players;
    }

    @Override
    public List<PlayerModel> sortPlayersDescending(List<PlayerModel> players) {
        players.sort (Comparator.comparing (PlayerModel::getPlayerStrength).reversed ());
        return players;
    }
}
