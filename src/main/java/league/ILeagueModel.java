package league;

public interface ILeagueModel {

    int getLeagueId(String leageuName);
    boolean isLeagueExist(String leagueName);
    boolean storeLeagueInformation(LeagueModel leagueModel,int currentYear);
}
