package leagueobjectmodel;

import com.google.gson.annotations.Expose;
import database.serializeobject.ISerializeObject;
import database.serializeobject.SerializeObjectAbstractFactory;

import java.util.ArrayList;
import java.util.List;

public class LeagueModel implements ILeagueModel {

    private final IConferenceModel conferenceModel;
    private final IFreeAgentModel freeAgentModel;
    private final ICoachModel coachModel;
    private IGamePlayConfigModel iGamePlayConfigModel;
    private ISerializeObject serializeObject;

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

    private String currentTeam;


    public LeagueModel() {
        conferenceModel = LeagueObjectModelAbstractFactory.getInstance().getConference();
        freeAgentModel = LeagueObjectModelAbstractFactory.getInstance().getFreeAgentModel();
        coachModel = LeagueObjectModelAbstractFactory.getInstance().getCoach();
        serializeObject = SerializeObjectAbstractFactory.instance().createSerializeObject();
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
    public String getCurrentTeam() {
        return currentTeam;
    }

    @Override
    public void setCurrentTeam(String currentTeam) {
        this.currentTeam = currentTeam;
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

    @Override
    public List<FreeAgentModel> getForwards(){
        List<FreeAgentModel>forwards = new ArrayList<>();
        for (FreeAgentModel freeAgent : this.getFreeAgents()){
            if (freeAgent.getPosition().equals(PlayerPosition.FORWARD.toString())){
                forwards.add(freeAgent);
            }
        }
        return forwards;
    }

    @Override
    public List<FreeAgentModel> getDefenses(){
        List<FreeAgentModel> defense = new ArrayList<>();
        for ( FreeAgentModel freeAgent : this.getFreeAgents()){
            if (freeAgent.getPosition().equals(PlayerPosition.DEFENSE.toString())){
                defense.add(freeAgent);
            }
        }
        return defense;
    }

    @Override
    public List<FreeAgentModel> getGoalies(){
        List<FreeAgentModel> goalies = new ArrayList<>();
        for ( FreeAgentModel freeAgent : this.getFreeAgents()){
            if (freeAgent.getPosition().equals(PlayerPosition.GOALIE.toString())){
                goalies.add(freeAgent);
            }
        }
        return goalies;
    }

    @Override
    public boolean storeLeagueInformation(ILeagueModel leagueModel){
        return serializeObject.serializeLeagueObject(leagueModel,leagueModel.getCurrentTeam());
    }
}
