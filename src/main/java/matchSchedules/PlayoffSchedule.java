package matchSchedules;

import conference.ConferenceModel;
import divison.DivisonModel;
import league.LeagueModel;
import teams.TeamsModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayoffSchedule implements IPlayoffSchedule {

    List<List<TeamsModel>> topTeamFromDivisionList = new ArrayList<>();
    List<TeamsModel> allTheTopTeams = new ArrayList<>();

    @Override
    public List<List<TeamsModel>> generatePlayoffSchedule(LeagueModel leagueModel) {
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                Collections.sort(divisonModel.getTeams(), teamModelComparator);
                List<TeamsModel> subList = new ArrayList<>();
                System.out.println(divisonModel.getTeams().size());
                for (int i = 0; i < 3; i++) {
                    subList.add(divisonModel.getTeams().get(i));
                    allTheTopTeams.add(divisonModel.getTeams().get(i));
                }
                topTeamFromDivisionList.add(subList);
            }
        }
        List<TeamsModel> wildCardTeam = getWildCardTeam(leagueModel);
        List<List<TeamsModel>> finalSchedule = generateScheduleWithWIldCard(topTeamFromDivisionList, wildCardTeam);
        return finalSchedule;
    }
    private List<TeamsModel> getWildCardTeam(LeagueModel leagueModel) {
        List<TeamsModel> allTeamsList = new ArrayList<>();
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                for (TeamsModel teamsModel : divisonModel.getTeams()) {
                    allTeamsList.add(teamsModel);
                }
            }
        }
        Collections.sort(allTeamsList, teamModelComparator);
        allTeamsList.removeAll(allTheTopTeams);
        Collections.sort(allTeamsList, teamModelComparator);
        return allTeamsList;
    }
    List<List<TeamsModel>> generateScheduleWithWIldCard(List<List<TeamsModel>> topTeamFromDivisionList, List<TeamsModel> wildCardList) {
        List<List<TeamsModel>> schedule = new ArrayList<>();
        int i = 0;
        int wildCardTeamCount = 0;

            for (List<TeamsModel> teamsModelList : topTeamFromDivisionList) {
                if(wildCardTeamCount>2){
                    break;
                }
                List<TeamsModel> matchWithWildCard = new ArrayList<>();
                System.out.println(wildCardTeamCount);
                matchWithWildCard.add(teamsModelList.get(wildCardTeamCount));
                matchWithWildCard.add(wildCardList.get(i));
                schedule.add(matchWithWildCard);
                List<TeamsModel> matchWithEachOther = new ArrayList<>();
                matchWithEachOther.add(teamsModelList.get(i + 1));
                matchWithEachOther.add(teamsModelList.get(i + 2));
                schedule.add(matchWithEachOther);
                i = 0;
                wildCardTeamCount++;

        }
        return schedule;
    }
    public static Comparator<TeamsModel> teamModelComparator = new Comparator<TeamsModel>() {
        @Override
        public int compare(TeamsModel o1, TeamsModel o2) {
            int teamOneWinPoint = o1.getWinPoint();
            int teamTwoWinPoint = o2.getWinPoint();
            return teamTwoWinPoint - teamOneWinPoint;
        }
    };


}
