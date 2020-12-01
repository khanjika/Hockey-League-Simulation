package LeagueMockObject;

import LeagueMockObject.MockLeagueAbstractFactory;
import leagueobjectmodel.CoachModel;
import leagueobjectmodel.ICoachModel;

public class MockCoach {
    static ICoachModel coachModel =MockLeagueAbstractFactory.getMockInstance().createCoachModel();

    public static ICoachModel getValidCoachModel() {
        coachModel.setName("Joe Smith");
        coachModel.setSaving(0.5f);
        coachModel.setShooting(0.8f);
        coachModel.setSkating(0.3f);
        coachModel.setChecking(1.0f);
        return coachModel;
    }

    public static ICoachModel getInvalidCoachModel() {
        coachModel.setName("");
        coachModel.setSaving(0.5f);
        coachModel.setShooting(0.8f);
        coachModel.setSkating(0.3f);
        coachModel.setChecking(1.0f);
        return coachModel;
    }

    public static ICoachModel getInvalidCoachModel2() {
        coachModel.setName("Joe Smith");
        coachModel.setSaving(5f);
        coachModel.setShooting(0.8f);
        coachModel.setSkating(0.3f);
        coachModel.setChecking(1.0f);
        return coachModel;
    }

}
