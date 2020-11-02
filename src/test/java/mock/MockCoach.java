package mock;

import coach.CoachModel;

public class MockCoach {
    public static CoachModel getValidCoachModel() {
        CoachModel coachModel = new CoachModel();
        coachModel.setName("Joe Smith");
        coachModel.setSaving(0.5f);
        coachModel.setShooting(0.8f);
        coachModel.setSkating(0.3f);
        coachModel.setChecking(1.0f);
        return coachModel;
    }

    public static CoachModel getInvalidCoachModel() {
        CoachModel coachModel = new CoachModel();
        coachModel.setName("");
        coachModel.setSaving(0.5f);
        coachModel.setShooting(0.8f);
        coachModel.setSkating(0.3f);
        coachModel.setChecking(1.0f);
        return coachModel;
    }

    public static CoachModel getInvalidCoachModel2() {
        CoachModel coachModel = new CoachModel();
        coachModel.setName("Joe Smith");
        coachModel.setSaving(   5f);
        coachModel.setShooting(0.8f);
        coachModel.setSkating(0.3f);
        coachModel.setChecking(1.0f);
        return coachModel;
    }

}
