package statemachine.loadteam;

import cli.CliAbstractFactory;
import cli.ICli;
import database.serializeobject.IDeserializeObject;
import database.serializeobject.IFileValidator;
import database.serializeobject.SerializeObjectAbstractFactory;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsValidator;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import org.apache.log4j.Logger;

public class LoadTeam implements ILoadTeam{
    private static ILeagueModel iLeagueModel;
    private static ITeamsValidator iTeamsValidator;
    private static IDeserializeObject parser;
    private static IFileValidator fileValidator;
    private ICli iCli;
    final static Logger logger = Logger.getLogger(LoadTeam.class);

    public LoadTeam() {
        parser = SerializeObjectAbstractFactory.instance().createParser();
        fileValidator = SerializeObjectAbstractFactory.instance().createFileValidator();
        iTeamsValidator = LeagueObjectModelAbstractFactory.getInstance().getTeamsValidator();
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
            logger.info(LoadTeamConstants.LogInfoTraining.getValue());
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
