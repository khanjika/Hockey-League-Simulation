package statemachine.simulateGame.matchSchedules;

import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayoffSchedule implements IPlayoffSchedule {

    List<List<ITeamsModel>> topTeamFromDivisionList = new ArrayList<>();
    List<ITeamsModel> allTheTopTeams = new ArrayList<>();
    final static Logger logger = Logger.getLogger(PlayoffSchedule.class);

    @Override
    public List<List<ITeamsModel>> generatePlayoffSchedule(ILeagueModel leagueModel) throws Exception {
        if(leagueModel==null){
            logger.error("League Model object is not initialized in the PlayOff schedule");
            throw new NullPointerException("League Model object is not initialized in the PlayOff schedule");
        }
        try {
            for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
                for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                    Collections.sort(divisonModel.getTeams(), teamModelComparator);
                    List<ITeamsModel> subList = new ArrayList<>();
                    for (int i = 0; i < 3; i++) {
                        subList.add(divisonModel.getTeams().get(i));
                        allTheTopTeams.add(divisonModel.getTeams().get(i));
                    }
                    topTeamFromDivisionList.add(subList);
                }
            }
        }
        catch (Exception e){
            logger.error("Exception while parsing in Playoff schedule class (generatePlayoffSchedule method)");
            throw e;
        }
        List<ITeamsModel> wildCardTeam = getWildCardTeam(leagueModel);
        List<List<ITeamsModel>> finalSchedule = generateScheduleWithWIldCard(topTeamFromDivisionList, wildCardTeam);
        return finalSchedule;
    }

    private List<ITeamsModel> getWildCardTeam(ILeagueModel leagueModel) throws Exception{
        if(leagueModel==null){
            logger.error("League Model object is not initialized in the PlayOff schedule");
            throw new NullPointerException("League Model object is not initialized in the PlayOff schedule");
        }
        List<ITeamsModel> allTeamsList = new ArrayList<>();
        try {
            for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
                for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                    for (ITeamsModel teamsModel : divisonModel.getTeams()) {
                        allTeamsList.add(teamsModel);
                    }
                }
            }
        }catch (Exception e){
            logger.error("Exception while parsing in Playoff schedule class (getWildCardTeam method)");
            throw e;
        }
        Collections.sort(allTeamsList, teamModelComparator);
        allTeamsList.removeAll(allTheTopTeams);
        Collections.sort(allTeamsList, teamModelComparator);
        return allTeamsList;
    }

   private List<List<ITeamsModel>> generateScheduleWithWIldCard(List<List<ITeamsModel>> topTeamFromDivisionList, List<ITeamsModel> wildCardList) {
        if(topTeamFromDivisionList==null || wildCardList==null){
            logger.error("Top team from division list or wild card list is not initialized in the PlayOff schedule");
            throw new NullPointerException("Top team from division list or wild card list is not initialized in the PlayOff schedule");
        }
        List<List<ITeamsModel>> schedule = new ArrayList<>();
        int i = 0;
        int wildCardTeamCount = 0;

        try {
            for (List<ITeamsModel> teamsModelList : topTeamFromDivisionList) {
                if (wildCardTeamCount > 2) {
                    break;
                }
                List<ITeamsModel> matchWithWildCard = new ArrayList<>();
                matchWithWildCard.add(teamsModelList.get(wildCardTeamCount));
                matchWithWildCard.add(wildCardList.get(i));
                schedule.add(matchWithWildCard);
                List<ITeamsModel> matchWithEachOther = new ArrayList<>();
                matchWithEachOther.add(teamsModelList.get(i + 1));
                matchWithEachOther.add(teamsModelList.get(i + 2));
                schedule.add(matchWithEachOther);
                i = 0;
                wildCardTeamCount++;

            }
        }catch (Exception e){
            logger.error("Exception while parsing in Playoff schedule class (generateScheduleWithWIldCard method)");
            throw e;
        }
        return schedule;
    }

    public static Comparator<ITeamsModel> teamModelComparator = new Comparator<ITeamsModel>() {
        @Override
        public int compare(ITeamsModel o1, ITeamsModel o2) {
            int teamOneWinPoint = o1.getWinPoint();
            int teamTwoWinPoint = o2.getWinPoint();
            return teamTwoWinPoint - teamOneWinPoint;
        }
    };


}
