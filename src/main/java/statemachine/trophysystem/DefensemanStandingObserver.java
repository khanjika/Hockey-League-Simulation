package statemachine.trophysystem;

import cli.IDisplay;
import leagueobjectmodel.*;

import java.util.*;
import java.util.stream.Collectors;

public class DefensemanStandingObserver implements IObserver{

    PlayerModel currentBestDefenser;
    private HashMap<Integer, PlayerModel> defensemanWinners = new HashMap<>();

    @Override
    public void update(ILeagueModel leagueModel, int year) {
        List<PlayerModel> bestGoalieOfEachTeam = new ArrayList<>();
        for(ConferenceModel conference : leagueModel.getConferences()){
            for(DivisonModel division : conference.getDivisions()) {
                for (TeamsModel team : division.getTeams()) {
                    bestGoalieOfEachTeam.add(Collections.max(team.getPlayers().stream()
                            .filter(l -> l.getPosition().equals(PlayerPosition.DEFENSE.toString()))
                            .collect(Collectors.toList()), Comparator.comparing(PlayerModel::getTotalPenaltyCount)));
                }
            }
        }
        currentBestDefenser = Collections.max(bestGoalieOfEachTeam,Comparator.comparing(PlayerModel::getTotalPenaltyCount));
        defensemanWinners.put(year, currentBestDefenser);
    }

    @Override
    public void getHistoryOfWinners(IDisplay display){
        SortedSet<Integer> years = new TreeSet<>(defensemanWinners.keySet()).descendingSet();
        for(Integer currentYear: years){
            display.displayAwards(TrophySystemConstants.DefenseManTrophy.getValue(),defensemanWinners.get(currentYear).getPlayerName() , currentYear);
        }
    }
}
