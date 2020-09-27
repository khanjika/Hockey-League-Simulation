package cli;

import java.io.File;
import java.io.IOException;

public class InitialCli {

    private  static ICliCommunication cliCommunication;

    public InitialCli() {
        cliCommunication =new CliCommunication();
    }


    public void initializedCommunication(String fileName)  {
            if(cliCommunication.isFileExist(fileName)){
                try {
                    cliCommunication.parseJson(fileName);
                }
                catch (IOException e){
                    System.out.println("Error while parsing the file"+e);
                }

            }
            else{
                System.out.println("File does not exist in the specified location");
            }
        }



}
