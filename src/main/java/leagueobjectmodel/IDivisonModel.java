package leagueobjectmodel;

import java.util.List;

public interface IDivisonModel {
    String getDivisionName();

    void setDivisionName(String divisionName);

    List<TeamsModel> getTeams();

    void setTeams(List<TeamsModel> teams);
}
