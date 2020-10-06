package league;

public interface ILeaguePersistent {

    int addLeagueInformation(String leagueName);

    boolean isLeagueAlreadyExist(String leagueName);

    int getLeagueId(String teamName);

    LeagueModel getLeagueInformation(int leagueId);
}
