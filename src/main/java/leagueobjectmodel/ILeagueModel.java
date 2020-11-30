package leagueobjectmodel;

import java.util.List;

public interface ILeagueModel {
    String getLeagueName();

    void setLeagueName(String leagueName);

    List<IConferenceModel> getConferences();

    void setConferences(List<IConferenceModel> conferences);

    List<IFreeAgentModel> getFreeAgents();

    void setFreeAgents(List<IFreeAgentModel> freeAgents);

    void setCurrentTeam(String name);

    String getCurrentTeam();

    List<ICoachModel> getCoaches();

    void setCoaches(List<ICoachModel> coaches);

    List<IGeneralManagersModel> getGeneralManagers();

    void setGeneralManagers(List<IGeneralManagersModel> generalManagers);

    IGamePlayConfigModel getGameplayConfig();

    void setGameplayConfig(GamePlayConfigModel gameplayConfig);

    List<IFreeAgentModel> getForwards();

    List<IFreeAgentModel> getDefenses();

    List<IFreeAgentModel> getGoalies();

    boolean storeLeagueInformation(ILeagueModel leagueModel);
}
