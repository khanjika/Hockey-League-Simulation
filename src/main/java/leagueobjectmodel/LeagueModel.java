package leagueobjectmodel;

import com.google.gson.annotations.Expose;

import java.util.List;

public class LeagueModel implements ILeagueModel {

    private final IConferenceModel conferenceModel;
    private final IFreeAgentModel freeAgentModel;
    private final ICoachModel coachModel;
    IGamePlayConfigModel iGamePlayConfigModel;
    @Expose
    private String leagueName;
    @Expose
    private List<ConferenceModel> conferences;
    @Expose
    private List<FreeAgentModel> freeAgents;
    @Expose
    private List<CoachModel> coaches;
    @Expose
    private List<GeneralManagersModel> generalManagers;
    @Expose
    private GamePlayConfigModel gameplayConfig;


    public LeagueModel() {
        conferenceModel = new ConferenceModel();
        freeAgentModel = new FreeAgentModel();
        coachModel = new CoachModel();
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public List<ConferenceModel> getConferences() {
        return conferences;
    }

    public void setConferences(List<ConferenceModel> conferences) {
        this.conferences = conferences;
    }

    public List<FreeAgentModel> getFreeAgents() {
        return freeAgents;
    }

    public void setFreeAgents(List<FreeAgentModel> freeAgents) {
        this.freeAgents = freeAgents;
    }

    public List<CoachModel> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<CoachModel> coaches) {
        this.coaches = coaches;
    }

    public List<GeneralManagersModel> getGeneralManagers() {
        return generalManagers;
    }

    public void setGeneralManagers(List<GeneralManagersModel> generalManagers) {
        this.generalManagers = generalManagers;
    }

    public GamePlayConfigModel getGameplayConfig() {
        return gameplayConfig;
    }

    public void setGameplayConfig(GamePlayConfigModel gameplayConfig) {
        this.gameplayConfig = gameplayConfig;
    }

}
