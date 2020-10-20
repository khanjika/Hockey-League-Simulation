package conference;

public interface IConferenceModel {
    boolean isConferenceAlreadyExist(String conferenceName, int leagueId);
    int getConferenceId(String conferenceName, int leagueId);
    void storeConferenceInformation(ConferenceModel conferenceModel, int leagueId);
}
