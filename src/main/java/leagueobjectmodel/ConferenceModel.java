package leagueobjectmodel;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ConferenceModel implements IConferenceModel {

    private final IDivisonModel divisonModel;
    @Expose
    private String conferenceName;
    @Expose
    private List<IDivisonModel> divisions;

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
    public List<IDivisonModel> getDivisions() {
        return divisions;
    }

    @Override
    public void setDivisions(List<IDivisonModel> divisions) {
        this.divisions = divisions;
    }

}
