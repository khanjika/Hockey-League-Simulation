package statemachine.simulateGame.matchSchedules;

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
                List<ITeamsModel> teamsOfDifferentConference = getOutOfConferenceTeamList(conferenceModel.getConferenceName(), leagueModel.getConferences());
                for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                    List<ITeamsModel> teamsOfDifferentDivision = getOutOfDivisionTeamList(divisonModel.getDivisionName(), conferenceModel.getDivisions());
                    for (ITeamsModel teamsModel : divisonModel.getTeams()) {
                        List<ITeamsModel> sameDivisionTeamList = getSameDivisionTeamList(teamsModel.getTeamName(), divisonModel);
                        List<ITeamsModel> individualTeams = new ArrayList<>();
                        for (ITeamsModel obj : sameDivisionTeamList) {
                            for (int i = 0; i < 4; i++) {
                                individualTeams.add(obj);
                                individualTeams.add(teamsModel);
                                regularSchedule.add(new ArrayList<>(individualTeams));
                                individualTeams.clear();
                            }
                        }
                        for (ITeamsModel obj : teamsOfDifferentDivision) {
                            for (int i = 0; i < 4; i++) {
                                individualTeams.add(obj);
                                individualTeams.add(teamsModel);
                                regularSchedule.add(new ArrayList<>(individualTeams));
                                individualTeams.clear();
                            }
                        }
                        for (ITeamsModel obj : teamsOfDifferentConference) {
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


    private List<ITeamsModel> getOutOfConferenceTeamList(String conferenceName, List<IConferenceModel> conferenceModelList) {
        if (conferenceModelList == null || conferenceName.isEmpty()) {
            logger.error("Null conference list or conference name in Regular Season schedule class (getOutOfConferenceTeamList method)");
            throw new NullPointerException("Null conference list or conference name in Regular Season schedule class (getOutOfConferenceTeamList method)");
        }
        List<ITeamsModel> differentConferenceTeamList = new ArrayList<>();
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

    private List<ITeamsModel> getOutOfDivisionTeamList(String divisionName, List<IDivisonModel> divisionModelList) {
        if (divisionModelList == null || divisionName.isEmpty()) {
            logger.error("Null divisionModelList or divisionModelList in Regular Season schedule class (getOutOfDivisionTeamList method)");
            throw new NullPointerException("Null divisionModelList or conference name in Regular Season schedule class (getOutOfDivisionTeamList method)");
        }
        List<ITeamsModel> differentDivisionTeamList = new ArrayList<>();
        for (IDivisonModel divisonModel : divisionModelList) {
            if (divisonModel.getDivisionName().equals(divisionName)) {
                continue;
            } else {
                differentDivisionTeamList.addAll(divisonModel.getTeams());
            }
        }
        return differentDivisionTeamList;
    }

    private List<ITeamsModel> getSameDivisionTeamList(String teamName, IDivisonModel divisonModel) {
        if ( divisonModel== null || teamName.isEmpty()) {
            logger.error("Null divisonModel or teamName in Regular Season schedule class (getSameDivisionTeamList method)");
            throw new NullPointerException("Null divisonModel or teamName in Regular Season schedule class (getSameDivisionTeamList method)");
        }
        List<ITeamsModel> sameDivisionTeamList = new ArrayList<>();
        for (ITeamsModel teamsModel : divisonModel.getTeams()) {
            if (teamsModel.getTeamName().equals(teamName)) {
                continue;
            } else {
                sameDivisionTeamList.add(teamsModel);
            }
        }
        return sameDivisionTeamList;
    }
}
