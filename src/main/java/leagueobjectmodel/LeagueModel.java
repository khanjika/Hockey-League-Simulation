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
    private float penaltyChance;


    public LeagueModel() {
        conferenceModel = new ConferenceModel();
        freeAgentModel = new FreeAgentModel();
        coachModel = new CoachModel();
    }

    public float getPenaltyChance() {
        return penaltyChance;
    }

    public void setPenaltyChance(float penaltyChance) {
        this.penaltyChance = penaltyChance;
    }

    @Override
    public String getLeagueName() {
        return leagueName;
    }

    @Override
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    @Override
    public List<ConferenceModel> getConferences() {
        return conferences;
    }

    @Override
    public void setConferences(List<ConferenceModel> conferences) {
        this.conferences = conferences;
    }

    @Override
    public List<FreeAgentModel> getFreeAgents() {
        return freeAgents;
    }

    @Override
    public void setFreeAgents(List<FreeAgentModel> freeAgents) {
        this.freeAgents = freeAgents;
    }

    @Override
    public List<CoachModel> getCoaches() {
        return coaches;
    }

    @Override
    public void setCoaches(List<CoachModel> coaches) {
        this.coaches = coaches;
    }

    @Override
    public List<GeneralManagersModel> getGeneralManagers() {
        return generalManagers;
    }

    @Override
    public void setGeneralManagers(List<GeneralManagersModel> generalManagers) {
        this.generalManagers = generalManagers;
    }

    @Override
    public GamePlayConfigModel getGameplayConfig() {
        return gameplayConfig;
    }

    @Override
    public void setGameplayConfig(GamePlayConfigModel gameplayConfig) {
        this.gameplayConfig = gameplayConfig;
    }

}
