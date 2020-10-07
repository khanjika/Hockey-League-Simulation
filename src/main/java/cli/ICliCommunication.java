package cli;

import java.io.IOException;

public interface ICliCommunication {


     void loadTeamFromDatabase();
     boolean isFileExist(String fileName);

     void parseJson(String fileName) throws IOException;
}
