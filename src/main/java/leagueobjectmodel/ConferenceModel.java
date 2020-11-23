package leagueobjectmodel;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ConferenceModel implements IConferenceModel {

    private final IDivisonModel divisonModel;
    @Expose
    private String conferenceName;
    @Expose
    private List<DivisonModel> divisions;

    public ConferenceModel() {
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

}
