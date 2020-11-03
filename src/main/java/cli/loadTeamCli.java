package cli;

import conference.ConferenceModel;
import conference.IConferenceModel;
import divison.DivisonModel;
import divison.IDivisonModel;
import league.ILeagueModel;
import league.LeagueModel;
import players.IPlayerModel;
import players.PlayerModel;
import teams.*;

import java.util.List;
import java.util.Scanner;

public class loadTeamCli {
    private static ITeamsPersistent iTeamsPersistent;
    private static ILeagueModel iLeagueModel;
    private static IConferenceModel iConferenceModel;
    private static IDivisonModel iDivisonModel;
    private static ITeamsModel iTeamsModel;
    private static IPlayerModel iPlayerModel;
    Scanner scannerObject;

    public loadTeamCli() {
        scannerObject = new Scanner(System.in);
        iTeamsPersistent = new TeamsPersistent();
        iLeagueModel = new LeagueModel();
        iConferenceModel = new ConferenceModel();
        iDivisonModel = new DivisonModel();
        iTeamsModel = new TeamsModel();
        iPlayerModel = new PlayerModel();
    }

    public boolean getData() {
        String leagueName = getUserInput("League");
        if (isLeagueExist(leagueName)) {
            int leagueId = iLeagueModel.getLeagueId(leagueName);
            System.out.println("League Exist");
            String conferenceName = getUserInput("Conference");
            if (isConferenceExist(conferenceName, leagueId)) {
                System.out.println("Conference Exist");
                int conferenceId = iConferenceModel.getConferenceId(conferenceName, leagueId);
                String divisionName = getUserInput("Division");
                if (isDivisionExist(divisionName, conferenceId)) {
                    System.out.println("Division Exist");
                    int divisionId = iDivisonModel.getDivisionId(divisionName, conferenceId);
                    String teamName = getUserInput("Team");
                    if (isTeamExist(teamName, divisionId)) {
                        System.out.println("Team Exist");
                        int teamId = iTeamsModel.getTeamId(teamName, divisionId);
                        TeamPojo teamPojo = iTeamsModel.getTeamInformation(teamName, divisionId);
                        List<PlayerModel> listOfPLayers = iPlayerModel.getPlayerInformation(teamId);
                        System.out.println("Loading the data....");
                        System.out.println("=====================================");
                        System.out.println("General Manager = " + teamPojo.getGeneralManagerName());
                        System.out.println("Head Coach = " + teamPojo.getHeadCoach());
                        System.out.println();
                        for (PlayerModel playerModel : listOfPLayers) {
                            System.out.println("Player Name = " + playerModel.getPlayerName());
                            System.out.println("Player Position = " + playerModel.getPosition());
                            if (playerModel.isCaptain()) {
                                System.out.println("** " + playerModel.getPlayerName() + " is the captain of the Team **");
                            }
                            System.out.println();
                        }
                        return true;
                    }
                    return false;

                }
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean isTeamExist(String teamName, int divisionId) {
        return iTeamsModel.isTeamAlreadyExist(teamName, divisionId);
    }

    public String getUserInput(String input) {
        System.out.println("Enter " + input + " Name");
        String enteredInupt = scannerObject.nextLine();
        return enteredInupt;
    }

    public boolean isLeagueExist(String leagueName) {
        return iLeagueModel.isLeagueExist(leagueName);
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
}
