package cli;

import java.io.IOException;

public interface ICliCommunication {

     boolean isFileExist(String fileName);

     void parseJson(String fileName) throws IOException;
}
