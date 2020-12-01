package leagueobjectmodel;

public interface IConferenceValidator {

    boolean validateConferenceObject(IConferenceModel conferenceModel);

    boolean isConferenceExist(ILeagueModel leagueModel, String conferenceName);
}
