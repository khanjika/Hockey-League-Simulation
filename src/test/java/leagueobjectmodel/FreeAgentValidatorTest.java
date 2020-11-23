package leagueobjectmodel;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FreeAgentValidatorTest {


    @Test
    void validateFreeAgentObject() {
        FreeAgentModel freeAgentModel = MockFreeAgent.getFreeAgentModel();
        FreeAgentValidator freeAgentValidator = new FreeAgentValidator();
        assertTrue(freeAgentValidator.validateFreeAgentObject(freeAgentModel));
        FreeAgentModel freeAgentModel1 = MockFreeAgent.getInvalidFreeAgentModel();
        assertFalse(freeAgentValidator.validateFreeAgentObject(freeAgentModel1));

    }
}
