package conference;

import league.LeagueModel;

public interface IConferenceModel {
boolean isConferenceAlreadyExist(String conferenceName, int leagueId);

int getConferenceId(String conferenceName, int leagueId);
}
