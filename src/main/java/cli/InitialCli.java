package cli;

import league.LeagueModel;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class InitialCli {

    private  static ICliCommunication cliCommunication;
    Scanner scannerObject;

    public InitialCli() {
        System.out.println("Intial Cli object is created");
        cliCommunication =new CliCommunication();
        scannerObject = new Scanner(System.in);
    }

    public String initializedCommunication()  {
        System.out.println("Do you want to provide json path to import ?");
        String userInput = scannerObject.nextLine();
        if(userInput.equalsIgnoreCase("yes")){
            return "yes";
        }
        else if(userInput.equalsIgnoreCase("no")){
            System.out.println("You need to provide some information inorder to load team");
            return "no";
        }
        else {
            return "NOT PROVIDED";

        }
    }

    public LeagueModel parseJson(){
        System.out.println("Provide complete file path");
        String filePath=scannerObject.nextLine();
        if(cliCommunication.isFileExist(filePath)){
            try {
               LeagueModel leagueModel= cliCommunication.parseJson(filePath);
               return leagueModel;
            }
            catch (IOException e){
                System.out.println("Error while parsing the file"+e);
            }
        }
        else{
            System.out.println("File does not exists in the specified location");
        }
        return null;
    }

}
