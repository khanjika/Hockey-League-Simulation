package statemachine.trophysystem;

import cli.ICli;
import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class DefensemanStandingObserver implements IObserver{

    PlayerModel currentBestDefenser;
    private HashMap<Integer, PlayerModel> defensemanWinners = new HashMap<>();
    final static Logger logger = Logger.getLogger(DefensemanStandingObserver.class);

    @Override
    public void update(ILeagueModel leagueModel, int year) {
        logger.info(TrophySystemConstants.LogInfoDefenseUpdate.getValue());
        List<PlayerModel> bestGoalieOfEachTeam = new ArrayList<>();
        for(IConferenceModel conference : leagueModel.getConferences()){
            for(IDivisonModel division : conference.getDivisions()) {
                for (ITeamsModel team : division.getTeams()) {
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
        logger.info(TrophySystemConstants.LogInfoDefenseDisplay.getValue());
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
