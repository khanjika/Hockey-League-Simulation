package statemachine.trophysystem;

import cli.IDisplay;
import leagueobjectmodel.*;

import java.util.*;

public class PlayerStandingObserver implements IObserver{

    private HashMap<Integer, PlayerModel> playerWinner = new HashMap<>();

    @Override
    public void update(ILeagueModel leagueModel, int year) {
        List<PlayerModel> bestPlayerEachTeam = new ArrayList<>();
        for(ConferenceModel conference : leagueModel.getConferences()){
            for(DivisonModel division : conference.getDivisions()) {
                for (TeamsModel team : division.getTeams()) {
                    bestPlayerEachTeam.add(Collections.max(team.getPlayers(),
                            Comparator.comparing(PlayerModel::getCurrentPenaltyCount)));
                }
            }
        }
        playerWinner.put(year, Collections.max(bestPlayerEachTeam,Comparator
                .comparing(PlayerModel::getCurrentPenaltyCount)));
    }

    @Override
    public void getHistoryOfWinners(IDisplay display) {
        SortedSet<Integer> years = new TreeSet<>(playerWinner.keySet());
        display.displayAwards(TrophySystemConstants.PlayerTrophy.getValue()
                ,playerWinner.get(years.first()).getPlayerName(),years.first());
    }
}
