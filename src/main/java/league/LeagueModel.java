package league;

import cli.loadTeamCli;
import coach.CoachModel;
import coach.ICoachModel;
import com.google.gson.annotations.Expose;
import conference.ConferenceModel;
import conference.IConferenceModel;
import freeagent.FreeAgentModel;
import freeagent.FreeAgentPersistent;
import freeagent.IFreeAgentModel;
import gameplayconfig.GamePlayConfigModel;

import java.util.List;

public class LeagueModel implements ILeagueModel {

    private ILeaguePersistent iLeaguePersistent;
    private IConferenceModel conferenceModel;
    private IFreeAgentModel freeAgentModel;
    loadTeamCli loadTeamCli;
    @Expose
    private String leagueName;
    @Expose
    private List<ConferenceModel> conferences;
    @Expose
    private List<FreeAgentModel> freeAgents;
    @Expose
    private List<CoachModel> coaches;
    private ICoachModel coachModel;
    @Expose
    private List<String> generalManagers;
    @Expose
    private GamePlayConfigModel gameplayConfig;


    public LeagueModel() {
        iLeaguePersistent = new LeaguePersistent();
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

    public List<CoachModel> getCoaches() { return coaches; }

    public void setCoaches(List<CoachModel> coaches) { this.coaches = coaches; }

    public List<String> getGeneralManagers() {
        return generalManagers;
    }

    public void setGeneralManagers(List<String> generalManagers) {
        this.generalManagers = generalManagers;
    }

    public GamePlayConfigModel getGameplayConfig() {
        return gameplayConfig;
    }

    public void setGameplayConfig(GamePlayConfigModel gameplayConfig) {
        this.gameplayConfig = gameplayConfig;
    }

    public boolean storeLeagueInformation(LeagueModel leagueModel) {
        loadTeamCli = new loadTeamCli();
        if(loadTeamCli.isLeagueExist(leagueModel.getLeagueName())){
            System.out.println("League already Exit in the DB");
            return false;
        }
        else{
            int leagueId = iLeaguePersistent.addLeagueInformation(leagueModel.getLeagueName());
            for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
               this.conferenceModel.storeConferenceInformation(conferenceModel, leagueId);
            }
            for (FreeAgentModel freeAgentModel : leagueModel.getFreeAgents()) {
               this.freeAgentModel.storeFreeAgentInformation(freeAgentModel, leagueId);

            }
        }
        return true;
    }

    @Override
    public int getLeagueId(String name) {
        return iLeaguePersistent.getLeagueId(name);
    }

    @Override
    public boolean isLeagueExist(String leagueName) {
        return iLeaguePersistent.isLeagueAlreadyExist(leagueName);
    }
}
