package leagueobjectmodel;

import cli.CliAbstractFactory;
import cli.ICli;

public class DivisonValidator implements IDivisonValidator {

    private static final ITeamsValidator teamsValidator = new TeamsValidator();
    ICli cli = CliAbstractFactory.getInstance().getCli();

    @Override
    public boolean validateDivisionObject(IDivisonModel divisonModel) {
        if (divisonModel.getDivisionName() == "" || divisonModel.getDivisionName() == null) {
            return false;
        } else {
            for (ITeamsModel teamsModel : divisonModel.getTeams()) {
                if (teamsValidator.validateTeamObject(teamsModel)) {
                    continue;
                } else {
                    cli.printOutput("Encountered Problem While validating Teams in Division ==> " + divisonModel.getDivisionName());
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isDivisionExist(ILeagueModel leagueModel, String divisionName) {
        for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                if (divisonModel.getDivisionName().equalsIgnoreCase(divisionName)) {
                    return true;
                }
            }
        }

        return false;
    }
}
