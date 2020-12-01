package leagueobjectmodel;

import LeagueMockObject.MockLeagueAbstractFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CoachModelTest {
    ICoachModel coachModel = MockLeagueAbstractFactory.getMockInstance().createCoachModel();

    @BeforeEach
    void Initialization(){

    }

    @Test
    void getCoachName() {
        coachModel.setName("best coach");
        assertEquals("best coach", coachModel.getName(), "Failed to get Coach name in Coach object");
    }

    @Test
    void setCoachName() {
        coachModel.setName("best coach");
        assertEquals("best coach", coachModel.getName(), "Failed to set Coach name in Coach object");
    }

    @Test
    void getCoachSkating() {
        coachModel.setSkating(0.2f);
        assertEquals(0.2f, coachModel.getSkating(), "Failed to get Coach Skating in Coach object");
    }

    @Test
    void setCoachSkating() {
        coachModel.setSkating(0.2f);
        assertEquals(0.2f, coachModel.getSkating(), "Failed to set Coach Skating in Coach object");
    }

    @Test
    void getCoachShooting() {
        coachModel.setShooting(0.2f);
        assertEquals(0.2f, coachModel.getShooting(), "Failed to get Coach Shooting in Coach object");
    }

    @Test
    void setCoachShooting() {
        coachModel.setShooting(0.2f);
        assertEquals(0.2f, coachModel.getShooting(), "Failed to set Coach Shooting in Coach object");
    }

    @Test
    void getCoachChecking() {
        coachModel.setChecking(0.2f);
        assertEquals(0.2f, coachModel.getChecking(), "Failed to get Coach Checking in Coach object");
    }

    @Test
    void setCoachChecking() {
        coachModel.setChecking(0.2f);
        assertEquals(0.2f, coachModel.getChecking(), "Failed to set Coach Checking in Coach object");
    }

    @Test
    void getCoachSaving() {
        coachModel.setSaving(0.2f);
        assertEquals(0.2f, coachModel.getSaving(), "Failed to get Coach Saving in Coach object");
    }

    @Test
    void setCoachSaving() {
        coachModel.setSaving(0.2f);
        assertEquals(0.2f, coachModel.getSaving(), "Failed to set Coach Saving in Coach object");
    }

}
