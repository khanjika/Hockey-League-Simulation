package cli;

import league.LeagueModel;

import java.io.IOException;

public interface ICliCommunication {

     boolean loadTeamFromDatabase();
     boolean isFileExist(String fileName);

     LeagueModel parseJson(String fileName) throws IOException;
}
