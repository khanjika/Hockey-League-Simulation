package cli;

import league.LeagueModel;

import java.awt.image.VolatileImage;
import java.io.IOException;

public interface ICliCommunication {

     void loadTeamFromDatabase();
     boolean isFileExist(String fileName);

     LeagueModel parseJson(String fileName) throws IOException;
}
