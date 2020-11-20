package league;

import cli.loadTeamCli;
import coach.CoachModel;
import coach.ICoachModel;
import com.google.gson.annotations.Expose;
import conference.ConferenceModel;
import conference.IConferenceModel;
import freeagent.FreeAgentModel;
import freeagent.IFreeAgentModel;
import gameplayconfig.GamePlayConfigModel;
import gameplayconfig.IGamePlayConfigModel;
import generalmanagers.GeneralManagersModel;

import java.util.List;

public class LeagueModel implements ILeagueModel {

    private final ILeaguePersistent iLeaguePersistent;
    private final IConferenceModel conferenceModel;
    private final IFreeAgentModel freeAgentModel;
    loadTeamCli loadTeamCli;
    @Expose
    private String leagueName;
    @Expose
    private List<ConferenceModel> conferences;
    @Expose
    private List<FreeAgentModel> freeAgents;
    @Expose
    private List<CoachModel> coaches;
    private final ICoachModel coachModel;
    @Expose
    private List<GeneralManagersModel> generalManagers;
    @Expose
    private GamePlayConfigModel gameplayConfig;

    IGamePlayConfigModel iGamePlayConfigModel;


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

    public boolean storeLeagueInformation(LeagueModel leagueModel, int year) {
        loadTeamCli = new loadTeamCli();
        if (loadTeamCli.isLeagueExist(leagueModel.getLeagueName())) {
            System.out.println("League already Exit in the DB");
            return false;
        } else {
            //CHANGE HERE
            iGamePlayConfigModel = new GamePlayConfigModel();
            int gamePlayConfigId = iGamePlayConfigModel.addGamePlayConfigInformation(leagueModel.getGameplayConfig());
            int leagueId = iLeaguePersistent.addLeagueInformation(leagueModel.getLeagueName(), gamePlayConfigId, year);
            for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
                this.conferenceModel.storeConferenceInformation(conferenceModel, leagueId);
            }
            for (FreeAgentModel freeAgentModel : leagueModel.getFreeAgents()) {
                this.freeAgentModel.storeFreeAgentInformation(freeAgentModel, leagueId);
            }
            storeGeneralManagerInformation(leagueId, leagueModel.getGeneralManagers());
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

    public void storeGeneralManagerInformation(int leagueId, List<GeneralManagersModel> generalManagers) {
        for (GeneralManagersModel generalManager : generalManagers) {
            iLeaguePersistent.storeAvailableGeneralManagerInformation(leagueId, generalManager);
        }
    }
}
