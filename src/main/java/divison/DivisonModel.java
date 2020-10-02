package divison;

import teams.TeamsModel;

import java.util.List;

public class DivisonModel {
    private  String divisionName;
    private List<TeamsModel> teams;
    private IDivisonPersistent iDivisonPersistent;
    public DivisonModel() {
        iDivisonPersistent = new DivisonPersistent();
    }

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

    public boolean storeDivisionInformation(DivisonModel divisonModel,int conferenceId){
        int divisionId=iDivisonPersistent.addDivisionInformation(divisonModel.getDivisionName(),conferenceId);
        for(TeamsModel teamsModel:divisonModel.getTeams()){

        }
        return false;
    }
}
