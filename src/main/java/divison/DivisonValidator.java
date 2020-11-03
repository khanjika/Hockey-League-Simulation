package divison;

import conference.ConferenceModel;
import league.LeagueModel;
import teams.ITeamsValidator;
import teams.TeamsModel;
import teams.TeamsValidator;

public class DivisonValidator implements IDivisonValidator {

    private static final ITeamsValidator teamsValidator = new TeamsValidator();

    @Override
    public boolean validateDivisionObject(DivisonModel divisonModel) {
        if (divisonModel.getDivisionName() == "" || divisonModel.getDivisionName() == null) {
            return false;
        } else {
            for (TeamsModel teamsModel : divisonModel.getTeams()) {
                if (teamsValidator.validateTeamObject(teamsModel)) {
                    continue;
                } else {
                    System.out.println("Encountered Problem While validating Teams in Division ==> " + divisonModel.getDivisionName());
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isDivisionExist(LeagueModel leagueModel, String divisionName) {
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                if (divisonModel.getDivisionName().equalsIgnoreCase(divisionName)) {
                    return true;
                }
            }
        }

        return false;
    }
}
