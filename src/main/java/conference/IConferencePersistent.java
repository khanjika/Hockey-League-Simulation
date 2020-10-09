package conference;

public interface IConferencePersistent {

     int addConferenceInformation(String conferenceName, int leagueId);

     boolean isConferenceAlreadyExist(String conferenceName, int leagueId);

     int getConferenceInformation(String conferenceName, int leagueId);
}
