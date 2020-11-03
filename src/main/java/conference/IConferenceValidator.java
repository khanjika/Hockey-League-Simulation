package conference;

import league.LeagueModel;

public interface IConferenceValidator {

    boolean validateConferenceObject(ConferenceModel conferenceModel);

    boolean isConferenceExist(LeagueModel leagueModel, String conferenceName);
}
