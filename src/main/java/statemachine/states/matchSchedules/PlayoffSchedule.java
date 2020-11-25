package statemachine.states.matchSchedules;

import leagueobjectmodel.IConferenceModel;
import leagueobjectmodel.IDivisonModel;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayoffSchedule implements IPlayoffSchedule {

    List<List<ITeamsModel>> topTeamFromDivisionList = new ArrayList<>();
    List<ITeamsModel> allTheTopTeams = new ArrayList<>();

    @Override
    public List<List<ITeamsModel>> generatePlayoffSchedule(ILeagueModel leagueModel) {
        for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                Collections.sort(divisonModel.getTeams(), teamModelComparator);
                List<ITeamsModel> subList = new ArrayList<>();
                System.out.println(divisonModel.getTeams().size());
                for (int i = 0; i < 3; i++) {
                    subList.add(divisonModel.getTeams().get(i));
                    allTheTopTeams.add(divisonModel.getTeams().get(i));
                }
                topTeamFromDivisionList.add(subList);
            }
        }
        List<ITeamsModel> wildCardTeam = getWildCardTeam(leagueModel);
        List<List<ITeamsModel>> finalSchedule = generateScheduleWithWIldCard(topTeamFromDivisionList, wildCardTeam);
        return finalSchedule;
    }

    private List<ITeamsModel> getWildCardTeam(ILeagueModel leagueModel) {
        List<ITeamsModel> allTeamsList = new ArrayList<>();
        for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                for (ITeamsModel teamsModel : divisonModel.getTeams()) {
                    allTeamsList.add(teamsModel);
                }
            }
        }
        Collections.sort(allTeamsList, teamModelComparator);
        allTeamsList.removeAll(allTheTopTeams);
        Collections.sort(allTeamsList, teamModelComparator);
        return allTeamsList;
    }

    List<List<ITeamsModel>> generateScheduleWithWIldCard(List<List<ITeamsModel>> topTeamFromDivisionList, List<ITeamsModel> wildCardList) {
        List<List<ITeamsModel>> schedule = new ArrayList<>();
        int i = 0;
        int wildCardTeamCount = 0;

        for (List<ITeamsModel> teamsModelList : topTeamFromDivisionList) {
            if (wildCardTeamCount > 2) {
                break;
            }
            List<ITeamsModel> matchWithWildCard = new ArrayList<>();
            System.out.println(wildCardTeamCount);
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
