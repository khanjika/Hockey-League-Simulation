package cli;

import league.LeagueModel;

import java.util.Scanner;

public class InitialCli implements IInitCli {

    private final ICliCommunication cliCommunication;
    Scanner scannerObject;

    public InitialCli() {
        cliCommunication = new CliCommunication();
        scannerObject = new Scanner(System.in);
    }

    @Override
    public LeagueModel parseJson(String filePath) {

        if (cliCommunication.isFileExist(filePath)) {
            LeagueModel leagueModel = cliCommunication.parseJson(filePath);
            return leagueModel;
        } else {
            System.out.println("File does not exists in the specified location");
            System.exit(0);
        }
        return null;
    }
}
