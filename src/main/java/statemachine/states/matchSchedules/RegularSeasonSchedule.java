package statemachine.states.matchSchedules;

import leagueobjectmodel.ConferenceModel;
import leagueobjectmodel.DivisonModel;
import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.TeamsModel;

import java.util.ArrayList;
import java.util.List;

public class RegularSeasonSchedule implements IRegularSeasonSchedule {


    List<List<TeamsModel>> regularSchedule;

    @Override
    public List<List<TeamsModel>> generateSeasonSchedule(LeagueModel leagueModel) {
        regularSchedule = new ArrayList<>();
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            List<TeamsModel> teamsOfDifferentConference = getOutOfConferenceTeamList(conferenceModel.getConferenceName(), leagueModel.getConferences());
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                List<TeamsModel> teamsOfDifferentDivision = getOutOfDivisionTeamList(divisonModel.getDivisionName(), conferenceModel.getDivisions());
                for (TeamsModel teamsModel : divisonModel.getTeams()) {
                    List<TeamsModel> sameDivisionTeamList = getSameDivisionTeamList(teamsModel.getTeamName(), divisonModel);
                    //adding teams for same division
                    List<TeamsModel> individualTeams = new ArrayList<>();
                    for (TeamsModel obj : sameDivisionTeamList) {
                        //game will be played 4 times
                        for (int i = 0; i < 4; i++) {
                            individualTeams.add(obj);
                            individualTeams.add(teamsModel);
                            regularSchedule.add(new ArrayList<>(individualTeams));
                            individualTeams.clear();
                        }
                    }
                    //adding teams for different division
                    for (TeamsModel obj : teamsOfDifferentDivision) {
                        for (int i = 0; i < 4; i++) {
                            individualTeams.add(obj);
                            individualTeams.add(teamsModel);
                            regularSchedule.add(new ArrayList<>(individualTeams));
                            individualTeams.clear();
                        }
                    }
                    //adding teams for different division
                    for (TeamsModel obj : teamsOfDifferentConference) {
                        for (int i = 0; i < 2; i++) {
                            individualTeams.add(obj);
                            individualTeams.add(teamsModel);
                            regularSchedule.add(new ArrayList<>(individualTeams));
                            individualTeams.clear();
                        }
                    }

                    //Here first i will call the method for training
                    //Then i will call the method for trade offer
                    //For trade offer i need to pass any league model object and i also need to apss two team along with the win and loss point with that
                    //Then in return i will get league model with the updated league object that might have traded teams.


                }
            }
        }
        return regularSchedule;
    }


    private List<TeamsModel> getOutOfConferenceTeamList(String conferenceName, List<ConferenceModel> conferenceModelList) {
        List<TeamsModel> differentConferenceTeamList = new ArrayList<>();
        if (conferenceName == null || conferenceName.equals("")) {
            return null;
        }
        for (ConferenceModel conferenceModel : conferenceModelList) {
            if (conferenceModel.getConferenceName().equals(conferenceName)) {
                continue;
            } else {
                for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                    differentConferenceTeamList.addAll(divisonModel.getTeams());
                }
            }
        }
        return differentConferenceTeamList;
    }

    private List<TeamsModel> getOutOfDivisionTeamList(String divisionName, List<DivisonModel> divisionModelList) {
        List<TeamsModel> differentDivisionTeamList = new ArrayList<>();
        if (divisionName == null || divisionName.equals("")) {
            return null;
        }
        for (DivisonModel divisonModel : divisionModelList) {
            if (divisonModel.getDivisionName().equals(divisionName)) {
                continue;
            } else {
                differentDivisionTeamList.addAll(divisonModel.getTeams());
            }
        }
        return differentDivisionTeamList;
    }

    private List<TeamsModel> getSameDivisionTeamList(String teamName, DivisonModel divisonModel) {
        List<TeamsModel> sameDivisionTeamList = new ArrayList<>();
        if (teamName == null || teamName.equals("")) {
            return null;
        }
        for (TeamsModel teamsModel : divisonModel.getTeams()) {
            if (teamsModel.getTeamName().equals(teamName)) {
                continue;
            } else {
                sameDivisionTeamList.add(teamsModel);
            }
        }
        return sameDivisionTeamList;
    }
}
