package conference;

import com.google.gson.annotations.Expose;
import divison.DivisonModel;
import divison.IDivisonModel;

import java.util.List;

public class ConferenceModel implements IConferenceModel {

    private final IConferencePersistent iConferencePersistent;
    private final IDivisonModel divisonModel;
    @Expose
    private String conferenceName;
    @Expose
    private List<DivisonModel> divisions;

    public ConferenceModel() {
        iConferencePersistent = new ConferencePersistent();
        divisonModel = new DivisonModel();
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public List<DivisonModel> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<DivisonModel> divisions) {
        this.divisions = divisions;
    }

    @Override
    public void storeConferenceInformation(ConferenceModel conferenceModel, int leagueId) {
        if (isConferenceAlreadyExist(conferenceModel.getConferenceName(), leagueId)) {
            System.out.println("Conference already Exist in the DB");
        } else {
            int conferenceId = iConferencePersistent.addConferenceInformation(conferenceModel.getConferenceName(), leagueId);
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                this.divisonModel.storeDivisionInformation(divisonModel, conferenceId);
            }
        }
    }

    @Override
    public boolean isConferenceAlreadyExist(String conferenceName, int leagueId) {
        return iConferencePersistent.isConferenceAlreadyExist(conferenceName, leagueId);
    }

    @Override
    public int getConferenceId(String conferenceName, int leagueId) {
        return iConferencePersistent.getConferenceInformation(conferenceName, leagueId);
    }

}
