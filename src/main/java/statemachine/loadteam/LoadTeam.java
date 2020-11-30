package statemachine.loadteam;

import cli.CliAbstractFactory;
import cli.ICli;
import database.IDeserializeObject;
import database.IFileValidator;
import database.SerializeObjectAbstractFactory;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ILeagueValidator;
import leagueobjectmodel.ITeamsValidator;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import org.apache.log4j.Logger;

public class LoadTeam implements ILoadTeam{
    private static ILeagueModel iLeagueModel;
    private static ITeamsValidator iTeamsValidator;
    private static IDeserializeObject parser;
    private static IFileValidator fileValidator;
    private static ILeagueValidator leagueValidator;
    private ICli iCli;
    final static Logger logger = Logger.getLogger(LoadTeam.class);

    public LoadTeam() {
        parser = SerializeObjectAbstractFactory.instance().createParser();
        fileValidator = SerializeObjectAbstractFactory.instance().createFileValidator();
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
            if(iLeagueModel == null) {
                logger.error(LoadTeamConstants.ValidationError.getValue());
                return null;
            }
            iLeagueModel.setCurrentTeam(teamName);
            iCli.printOutput(LoadTeamConstants.LoadData.getValue());
            iCli.printOutput(LoadTeamConstants.LineSeperator.getValue());
            logger.info(LoadTeamConstants.LogInfoLoadTeam.getValue());
            return iLeagueModel;
            }
        else {
            iCli.printOutput(LoadTeamConstants.TeamNotExist.getValue());
        }
        return null;
    }

    private boolean isTeamExist(String teamName) {
        return iTeamsValidator.isTeamAlreadyExist(teamName);
    }
}
