package statemachine.trophysystem;

import cli.ICli;
import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class ForwardStandingObserver implements IObserver{

    private HashMap<Integer, PlayerModel> forwardWinners = new HashMap<>();
    final static Logger logger = Logger.getLogger(ForwardStandingObserver.class);

    @Override
    public void update(ILeagueModel leagueModel, int year) {
        logger.info(TrophySystemConstants.LogInfoForwardUpdate.getValue());
        List<PlayerModel> bestForwardOfEachTeam = new ArrayList<>();
        for(IConferenceModel conference : leagueModel.getConferences()){
            for(IDivisonModel division : conference.getDivisions()) {
                for (ITeamsModel team : division.getTeams()) {
                    bestForwardOfEachTeam.add(Collections.max(team.getPlayers().stream()
                            .filter(l -> l.getPosition().equals(PlayerPosition.FORWARD.toString()))
                            .collect(Collectors.toList()),
                            Comparator.comparing(v -> v.getGoalScorerCount())));
                }
            }
        }
        forwardWinners.put(year, Collections.max(bestForwardOfEachTeam,Comparator
                .comparing(PlayerModel::getGoalScorerCount)));
    }

    @Override
    public void getHistoryOfWinners(ICli display){
        logger.info(TrophySystemConstants.LogInfoForwardDisplay.getValue());
        SortedSet<Integer> years = new TreeSet<>(forwardWinners.keySet()).descendingSet();
        display.printOutput(TrophySystemConstants.LineSeperator.getValue() + TrophySystemConstants.LineSpace.getValue() +
                TrophySystemConstants.ForwardManTrophy.getValue() + TrophySystemConstants.LineSpace.getValue()
                + TrophySystemConstants.LineSeperator.getValue());
        for(Integer currentYear: years){
            display.printOutput(TrophySystemConstants.Year.getValue() + currentYear
                    + TrophySystemConstants.Winner.getValue() +forwardWinners.get(currentYear).getPlayerName()
                    + TrophySystemConstants.LineSpace.getValue());
        }
    }
}
