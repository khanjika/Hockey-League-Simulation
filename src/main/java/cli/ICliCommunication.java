package cli;

import league.LeagueModel;

public interface ICliCommunication {

    boolean loadTeamFromDatabase();

    boolean isFileExist(String fileName);

    LeagueModel parseJson(String fileName);

    LeagueModel calculateStrength(LeagueModel leagueModel) throws Exception;
}
