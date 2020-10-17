package league;

import cli.loadTeamCli;
import conference.ConferenceModel;
import conference.IConferenceModel;
import freeagent.FreeAgentModel;
import freeagent.FreeAgentPersistent;

import java.util.List;

public class LeagueModel implements ILeagueModel {

    private ILeaguePersistent iLeaguePersistent;
    private IConferenceModel conferenceModel;
    private FreeAgentModel freeAgentModel;
    loadTeamCli loadTeamCli;
    private String leagueName;
    private List<ConferenceModel> conferences;
    private List<FreeAgentModel> freeAgents;



    public LeagueModel() {
        iLeaguePersistent = new LeaguePersistent();
        conferenceModel = new ConferenceModel();
        freeAgentModel = new FreeAgentModel();
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
