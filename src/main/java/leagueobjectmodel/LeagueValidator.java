package leagueobjectmodel;

import cli.CliAbstractFactory;
import cli.ICli;

public class LeagueValidator implements ILeagueValidator {

    private static IConferenceValidator conferenceValidator;
    private static IFreeAgentValidator freeAgentValidator;
    private static ICoachValidator coachValidator;
    ICli cli = CliAbstractFactory.getInstance().getCli();

    private boolean validateFlag = false;

    public LeagueValidator() {
        conferenceValidator = new ConferenceValidator();
        freeAgentValidator = new FreeAgentValidator();
        coachValidator = new CoachValidator();
    }

    @Override
    public boolean validateLeagueObject(ILeagueModel leagueModel) {

        if (leagueModel.getLeagueName() == "" || leagueModel.getLeagueName() == null) {
            cli.printOutput("League name can not be empty");
            return false;
        }
        for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
            if (conferenceValidator.validateConferenceObject(conferenceModel)) {
                continue;
            } else {
                cli.printOutput("Encountered Problem While validating Conferences");
                return false;
            }
        }
        for (IFreeAgentModel freeAgentModel : leagueModel.getFreeAgents()) {
            if (freeAgentValidator.validateFreeAgentObject((FreeAgentModel) freeAgentModel)) {
                continue;
            } else {
                cli.printOutput("Encountered Problem While validating Free Agents in the league==> " + leagueModel.getLeagueName());
                return false;
            }
        }

        for (ICoachModel coachModel : leagueModel.getCoaches()) {
            if (coachValidator.validateCoachObject(coachModel)) {
                continue;
            } else {
                cli.printOutput("Encountered Problem While validating Coach in the League==>" + leagueModel.getLeagueName());
            }
        }

        if (leagueModel.getFreeAgents().size() >= 20) {
            if (leagueModel.getConferences().size() % 2 == 0) {
                if (leagueModel.getCoaches().size() > 0) {
                    if (leagueModel.getGeneralManagers().size() > 0) {
                        validateFlag = true;
                    } else {
                        cli.printOutput("Not enough Managers");
                    }
                } else {
                    cli.printOutput("Not enough coaches");
                }
            } else {
                cli.printOutput("Number of Conference is not even");
            }
        } else {
            cli.printOutput("Number of free agents is less than 20");
        }
        return validateFlag;
    }
}
