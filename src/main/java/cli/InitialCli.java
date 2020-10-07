package cli;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class InitialCli {

    private  static ICliCommunication cliCommunication;
    Scanner scannerObject;

    public InitialCli() {
        cliCommunication =new CliCommunication();
        scannerObject = new Scanner(System.in);
    }

    public void initializedCommunication()  {
        System.out.println("Do you want to provide json path to import ?");
        String userInput = scannerObject.nextLine();
        if(userInput.equalsIgnoreCase("yes")){
            parseJson();
        }
        else{
            System.out.println("Loading team....");
            cliCommunication.loadTeamFromDatabase();
        }
    }

    public void parseJson(){
        System.out.println("Provide complete file path");
        String filePath=scannerObject.nextLine();
        if(cliCommunication.isFileExist(filePath)){
            try {
                cliCommunication.parseJson(filePath);
            }
            catch (IOException e){
                System.out.println("Error while parsing the file"+e);
            }
        }
        else{
            System.out.println("File does not exists in the specified location");
        }
    }



}
