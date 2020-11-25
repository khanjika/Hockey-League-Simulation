package statemachine.loadteam;

import cli.CliAbstractFactory;
import cli.ICli;
import statemachine.jsonparser.Parser;
import leagueobjectmodel.*;
import database.serializeobject.FileValidator;

import java.util.Scanner;

public class LoadTeam implements ILoadTeam{
    private static ILeagueModel iLeagueModel;
    private static ITeamsValidator iTeamsValidator;
    private static Parser parser;
    private static FileValidator fileValidator;
    private ICli iCli;
    Scanner scannerObject;

    public LoadTeam() {
        parser = new Parser();
        fileValidator = new FileValidator();
        scannerObject = new Scanner(System.in);
        iTeamsValidator = LeagueObjectModelAbstractFactory.getInstance().getTeamsValidator();
        iCli = CliAbstractFactory.getInstance().getCli();
    }

    @Override
    public ILeagueModel getData() {

        iCli.printOutput(LoadTeamConstants.TeamName.getValue());
        String teamName = iCli.readStringInput();
        if (isTeamExist(teamName)) {
            iCli.printOutput(LoadTeamConstants.TeamExist.getValue());
            iLeagueModel = parser.parseJson(fileValidator.filePath(teamName));
            iLeagueModel.setCurrentTeam(teamName);
            iCli.printOutput(LoadTeamConstants.LoadData.getValue());
            iCli.printOutput(LoadTeamConstants.LineSeperator.getValue());
        }else {
            iCli.printOutput(LoadTeamConstants.TeamNotExist.getValue());
        }
        return iLeagueModel;
    }

    private boolean isTeamExist(String teamName) {
        return iTeamsValidator.isTeamAlreadyExist(teamName);
    }
}
