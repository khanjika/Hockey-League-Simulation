package leagueobjectmodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
@JsonDeserialize(as = DivisonModel.class)
public interface IDivisonModel {
    String getDivisionName();

    void setDivisionName(String divisionName);

    List<ITeamsModel> getTeams();

    void setTeams(List<ITeamsModel> teams);
}
