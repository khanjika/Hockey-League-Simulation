package league;

import conference.ConferenceModel;
import freeagent.FreeAgentModel;

import java.util.List;

public class LeagueModel {

    private ILeaguePersistent iLeaguePersistent;
    private ConferenceModel conferenceModel;
    private String leagueName;
    private List<ConferenceModel> conferences;
    private List<FreeAgentModel> freeAgents;


    public LeagueModel() {
        iLeaguePersistent = new LeaguePersistent();
        conferenceModel = new ConferenceModel();
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


    //IN future if there are multiple league then argumnet will accept league arraylist
    public boolean storeLeagueInformation(LeagueModel leagueModel) {
        int leagueId = iLeaguePersistent.addLeagueInformation(leagueModel.getLeagueName());
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            this.conferenceModel.storeConferenceInformation(conferenceModel, leagueId);
        }
        return false;
    }
}
