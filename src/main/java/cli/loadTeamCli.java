package cli;

import conference.ConferenceModel;
import conference.ConferencePersistent;
import conference.IConferenceModel;
import conference.IConferencePersistent;
import divison.DivisonModel;
import divison.IDivisonModel;
import league.ILeagueModel;
import league.ILeaguePersistent;
import league.LeagueModel;
import league.LeaguePersistent;
import teams.ITeamsModel;
import teams.ITeamsPersistent;
import teams.TeamsModel;
import teams.TeamsPersistent;

import java.util.Scanner;

public class loadTeamCli {
    private static ITeamsPersistent iTeamsPersistent;
    private static ILeagueModel iLeagueModel;
    private static IConferenceModel iConferenceModel;
    private static IDivisonModel iDivisonModel;
    private static ITeamsModel iTeamsModel;
    Scanner scannerObject;

    public loadTeamCli() {
        scannerObject = new Scanner(System.in);
        iTeamsPersistent = new TeamsPersistent();
        iLeagueModel = new LeagueModel();
        iConferenceModel = new ConferenceModel();
        iDivisonModel = new DivisonModel();
        iTeamsModel = new TeamsModel();
    }

    public void getData() {
        String leagueName = getUserInput("League");
        if (isLeagueExist(leagueName)) {
            int leagueId = iLeagueModel.getLeagueId(leagueName);
            String conferenceName = getUserInput("Conference");
            if (isConferenceExist(conferenceName, leagueId)) ;
            {
                int conferenceId= iConferenceModel.getConferenceId(conferenceName,leagueId);
                String divisionName = getUserInput("Division");
                if (isDivisionExist(divisionName, conferenceId)) {
                    int divisionId = iDivisonModel.getDivisionId(divisionName,conferenceId);
                    String teamName = getUserInput("Team");
                    if (isTeamExist(teamName, divisionId)) {
                        int teamId=iTeamsModel.getTeamId(teamName,divisionId);
                        System.out.println("Team Exist in the DB");
                        System.out.println("Loading the data....");
                        //here at the end load the team
                    }

                }
            }
        }

    }

    public boolean isTeamExist(String teamName, int divisionId) {
        if (iTeamsModel.isTeamAlreadyExist(teamName, divisionId)) {
            System.out.println("Team Exist in the database");
            return true;
        }
        return false;
    }

    public String getUserInput(String input) {
        System.out.println("Enter " + input + " Name");
        String enteredInupt = scannerObject.nextLine();
        return enteredInupt;
    }

    public boolean isLeagueExist(String leagueName) {
        if (iLeagueModel.isLeagueExist(leagueName)) {
            return true;
        } else {
            System.out.println("League does not exist in the DB");
            return false;
        }
    }

    public boolean isConferenceExist(String confereceName, int leagueId) {
        if (iConferenceModel.isConferenceAlreadyExist(confereceName, leagueId)) {
            return true;
        } else {
            System.out.println("Conference does not exist in the DB");
            return false;
        }
    }


    public boolean isDivisionExist(String divisionName, int conferenceId) {
        if (iDivisonModel.isDivisionAlreadyExist(divisionName, conferenceId)) {
            return true;
        } else {
            System.out.println("Division does not exist in the DB");
            return false;
        }
    }


    public void createNewModel(int leagueId) {

    }


}
