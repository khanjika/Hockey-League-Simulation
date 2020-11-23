package cli;

import leagueobjectmodel.LeagueModel;

public interface IInitCli {
    LeagueModel parseJson(String filePath);
}
