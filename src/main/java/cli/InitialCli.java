package cli;

import league.LeagueModel;

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

//    public boolean initializedCommunication()  {
//        System.out.println("Do you want to provide json path to import ?");
//        String userInput = this.scannerObject.nextLine();
//        if(userInput.equalsIgnoreCase("yes")){
//            return true;
//        }
//        else if(userInput.equalsIgnoreCase("no")){
//            System.out.println("You need to provide some information inorder to load team");
//            return false;
//        }
//        else {
//            System.out.println("enter YES or NO");
//            initializedCommunication();
//        }
//        return true;
//    }

    public LeagueModel parseJson(String filePath){

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
            System.exit(0);
        }
        return null;
    }

}
