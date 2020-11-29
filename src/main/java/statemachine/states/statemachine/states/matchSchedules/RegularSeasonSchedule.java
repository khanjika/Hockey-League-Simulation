package statemachine.states.statemachine.states.matchSchedules;

import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class RegularSeasonSchedule implements IRegularSeasonSchedule {


    List<List<ITeamsModel>> regularSchedule;
    final static Logger logger = Logger.getLogger(RegularSeasonSchedule.class);

    @Override
    public List<List<ITeamsModel>> generateSeasonSchedule(ILeagueModel leagueModel) {
        if (leagueModel == null) {
            logger.error("League Model object is not initialized in the Regular Season PlayOff schedule");
            throw new NullPointerException("League Model object is not initialized in the Regular Season PlayOff schedule");
        }
        regularSchedule = new ArrayList<>();
        try {
            for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
                List<TeamsModel> teamsOfDifferentConference = getOutOfConferenceTeamList(conferenceModel.getConferenceName(), leagueModel.getConferences());
                for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                    List<TeamsModel> teamsOfDifferentDivision = getOutOfDivisionTeamList(divisonModel.getDivisionName(), conferenceModel.getDivisions());
                    for (TeamsModel teamsModel : divisonModel.getTeams()) {
                        List<TeamsModel> sameDivisionTeamList = getSameDivisionTeamList(teamsModel.getTeamName(), divisonModel);
                        List<TeamsModel> individualTeams = new ArrayList<>();
                        for (TeamsModel obj : sameDivisionTeamList) {
                            for (int i = 0; i < 4; i++) {
                                individualTeams.add(obj);
                                individualTeams.add(teamsModel);
                                regularSchedule.add(new ArrayList<>(individualTeams));
                                individualTeams.clear();
                            }
                        }
                        for (TeamsModel obj : teamsOfDifferentDivision) {
                            for (int i = 0; i < 4; i++) {
                                individualTeams.add(obj);
                                individualTeams.add(teamsModel);
                                regularSchedule.add(new ArrayList<>(individualTeams));
                                individualTeams.clear();
                            }
                        }
                        for (TeamsModel obj : teamsOfDifferentConference) {
                            for (int i = 0; i < 2; i++) {
                                individualTeams.add(obj);
                                individualTeams.add(teamsModel);
                                regularSchedule.add(new ArrayList<>(individualTeams));
                                individualTeams.clear();
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e){
            logger.error("Exception while parsing in Regular Season Schedule schedule class (generateSeasonSchedule method)");
            throw e;
        }

        return regularSchedule;
    }


    private List<TeamsModel> getOutOfConferenceTeamList(String conferenceName, List<ConferenceModel> conferenceModelList) {
        if (conferenceModelList == null || conferenceName.isEmpty()) {
            logger.error("Null conference list or conference name in Regular Season schedule class (getOutOfConferenceTeamList method)");
            throw new NullPointerException("Null conference list or conference name in Regular Season schedule class (getOutOfConferenceTeamList method)");
        }
        List<TeamsModel> differentConferenceTeamList = new ArrayList<>();
        for (IConferenceModel conferenceModel : conferenceModelList) {
            if (conferenceModel.getConferenceName().equals(conferenceName)) {
                continue;
            } else {
                for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                    differentConferenceTeamList.addAll(divisonModel.getTeams());
                }
            }
        }
        return differentConferenceTeamList;
    }

    private List<TeamsModel> getOutOfDivisionTeamList(String divisionName, List<DivisonModel> divisionModelList) {
        if (divisionModelList == null || divisionName.isEmpty()) {
            logger.error("Null divisionModelList or divisionModelList in Regular Season schedule class (getOutOfDivisionTeamList method)");
            throw new NullPointerException("Null divisionModelList or conference name in Regular Season schedule class (getOutOfDivisionTeamList method)");
        }
        List<TeamsModel> differentDivisionTeamList = new ArrayList<>();
        for (DivisonModel divisonModel : divisionModelList) {
            if (divisonModel.getDivisionName().equals(divisionName)) {
                continue;
            } else {
                differentDivisionTeamList.addAll(divisonModel.getTeams());
            }
        }
        return differentDivisionTeamList;
    }

    private List<TeamsModel> getSameDivisionTeamList(String teamName, IDivisonModel divisonModel) {
        if ( divisonModel== null || teamName.isEmpty()) {
            logger.error("Null divisonModel or teamName in Regular Season schedule class (getSameDivisionTeamList method)");
            throw new NullPointerException("Null divisonModel or teamName in Regular Season schedule class (getSameDivisionTeamList method)");
        }
        List<TeamsModel> sameDivisionTeamList = new ArrayList<>();
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
