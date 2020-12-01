package leagueobjectmodel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<PlayerModel> sortActiveRoasters(List<PlayerModel> players){
        List<PlayerModel> activeRoaster = (sortPlayersDescending(players).stream()
                .filter(v -> (v.getPosition().equals(PlayerPosition.FORWARD.toString()))
                        && v.isPlayerInjured() == false).limit(9)
                .collect(Collectors.toList()));
        activeRoaster.addAll(sortPlayersDescending(players).stream().filter(v ->
                v.getPosition().equals(PlayerPosition.DEFENSE.toString())
                        && v.isPlayerInjured() == false).limit(9).collect(Collectors.toList()));
        activeRoaster.addAll(sortPlayersDescending(players).stream().filter(v ->
                v.getPosition().equals(PlayerPosition.GOALIE.toString())
                        && v.isPlayerInjured() == false).limit(2).collect(Collectors.toList()));
        activeRoaster.forEach(v -> v.setIsActive(true));
        players.stream().filter(v -> activeRoaster.contains(v) == false).forEach(p -> p.setIsActive(false));
        return activeRoaster;
    }

}
