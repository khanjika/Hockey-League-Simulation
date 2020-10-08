package divison;

import teams.TeamsModel;

import java.util.List;

public class DivisonModel implements IDivisonModel{
    private String divisionName;
    private TeamsModel teamsModel;
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

    public boolean storeDivisionInformation(DivisonModel divisonModel, int conferenceId) {

        if (isDivisionAlreadyExist(divisonModel.getDivisionName(), conferenceId)) {
            System.out.println("Division ALready Exist in the DB");
            return false;
        } else {
            int divisionId = iDivisonPersistent.addDivisionInformation(divisonModel.getDivisionName(), conferenceId);
            for (TeamsModel teamsModel : divisonModel.getTeams()) {
                this.teamsModel.storeTeamInformation(teamsModel, divisionId);
            }

        }

        return false;
    }

    public boolean isDivisionAlreadyExist(String divisionName, int conferenceId) {
            return false;
    }

    @Override
    public int getDivisionId(String divisionName, int conferenceId) {
        return 0;
    }


}
