package league;

import conference.ConferenceModel;
import freeagent.FreeAgentModel;

import java.util.List;

public class LeagueModel {

    private String leagueName;
    private List<ConferenceModel> conferences;
    private List<FreeAgentModel> freeAgents;


    public LeagueModel() {

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


}
