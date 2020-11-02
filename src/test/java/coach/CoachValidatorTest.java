package coach;

import mock.MockCoach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoachValidatorTest {

    @Test
    void validateCoachObject() {
        CoachModel coachModel = MockCoach.getValidCoachModel();
        CoachValidator coachValidator = new CoachValidator();
        assertTrue(coachValidator.validateCoachObject(coachModel));
        CoachModel inValidCoachModel = MockCoach.getInvalidCoachModel();
        assertFalse(coachValidator.validateCoachObject(inValidCoachModel));
        CoachModel inValidCoachModel2 = MockCoach.getInvalidCoachModel2();
        assertFalse(coachValidator.validateCoachObject(inValidCoachModel2));
    }
}