package statemachine.trophysystem;

import cli.ICli;
import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.*;

import static java.util.Comparator.comparing;

public class TeamStandingObserver implements IObserver{

    private final HashMap<Integer, ITeamsModel> bestTeamWinners = new HashMap<>();
    private final HashMap<Integer, ITeamsModel> lowestTeamWinners = new HashMap<>();
    final static Logger logger = Logger.getLogger(TeamStandingObserver.class);

    @Override
    public void update(ILeagueModel leagueModel, int year) {
        logger.info(TrophySystemConstants.LogInfoTeamsUpdate.getValue());
        List<ITeamsModel> bestTeamOfEachDivision = new ArrayList<>();
        List<ITeamsModel> lowestTeamOfEachDivison = new ArrayList<>();

        for(IConferenceModel conference : leagueModel.getConferences()){
            for(IDivisonModel division : conference.getDivisions()){
                bestTeamOfEachDivision.add(Collections.max(division.getTeams(),
                        comparing(v -> v.getWinPoint())));
                lowestTeamOfEachDivison.add(Collections.max(division.getTeams(),
                        comparing(v -> v.getLossPoint())));
            }
        }
        bestTeamWinners.put(year, Collections.max(bestTeamOfEachDivision,Comparator
                .comparing(ITeamsModel::getWinPoint)));
        lowestTeamWinners.put(year, Collections.max(bestTeamOfEachDivision,Comparator
                .comparing(ITeamsModel::getLossPoint)));
    }

    @Override
    public void getHistoryOfWinners(ICli display){
        logger.info(TrophySystemConstants.LogInfoTeamsDisplay.getValue());
        SortedSet<Integer> years = new TreeSet<>(bestTeamWinners.keySet()).descendingSet();
        display.printOutput(TrophySystemConstants.LineSeperator.getValue() + TrophySystemConstants.LineSpace.getValue() + TrophySystemConstants.BestTeamTrophy.getValue()
                + TrophySystemConstants.LineSpace.getValue()
                + TrophySystemConstants.LineSeperator.getValue());
        for(Integer currentYear: years){
            display.printOutput(TrophySystemConstants.Year.getValue() + currentYear
                    + TrophySystemConstants.Winner.getValue() + bestTeamWinners.get(currentYear).getTeamName()
                    + TrophySystemConstants.LineSpace.getValue());
        }
        years = new TreeSet<>(lowestTeamWinners.keySet()).descendingSet();
        display.printOutput(TrophySystemConstants.LineSeperator.getValue() + TrophySystemConstants.LineSpace.getValue() +
                TrophySystemConstants.LowestTeamTrophy.getValue()
                + TrophySystemConstants.LineSpace.getValue()
                + TrophySystemConstants.LineSeperator.getValue());
        for(Integer currentYear: years){
            display.printOutput(TrophySystemConstants.Year.getValue() + currentYear
                    + TrophySystemConstants.Winner.getValue() +lowestTeamWinners.get(currentYear).getTeamName()
                    + TrophySystemConstants.LineSpace.getValue());
        }
    }
}
