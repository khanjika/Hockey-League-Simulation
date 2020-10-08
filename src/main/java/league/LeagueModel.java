package league;

import conference.ConferenceModel;
import freeagent.FreeAgentModel;
import freeagent.FreeAgentPersistent;

import java.util.List;

public class LeagueModel implements ILeagueModel {

    private ILeaguePersistent iLeaguePersistent;
    private ConferenceModel conferenceModel;
    private FreeAgentModel freeAgentModel;
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


    //IN future if there are multiple league then argumnet will accept league arraylist
    public boolean storeLeagueInformation(LeagueModel leagueModel) {
        int leagueId = iLeaguePersistent.addLeagueInformation(leagueModel.getLeagueName());
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            this.conferenceModel.storeConferenceInformation(conferenceModel, leagueId);
        }
        for (FreeAgentModel freeAgentModel : leagueModel.getFreeAgents()) {
            this.freeAgentModel.storeFreeAgentInformation(freeAgentModel, leagueId);
        }
        return false;
    }



    @Override
    public void createNewLeagueModelFromDatabase(int leagueId) {


        //Return i will have all the league name set.
        //call the conference method
        //conference model will return and pass the league ID
        //which will set all the onference
    }

    @Override
    public int getLeagueId(String leageuName) {
        return 0;
    }

    @Override
    public boolean isLeagueExist(String leagueName) {
        return false;
    }
}
