package divison;

import conference.ConferenceModel;
import org.junit.jupiter.api.Test;
import teams.TeamsModel;
import teams.TeamsModelTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DivisonModelTest {


    private String divisionName;
    private List<TeamsModel> teams;

    @Test
    void getDivisionNameTest() {
        DivisonModel divisonModel = new DivisonModel();
        divisonModel.setDivisionName("Division One");
       assertEquals("Division One",divisonModel.getDivisionName(),"Failed to get division name");
    }

    @Test
    void setDivisionNameTest() {
        DivisonModel divisonModel = new DivisonModel();
        divisonModel.setDivisionName("Division One");
        assertEquals("Division One",divisonModel.getDivisionName(),"Failed to set Division model");
    }

    @Test
    void setTeamsTest() {
        DivisonModel divisonModel = new DivisonModel();
        divisonModel.setTeams(new ArrayList<TeamsModel>());
        assertNotNull(divisonModel.getTeams(),"Failed to set teams in division object");
    }

    @Test
    void getTeamsTest() {
        DivisonModel divisonModel = new DivisonModel();
        divisonModel.setTeams(new ArrayList<TeamsModel>());
        assertNotNull(divisonModel.getTeams(),"Failed to get teams in division object");
    }

    public static DivisonModel getDivisionObject(){
        DivisonModel divisonModel=new DivisonModel();
        divisonModel.setDivisionName("Atlantic");
        TeamsModelTest teamsModelTest = new TeamsModelTest();
        List<TeamsModel> teamModelObjectList =new ArrayList<>();

        for(int i=0;i<2;i++){
            TeamsModel teamsModel=new TeamsModel();
            teamsModel= teamsModelTest.getTeamsObject();
            teamModelObjectList.add(teamsModel);
        }

        divisonModel.setTeams(teamModelObjectList);
        return  divisonModel;
    }

}