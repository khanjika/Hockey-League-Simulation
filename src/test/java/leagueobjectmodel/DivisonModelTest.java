package leagueobjectmodel;

import org.junit.jupiter.api.Test;

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
        assertEquals("Division One", divisonModel.getDivisionName(), "Failed to get division name");
    }

    @Test
    void setDivisionNameTest() {
        DivisonModel divisonModel = new DivisonModel();
        divisonModel.setDivisionName("Division One");
        assertEquals("Division One", divisonModel.getDivisionName(), "Failed to set Division model");
    }

    @Test
    void setTeamsTest() {
        DivisonModel divisonModel = new DivisonModel();
        divisonModel.setTeams(new ArrayList<>());
        assertNotNull(divisonModel.getTeams(), "Failed to set teams in division object");
    }

    @Test
    void getTeamsTest() {
        DivisonModel divisonModel = new DivisonModel();
        divisonModel.setTeams(new ArrayList<>());
        assertNotNull(divisonModel.getTeams(), "Failed to get teams in division object");
    }

}
