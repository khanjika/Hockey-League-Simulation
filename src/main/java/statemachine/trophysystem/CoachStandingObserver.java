package statemachine.trophysystem;

import cli.ICli;
import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.*;

public class CoachStandingObserver implements IObserver {

    private HashMap<Integer, HeadCoachModel> bestCoachWinners = new HashMap<>();
    final static Logger logger = Logger.getLogger(CoachStandingObserver.class);

    @Override
    public void update(ILeagueModel leagueModel, int year) {
        logger.info(TrophySystemConstants.LogInfoCoachUpdate.getValue());
        List<HeadCoachModel> bestCoachOfEachTeam = new ArrayList<>();
        for(IConferenceModel conference : leagueModel.getConferences()){
            for(IDivisonModel division : conference.getDivisions()) {
                for(ITeamsModel team : division.getTeams()){
                    bestCoachOfEachTeam.add(team.getHeadCoach());
                }
            }
        }
        bestCoachWinners.put(year, Collections.max(bestCoachOfEachTeam,Comparator
                .comparing(HeadCoachModel::getTrainingPlayerPoints)));
    }

    @Override
    public void getHistoryOfWinners(ICli display) {
        logger.info(TrophySystemConstants.LogInfoCoachDisplay.getValue());
        SortedSet<Integer> years = new TreeSet<>(bestCoachWinners.keySet()).descendingSet();
        display.printOutput(TrophySystemConstants.LineSeperator.getValue()  + TrophySystemConstants.LineSpace.getValue()
                + TrophySystemConstants.CoachTrophy.getValue() + TrophySystemConstants.LineSpace.getValue()
                + TrophySystemConstants.LineSeperator.getValue());
        for(Integer currentYear: years){
            display.printOutput(TrophySystemConstants.Year.getValue() + currentYear
                    + TrophySystemConstants.Winner.getValue() +bestCoachWinners.get(currentYear).getName()
                    + TrophySystemConstants.LineSpace.getValue());
        }
    }

}
