package statemachine.jsonparser;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueModel;

public interface ICliCommunication {

    ILeagueModel loadTeamFromDatabase();

    boolean isFileExist(String fileName);

    ILeagueModel parseJson(String fileName);

    LeagueModel calculateStrength(LeagueModel leagueModel) throws Exception;
}
