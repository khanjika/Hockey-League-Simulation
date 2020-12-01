package leagueobjectmodel;

import LeagueMockObject.MockCoach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoachValidatorTest {

    @Test
    void validateCoachObject() {
        ICoachModel coachModel = MockCoach.getValidCoachModel();
        CoachValidator coachValidator = new CoachValidator();
        assertTrue(coachValidator.validateCoachObject(coachModel));
        ICoachModel inValidCoachModel = MockCoach.getInvalidCoachModel();
        assertFalse(coachValidator.validateCoachObject(inValidCoachModel));
        ICoachModel inValidCoachModel2 = MockCoach.getInvalidCoachModel2();
        assertFalse(coachValidator.validateCoachObject(inValidCoachModel2));
    }
}
