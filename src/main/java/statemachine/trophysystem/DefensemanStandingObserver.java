package statemachine.trophysystem;

import cli.ICli;
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
    public void getHistoryOfWinners(ICli display){
        SortedSet<Integer> years = new TreeSet<>(defensemanWinners.keySet()).descendingSet();
        display.printOutput(TrophySystemConstants.LineSeperator.getValue() + TrophySystemConstants.LineSpace.getValue() +
                TrophySystemConstants.DefenseManTrophy.getValue() + TrophySystemConstants.LineSpace.getValue()
                + TrophySystemConstants.LineSeperator.getValue());
        for(Integer currentYear: years){
            display.printOutput(TrophySystemConstants.Year.getValue() + currentYear
                    + TrophySystemConstants.Winner.getValue() +defensemanWinners.get(currentYear).getPlayerName()
                    + TrophySystemConstants.LineSpace.getValue());
        }
    }
}
