package leagueobjectmodel;

import com.google.gson.annotations.Expose;
import database.ISerializeObject;
import database.SerializeObjectAbstractFactory;

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
    private List<IConferenceModel> conferences;
    @Expose
    private List<IFreeAgentModel> freeAgents;
    @Expose
    private List<ICoachModel> coaches;
    @Expose
    private List<IGeneralManagersModel> generalManagers;
    @Expose
    private IGamePlayConfigModel gameplayConfig;
    private float penaltyChance;

    private String currentTeam;


    public LeagueModel() {
        conferenceModel = LeagueObjectModelAbstractFactory.getInstance().getConference();
        freeAgentModel = LeagueObjectModelAbstractFactory.getInstance().getFreeAgentModel();
        coachModel = LeagueObjectModelAbstractFactory.getInstance().getCoach();
        gameplayConfig=LeagueObjectModelAbstractFactory.getInstance().getGamePlayConfig();
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
    public List<IConferenceModel> getConferences() {
        return conferences;
    }

    @Override
    public void setConferences(List<IConferenceModel> conferences) {
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
    public List<IFreeAgentModel> getFreeAgents() {
        return freeAgents;
    }

    @Override
    public void setFreeAgents(List<IFreeAgentModel> freeAgents) {
        this.freeAgents = freeAgents;
    }

    @Override
    public List<ICoachModel> getCoaches() {
        return coaches;
    }

    @Override
    public void setCoaches(List<ICoachModel> coaches) {
        this.coaches = coaches;
    }

    @Override
    public List<IGeneralManagersModel> getGeneralManagers() {
        return generalManagers;
    }

    @Override
    public void setGeneralManagers(List<IGeneralManagersModel> generalManagers) {
        this.generalManagers = generalManagers;
    }

    @Override
    public IGamePlayConfigModel getGameplayConfig() {
        return gameplayConfig;
    }

    @Override
    public void setGameplayConfig(GamePlayConfigModel gameplayConfig) {
        this.gameplayConfig = gameplayConfig;
    }

    @Override
    public List<IFreeAgentModel> getForwards(){
        List<IFreeAgentModel>forwards = new ArrayList<>();
        for (IFreeAgentModel freeAgent : this.getFreeAgents()){
            if (freeAgent.getPosition().equals(PlayerPosition.FORWARD.toString())){
                forwards.add(freeAgent);
            }
        }
        return forwards;
    }

    @Override
    public List<IFreeAgentModel> getDefenses(){
        List<IFreeAgentModel> defense = new ArrayList<>();
        for ( IFreeAgentModel freeAgent : this.getFreeAgents()){
            if (freeAgent.getPosition().equals(PlayerPosition.DEFENSE.toString())){
                defense.add(freeAgent);
            }
        }
        return defense;
    }

    @Override
    public List<IFreeAgentModel> getGoalies(){
        List<IFreeAgentModel> goalies = new ArrayList<>();
        for ( IFreeAgentModel freeAgent : this.getFreeAgents()){
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
