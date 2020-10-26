package coach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoachValidatorTest {

    @Test
    void validateCoachObject() {
        CoachModel coachModel = CoachModelTest.getCoachModel("Joe Smith",0.5f,0.8f,0.3f,1.0f);
        CoachValidator coachValidator = new CoachValidator();
        assertTrue(coachValidator.validateCoachObject(coachModel));
        CoachModel inValidCoachModel = CoachModelTest.getCoachModel("",0.5f,0.8f,0.3f,1.0f);
        assertFalse(coachValidator.validateCoachObject(inValidCoachModel));
    }
}