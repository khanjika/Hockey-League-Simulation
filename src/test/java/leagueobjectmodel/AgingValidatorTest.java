package leagueobjectmodel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AgingValidatorTest {

    @Test
    void validateAging() {
        AgingModel agingModel = AgingModelTest.getAgingModel(35, 50);
        AgingValidator agingValidator = new AgingValidator();
        assertTrue(agingValidator.validateAging(agingModel));
        AgingModel InvalidAgingModel = AgingModelTest.getAgingModel(0, 0);
        assertFalse(agingValidator.validateAging(InvalidAgingModel));
    }
}
