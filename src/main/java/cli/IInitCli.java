package cli;

import leagueobjectmodel.ILeagueModel;

public interface IInitCli {
    ILeagueModel parseJson(String filePath);
}
