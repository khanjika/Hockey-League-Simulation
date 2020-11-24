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

    @Override
    public String getConferenceName() {
        return conferenceName;
    }

    @Override
    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    @Override
    public List<DivisonModel> getDivisions() {
        return divisions;
    }

    @Override
    public void setDivisions(List<DivisonModel> divisions) {
        this.divisions = divisions;
    }

}
