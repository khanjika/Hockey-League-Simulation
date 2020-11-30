package statemachine.loadteam;

import cli.CliAbstractFactory;
import cli.ICli;
import database.serializeobject.IFileValidator;
import database.serializeobject.SerializeObjectAbstractFactory;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ILeagueValidator;
import leagueobjectmodel.ITeamsValidator;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import statemachine.jsonparser.IParser;
import statemachine.jsonparser.ParserAbstractFactory;

public class LoadTeam implements ILoadTeam{
    private static ILeagueModel iLeagueModel;
    private static ITeamsValidator iTeamsValidator;
    private static ILeagueValidator leagueValidator;
    private static IParser parser;
    private static IFileValidator fileValidator;
    private ICli iCli;

    public LoadTeam() {
        parser = ParserAbstractFactory.getInstance().getParser();
        fileValidator = SerializeObjectAbstractFactory.getInstance().getFileValidator();
        iTeamsValidator = LeagueObjectModelAbstractFactory.getInstance().getTeamsValidator();
        leagueValidator = LeagueObjectModelAbstractFactory.getInstance().getLeagueValidator();
        iCli = CliAbstractFactory.getInstance().getCli();
    }

    @Override
    public ILeagueModel getData() {

        iCli.printOutput(LoadTeamConstants.TeamName.getValue());
        String teamName = iCli.readStringInput();
        if(teamName.isEmpty() || teamName.equals("")){
            getData();
        }
        if (isTeamExist(teamName)) {
            iCli.printOutput(LoadTeamConstants.TeamExist.getValue());
            iLeagueModel = parser.parseJson(fileValidator.filePath(teamName));
            try {
                if (leagueValidator.validateLeagueObject(iLeagueModel)) {
                    iLeagueModel.setCurrentTeam(teamName);
                    iCli.printOutput(LoadTeamConstants.LoadData.getValue());
                    iCli.printOutput(LoadTeamConstants.LineSeperator.getValue());
                } else {
                    iLeagueModel = null;
                }
            }catch (Exception exception){
                iCli.printOutput(LoadTeamConstants.NullException.getValue());
            }
        }else {
            iCli.printOutput(LoadTeamConstants.TeamNotExist.getValue());
        }
        return iLeagueModel;
    }

    private boolean isTeamExist(String teamName) {
        return iTeamsValidator.isTeamAlreadyExist(teamName);
    }
}
