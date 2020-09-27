package league;

import conference.ConferenceModel;
import conference.ConferenceValidator;
import conference.IConferenceValidator;
import divison.DivisonModel;
import divison.DivisonValidator;
import divison.IDivisonValidator;
import players.IPlayerValidator;
import players.PlayerModel;
import players.PlayerValidator;
import teams.ITeamsValidator;
import teams.TeamsModel;
import teams.TeamsValidator;

public class LeagueValidator implements ILeagueValidator {

    private static IConferenceValidator conferenceValidator;
    private static IDivisonValidator divisonValidator;
    private static ITeamsValidator teamsValidator;
    private static IPlayerValidator playerValidator;
    private int numberOfConference = 0;

    public LeagueValidator() {
        conferenceValidator = new ConferenceValidator();
        divisonValidator = new DivisonValidator();
        teamsValidator = new TeamsValidator();

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
        if (numberOfConference % 2 == 0) {
            return true;
        } else {
            //IMPORTANT NEED TO MAKE IT TO FALSE
            //System.out.println("Number of Conference is not even");
            return true;
        }
    }

}
