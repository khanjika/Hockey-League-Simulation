package statemachine.jsonparser;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueModel;

public interface IParser {

    ILeagueModel loadTeamFromDatabase();

    ILeagueModel parseJson(String fileName);
}
