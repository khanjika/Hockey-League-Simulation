package cli;

import teams.ITeamsPersistent;
import teams.TeamsPersistent;

import java.util.Scanner;

public class loadTeamCli {
    private static ITeamsPersistent iTeamsPersistent;
    Scanner scannerObject;


    public loadTeamCli() {
        scannerObject = new Scanner(System.in);
        iTeamsPersistent=new TeamsPersistent();
    }


    public void getUserInput() {
        System.out.println("Enter Team Name");
        String teamName = scannerObject.nextLine();
    }

    public boolean isTeamExist(String teamName){
        if(iTeamsPersistent.isTeamNameExist(teamName)){
            System.out.println("Team Exist in the database");
            return true;
        }
        return false;
    }

}
