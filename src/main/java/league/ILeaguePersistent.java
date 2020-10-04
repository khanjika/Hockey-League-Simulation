package league;

public interface ILeaguePersistent {

    int addLeagueInformation(String leagueName);

    boolean isLeagueAlreadyExist(String leagueName);
}
