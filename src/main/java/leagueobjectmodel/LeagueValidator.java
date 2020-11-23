package leagueobjectmodel;

public class LeagueValidator implements ILeagueValidator {

    private static IConferenceValidator conferenceValidator;
    private static IFreeAgentValidator freeAgentValidator;
    private static ICoachValidator coachValidator;

    private boolean validateFlag = false;

    public LeagueValidator() {
        conferenceValidator = new ConferenceValidator();
        freeAgentValidator = new FreeAgentValidator();
        coachValidator = new CoachValidator();
    }

    @Override
    public boolean validateLeagueObject(LeagueModel leagueModel) {

        if (leagueModel.getLeagueName() == "" || leagueModel.getLeagueName() == null) {
            System.out.println("League name can not be empty");
            return false;
        }
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            if (conferenceValidator.validateConferenceObject(conferenceModel)) {
                continue;
            } else {
                System.out.println("Encountered Problem While validating Conferences");
                return false;
            }
        }
        for (FreeAgentModel freeAgentModel : leagueModel.getFreeAgents()) {
            System.out.println("Validating Free Agents  " +freeAgentModel );
            if (freeAgentValidator.validateFreeAgentObject(freeAgentModel)) {
                continue;
            } else {
                System.out.println("Encountered Problem While validating Free Agents in the league==> " + leagueModel.getLeagueName());
                return false;
            }
        }

        for (CoachModel coachModel : leagueModel.getCoaches()) {
            if (coachValidator.validateCoachObject(coachModel)) {
                continue;
            } else {
                System.out.println("Encountered Problem While validating Coach in the League==>" + leagueModel.getLeagueName());
            }
        }

        if (leagueModel.getFreeAgents().size() >= 20) {
            if (leagueModel.getConferences().size() % 2 == 0) {
                if (leagueModel.getCoaches().size() > 0) {
                    if (leagueModel.getGeneralManagers().size() > 0) {
                        validateFlag = true;
                    } else {
                        System.out.println("Not enough Managers");
                    }
                } else {
                    System.out.println("Not enough coaches");
                }
            } else {
                System.out.println("Number of Conference is not even");
            }
        } else {
            System.out.println("Number of free agents is less than 20");
        }
        return validateFlag;
//       return true;
    }
}
