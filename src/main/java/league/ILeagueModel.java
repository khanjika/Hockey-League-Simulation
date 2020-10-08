package league;

public interface ILeagueModel {

    void createNewLeagueModelFromDatabase(int leagueId);
    int getLeagueId(String leageuName);
    boolean isLeagueExist(String leagueName);
}
