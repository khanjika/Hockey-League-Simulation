package coach;

import org.junit.jupiter.api.Test;

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
        coachModel.setSkating(0.2f);
        assertEquals(0.2f,coachModel.getSkating(),"Failed to get Coach Skating in Coach object");
    }

    @Test
    void setCoachSkating() {
        CoachModel coachModel = new CoachModel();
        coachModel.setSkating(0.2f);
        assertEquals(0.2f,coachModel.getSkating(),"Failed to set Coach Skating in Coach object");
    }

    @Test
    void getCoachShooting() {
        CoachModel coachModel = new CoachModel();
        coachModel.setShooting(0.2f);
        assertEquals(0.2f,coachModel.getShooting(),"Failed to get Coach Shooting in Coach object");
    }

    @Test
    void setCoachShooting() {
        CoachModel coachModel = new CoachModel();
        coachModel.setShooting(0.2f);
        assertEquals(0.2f,coachModel.getShooting(),"Failed to set Coach Shooting in Coach object");
    }

    @Test
    void getCoachChecking() {
        CoachModel coachModel = new CoachModel();
        coachModel.setChecking(0.2f);
        assertEquals(0.2f,coachModel.getChecking(),"Failed to get Coach Checking in Coach object");
    }

    @Test
    void setCoachChecking() {
        CoachModel coachModel = new CoachModel();
        coachModel.setChecking(0.2f);
        assertEquals(0.2f,coachModel.getChecking(),"Failed to set Coach Checking in Coach object");
    }

    @Test
    void getCoachSaving() {
        CoachModel coachModel = new CoachModel();
        coachModel.setSaving(0.2f);
        assertEquals(0.2f,coachModel.getSaving(),"Failed to get Coach Saving in Coach object");
    }

    @Test
    void setCoachSaving() {
        CoachModel coachModel = new CoachModel();
        coachModel.setSaving(0.2f);
        assertEquals(0.2f,coachModel.getSaving(),"Failed to set Coach Saving in Coach object");
    }

    @Test
    void storeCoachInformation(){
        MockCoachPersistent mockCoachPersistent = new MockCoachPersistent();
        mockCoachPersistent.storeCoachesInformation(1,"zankrut",10,10,10,10);
    }
}
