package league;

import generalmanagers.GeneralManagersModel;

public interface ILeaguePersistent {

    int addLeagueInformation(String leagueName, int gamePlayConfigId, int timePassedId);

    boolean isLeagueAlreadyExist(String leagueName);

    void storeAvailableGeneralManagerInformation(int leagueId, GeneralManagersModel generalManagerName);

    String getLeagueInformation(int leagueId);

    int getLeagueId(String leagueName);

}
