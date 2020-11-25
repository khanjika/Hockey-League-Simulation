package statemachine.jsonparser;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;

import java.util.Scanner;

public class InitialCli implements IInitCli {

    private final ICliCommunication cliCommunication;
    Scanner scannerObject;
    private ILeagueModel leagueModel;

    public InitialCli() {
        cliCommunication = new CliCommunication();
        scannerObject = new Scanner(System.in);
        leagueModel = LeagueObjectModelAbstractFactory.getInstance().getLeague();
    }

    @Override
    public ILeagueModel parseJson(String filePath) {

        if (cliCommunication.isFileExist(filePath)) {
            leagueModel = cliCommunication.parseJson(filePath);
            System.out.println(leagueModel.getLeagueName());
            return leagueModel;
        } else {
            System.out.println("File does not exists in the specified location");
            System.exit(0);
        }
        return null;
    }
}
