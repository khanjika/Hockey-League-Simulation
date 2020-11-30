package leagueobjectmodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(as= ConferenceModel.class)
public interface IConferenceModel {
    abstract String getConferenceName();

    abstract void setConferenceName(String conferenceName);

    abstract List<IDivisonModel> getDivisions();

    abstract void setDivisions(List<IDivisonModel> divisions);
}
