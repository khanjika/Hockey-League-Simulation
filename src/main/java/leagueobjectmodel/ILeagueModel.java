package leagueobjectmodel;

import java.util.List;

public interface ILeagueModel {
    String getLeagueName();

    void setLeagueName(String leagueName);

    List<ConferenceModel> getConferences();

    void setConferences(List<ConferenceModel> conferences);

    List<FreeAgentModel> getFreeAgents();

    void setFreeAgents(List<FreeAgentModel> freeAgents);

    List<CoachModel> getCoaches();

    void setCoaches(List<CoachModel> coaches);

    List<GeneralManagersModel> getGeneralManagers();

    void setGeneralManagers(List<GeneralManagersModel> generalManagers);

    GamePlayConfigModel getGameplayConfig();

    void setGameplayConfig(GamePlayConfigModel gameplayConfig);
}
