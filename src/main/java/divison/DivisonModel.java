package divison;

import teams.TeamsModel;

import java.util.List;

public class DivisonModel {
    private  String divisionName;
    private List<TeamsModel> teams;

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }


    public List<TeamsModel> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamsModel> teams) {
        this.teams = teams;
    }
}
