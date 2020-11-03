package divison;

import com.google.gson.annotations.Expose;
import teams.ITeamsModel;
import teams.TeamsModel;

import java.util.List;

public class DivisonModel implements IDivisonModel {
    @Expose
    private String divisionName;
    private final ITeamsModel teamsModel;
    @Expose
    private List<TeamsModel> teams;
    private final IDivisonPersistent iDivisonPersistent;

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
            int divisionId = iDivisonPersistent.addDivisionInformation(divisonModel.getDivisionName(), conferenceId);
            for (TeamsModel teamsModel : divisonModel.getTeams()) {
                this.teamsModel.storeTeamInformation(teamsModel, divisionId);
            }
        }
    }

    public boolean isDivisionAlreadyExist(String divisionName, int conferenceId) {
        return iDivisonPersistent.isDivisionAlreadyExist(divisionName, conferenceId);
    }

    @Override
    public int getDivisionId(String divisionName, int conferenceId) {
        return iDivisonPersistent.getDivisionInformation(divisionName, conferenceId);
    }


}
