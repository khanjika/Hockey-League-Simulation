package leagueobjectmodel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InjuriesValidatorTest {

    @Test
    void validateInjuries() {
        InjuriesModel injuriesModel = InjuriesModelTest.getInjuriesModel(0.05f, 1, 250);
        InjuriesValidator injuriesValidator = new InjuriesValidator();
        assertTrue(injuriesValidator.validateInjuries(injuriesModel));
        InjuriesModel invalidInjuriesModel = InjuriesModelTest.getInjuriesModel(0.05f, 1, 0);
        assertFalse(injuriesValidator.validateInjuries(invalidInjuriesModel));
    }
}
