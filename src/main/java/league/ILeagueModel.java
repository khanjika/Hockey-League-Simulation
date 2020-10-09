package league;

public interface ILeagueModel {


    int getLeagueId(String leageuName);
    boolean isLeagueExist(String leagueName);
    void storeLeagueInformation(LeagueModel leagueModel);
}
