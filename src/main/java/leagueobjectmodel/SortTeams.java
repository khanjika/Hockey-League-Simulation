package leagueobjectmodel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortTeams implements ISortTeams {
    ITeamsModel teamsModel = LeagueObjectModelAbstractFactory.getInstance().getTeams();
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
                .filter(v -> (v.getPosition().equals(PlayerPosition.FORWARD.toString())
                        || v.getPosition().equals(PlayerPosition.DEFENSE.toString()))
                        && v.isPlayerInjured() == false).limit(18)
                .collect(Collectors.toList()));
//        int defense = 0;
//        for(PlayerModel player : activeRoaster){
//            if(player.getPosition().equals(PlayerPosition.DEFENSE.toString())){
//                defense ++;
//            }
//        }
//        System.out.println(activeRoaster.size());
//        System.out.println(defense);
//        if (defense < 2){
//            for (int i = 0; i < (2 - defense); i++){
//                activeRoaster = sortPlayersDescending(activeRoaster);
//                activeRoaster.remove(0);
//                System.out.println(activeRoaster.size());
//            }
//            activeRoaster.addAll(sortPlayersDescending(players).stream()
//                    .filter(v -> v.getPosition().equals(PlayerPosition.DEFENSE.toString())
//                            && v.isPlayerInjured() == false).limit(2 - defense)
//                    .collect(Collectors.toList()));
//        }
        activeRoaster.addAll(sortPlayersDescending(players).stream().filter(v ->
                v.getPosition().equals(PlayerPosition.GOALIE.toString())
                        && v.isPlayerInjured() == false).limit(2).collect(Collectors.toList()));
        activeRoaster.forEach(v -> v.setActive(true));
        return activeRoaster;
    }

}
