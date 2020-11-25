package statemachine.createteam;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueModel;

public interface ICreateTeamCli {
    ILeagueModel createNewTeam(ILeagueModel leagueModel);
}
