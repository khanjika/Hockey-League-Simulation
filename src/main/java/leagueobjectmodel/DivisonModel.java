package leagueobjectmodel;

import com.google.gson.annotations.Expose;

import java.util.List;

public class DivisonModel implements IDivisonModel {
    private final ITeamsModel teamsModel;
    @Expose
    private String divisionName;
    @Expose
    private List<TeamsModel> teams;

    public DivisonModel() {
        teamsModel = new TeamsModel();
    }

    @Override
    public String getDivisionName() {
        return divisionName;
    }

    @Override
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }


    @Override
    public List<TeamsModel> getTeams() {
        return teams;
    }

    @Override
    public void setTeams(List<TeamsModel> teams) {
        this.teams = teams;
    }
}
