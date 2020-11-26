package leagueobjectmodel;

import java.util.List;

public interface IConferenceModel {
    abstract String getConferenceName();

    abstract void setConferenceName(String conferenceName);

    abstract List<DivisonModel> getDivisions();

    abstract void setDivisions(List<DivisonModel> divisions);
}
