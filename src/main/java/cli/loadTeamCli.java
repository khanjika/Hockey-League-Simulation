package cli;

import league.ILeaguePersistent;
import league.LeaguePersistent;
import teams.ITeamsPersistent;
import teams.TeamsPersistent;

import java.util.Scanner;

public class loadTeamCli {
    private static ITeamsPersistent iTeamsPersistent;
    private static ILeaguePersistent iLeaguePersistent;
    Scanner scannerObject;



    public loadTeamCli() {
        scannerObject = new Scanner(System.in);
        iTeamsPersistent=new TeamsPersistent();
        iLeaguePersistent=new LeaguePersistent();
    }


    public void getUserInput() {
        System.out.println("Enter Team Name");
        String teamName = scannerObject.nextLine();
    }

    public boolean isTeamExist(String teamName){
        if(iTeamsPersistent.isTeamNameExist(teamName)){
            //create method for fetching player info
            //store that in model
            //start simulation
            System.out.println("Team Exist in the database");
            return true;
        }
        return false;
    }


    public void leagueId(String teamName){
             int returnedLeagueId=iLeaguePersistent.getLeagueId(teamName);
    }

    public void createNewModel(int leagueId){

    }


}
