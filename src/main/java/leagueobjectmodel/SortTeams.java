package leagueobjectmodel;

import java.util.Comparator;
import java.util.List;

public class SortTeams implements ISortTeams {
    @Override
    public List<PlayerModel> sortPlayersAscending(List<PlayerModel> players) {
        players.sort(Comparator.comparing(PlayerModel::getPlayerStrength));
        return players;
    }

    @Override
    public List<PlayerModel> sortPlayersDescending(List<PlayerModel> players) {
        players.sort(Comparator.comparing(PlayerModel::getPlayerStrength).reversed());
        return players;
    }

    @Override
    public List<FreeAgentModel> sortFreeAgentDescending(List<FreeAgentModel> freeAgents) {
        freeAgents.sort(Comparator.comparing(FreeAgentModel::getFreeAgentStrength).reversed());
        return freeAgents;
    }

}
