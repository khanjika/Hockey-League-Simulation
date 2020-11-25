package cli;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueModel;

public interface ICliCommunication {

    boolean loadTeamFromDatabase();

    boolean isFileExist(String fileName);

    ILeagueModel parseJson(String fileName);

    LeagueModel calculateStrength(LeagueModel leagueModel) throws Exception;
}
