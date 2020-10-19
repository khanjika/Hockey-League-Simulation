package league;

import coach.CoachModel;
import coach.CoachValidator;
import coach.ICoachValidator;
import conference.ConferenceModel;
import conference.ConferenceValidator;
import conference.IConferenceValidator;
import divison.DivisonModel;
import divison.DivisonValidator;
import divison.IDivisonValidator;
import freeagent.FreeAgentModel;
import freeagent.FreeAgentValidator;
import freeagent.IFreeAgentValidator;
import players.IPlayerValidator;
import players.PlayerModel;
import players.PlayerValidator;
import teams.ITeamsValidator;
import teams.TeamsModel;
import teams.TeamsValidator;

public class LeagueValidator implements ILeagueValidator {

    private static IConferenceValidator conferenceValidator;
    private static IFreeAgentValidator freeAgentValidator;
    private static ICoachValidator coachValidator;

    private int numberOfConference = 0;

    public LeagueValidator() {
        conferenceValidator = new ConferenceValidator();
        freeAgentValidator = new FreeAgentValidator();
        coachValidator =new CoachValidator();
    }

    @Override
    public boolean validateLeagueObject(LeagueModel leagueModel) {

        if (leagueModel.getLeagueName() == "" || leagueModel.getLeagueName() == null) {
            System.out.println("League name can not be empty");
            return false;
        }
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            numberOfConference++;
            if (conferenceValidator.validateConferenceObject(conferenceModel)) {
                continue;
            } else {
                System.out.println("Encountered Problem While validating Conferences");
                return false;
            }
        }
        for (FreeAgentModel freeAgentModel : leagueModel.getFreeAgents()) {
            if (freeAgentValidator.validateFreeAgentObject(freeAgentModel)) {
                continue;
            } else {
                System.out.println("Encountered Problem While validating Free Agents in the league==> " + leagueModel.getLeagueName());
                return false;
            }
        }

        for (CoachModel coachModel : leagueModel.getCoaches()){
            if(coachValidator.validateCoachObject(coachModel)){
                continue;
            }
            else {
                System.out.println("Encountered Problem While validating Coach in the League==>" + leagueModel.getLeagueName());
            }
        }

        if (numberOfConference % 2 == 0) {
            return true;
        } else {
            //make to false
          //  System.out.println("Number of Conference is not even");
            return true;
        }
    }

}
