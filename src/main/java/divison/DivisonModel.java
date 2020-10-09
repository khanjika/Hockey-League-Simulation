package divison;

import teams.ITeamsModel;
import teams.TeamsModel;

import java.util.List;

public class DivisonModel implements IDivisonModel{
    private String divisionName;
    private ITeamsModel teamsModel;
    private List<TeamsModel> teams;
    private IDivisonPersistent iDivisonPersistent;

    public DivisonModel() {
        iDivisonPersistent = new DivisonPersistent();
        teamsModel = new TeamsModel();
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

    public void storeDivisionInformation(DivisonModel divisonModel, int conferenceId) {

        if (isDivisionAlreadyExist(divisonModel.getDivisionName(), conferenceId)) {
            System.out.println("Division Already Exist in the DB");

        } else {
            System.out.println("Inside store Division Method="+divisonModel.getDivisionName());
            int divisionId = iDivisonPersistent.addDivisionInformation(divisonModel.getDivisionName(), conferenceId);
            for (TeamsModel teamsModel : divisonModel.getTeams()) {
                System.out.println("Calling teams method for the team=>"+teamsModel.getTeamName());
                this.teamsModel.storeTeamInformation(teamsModel, divisionId);
            }

        }


    }

    public boolean isDivisionAlreadyExist(String divisionName, int conferenceId) {
            return iDivisonPersistent.isDivisionAlreadyExist(divisionName,conferenceId);
    }
    @Override
    public int getDivisionId(String divisionName, int conferenceId) {
        return iDivisonPersistent.getDivisionInformation(divisionName,conferenceId);
    }


}
