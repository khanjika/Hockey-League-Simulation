package coach;

import org.junit.jupiter.api.Test;
import players.PlayerModel;

import static org.junit.jupiter.api.Assertions.*;


public class CoachModelTest {

    @Test
    void getCoachName() {
        CoachModel coachModel = new CoachModel();
        coachModel.setName("best coach");
        assertEquals("best coach",coachModel.getName(),"Failed to get Coach name in Coach object");
    }

    @Test
    void setCoachName() {
        CoachModel coachModel = new CoachModel();
        coachModel.setName("best coach");
        assertEquals("best coach",coachModel.getName(),"Failed to set Coach name in Coach object");
    }

    @Test
    void getCoachSkating() {
        CoachModel coachModel = new CoachModel();
        coachModel.setSkating(2.0f);
        assertEquals(2.0f,coachModel.getSkating(),"Failed to get Coach Skating in Coach object");
    }

    @Test
    void setCoachSkating() {
        CoachModel coachModel = new CoachModel();
        coachModel.setSkating(2.0f);
        assertEquals(2.0f,coachModel.getSkating(),"Failed to set Coach Skating in Coach object");
    }

    @Test
    void getCoachShooting() {
        CoachModel coachModel = new CoachModel();
        coachModel.setShooting(2.0f);
        assertEquals(2.0f,coachModel.getShooting(),"Failed to get Coach Shooting in Coach object");
    }

    @Test
    void setCoachShooting() {
        CoachModel coachModel = new CoachModel();
        coachModel.setShooting(2.0f);
        assertEquals(2.0f,coachModel.getShooting(),"Failed to set Coach Shooting in Coach object");
    }

    @Test
    void getCoachChecking() {
        CoachModel coachModel = new CoachModel();
        coachModel.setChecking(2.0f);
        assertEquals(2.0f,coachModel.getChecking(),"Failed to get Coach Checking in Coach object");
    }

    @Test
    void setCoachChecking() {
        CoachModel coachModel = new CoachModel();
        coachModel.setChecking(2.0f);
        assertEquals(2.0f,coachModel.getChecking(),"Failed to set Coach Checking in Coach object");
    }

    @Test
    void getCoachSaving() {
        CoachModel coachModel = new CoachModel();
        coachModel.setSaving(2.0f);
        assertEquals(2.0f,coachModel.getSaving(),"Failed to get Coach Saving in Coach object");
    }

    @Test
    void setCoachSaving() {
        CoachModel coachModel = new CoachModel();
        coachModel.setSaving(2.0f);
        assertEquals(2.0f,coachModel.getSaving(),"Failed to set Coach Saving in Coach object");
    }

    public static CoachModel getCoachModel(String name, float skating, float shooting, float checking, float saving){
        CoachModel coachModel = new CoachModel();
        coachModel.setName(name);
        coachModel.setSkating(skating);
        coachModel.setShooting(shooting);
        coachModel.setSaving(saving);
        coachModel.setChecking(checking);
        return coachModel;
    }
}
