package conference;

import divison.DivisonModel;

import java.util.List;

public class ConferenceModel {

    private String conferenceName;
    private List<DivisonModel> divisions;

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
