package cli;

import leagueobjectmodel.*;
import serializeobject.FileValidator;

import java.util.Scanner;

public class loadTeamCli {
    private static ILeagueModel iLeagueModel;
    private static ITeamsValidator iTeamsValidator;
    private static CliCommunication cliCommunication;
    private static FileValidator fileValidator;
    Scanner scannerObject;

    public loadTeamCli() {
        cliCommunication = new CliCommunication();
        fileValidator = new FileValidator();
        scannerObject = new Scanner(System.in);
        iTeamsValidator = LeagueObjectModelAbstractFactory.getInstance().getTeamsValidator();
    }

    public boolean getData() {

        String teamName = getUserInput("Team");
        if (isTeamExist(teamName)) {
            System.out.println("Team Exist");
            iLeagueModel = cliCommunication.parseJson(fileValidator.filePath(teamName));
            iLeagueModel.setCurrentTeam(teamName);
            System.out.println("Loading the data....");
            System.out.println("=====================================");
            return true;
        }
        System.out.println("Team does not exists!. Please provide a valid team name to continue...");
        return false;
    }

    public boolean isTeamExist(String teamName) {
        return iTeamsValidator.isTeamAlreadyExist(teamName);
    }

    public String getUserInput(String input) {
        System.out.println("Enter " + input + " Name");
        String enteredInupt = scannerObject.nextLine();
        return enteredInupt;
    }

}
