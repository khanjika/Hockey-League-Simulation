package statemachine.trophysystem;

import cli.IDisplay;
import leagueobjectmodel.*;
import java.util.*;

public class CoachStandingObserver implements IObserver {

    private HashMap<Integer, HeadCoachModel> bestCoachWinners = new HashMap<>();

    @Override
    public void update(ILeagueModel leagueModel, int year) {
        List<HeadCoachModel> bestCoachOfEachTeam = new ArrayList<>();
        for(ConferenceModel conference : leagueModel.getConferences()){
            for(DivisonModel division : conference.getDivisions()) {
                for(TeamsModel team : division.getTeams()){
                    bestCoachOfEachTeam.add(team.getHeadCoach());
                }
            }
        }
        bestCoachWinners.put(year, Collections.max(bestCoachOfEachTeam,Comparator
                .comparing(HeadCoachModel::getTrainingPlayerPoints)));
    }

    @Override
    public void getHistoryOfWinners(IDisplay display) {
        SortedSet<Integer> years = new TreeSet<>(bestCoachWinners.keySet()).descendingSet();
        for(Integer currentYear: years){
            display.displayAwards(TrophySystemConstants.CoachTrophy.getValue(), bestCoachWinners.get(currentYear).getName() , currentYear);
        }
    }

}
