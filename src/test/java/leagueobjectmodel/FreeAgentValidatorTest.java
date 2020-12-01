package leagueobjectmodel;


import LeagueMockObject.MockFreeAgent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FreeAgentValidatorTest {


    @Test
    void validateFreeAgentObject() {
        IFreeAgentModel freeAgentModel = MockFreeAgent.getFreeAgentModel();
        FreeAgentValidator freeAgentValidator = new FreeAgentValidator();
        assertTrue(freeAgentValidator.validateFreeAgentObject(freeAgentModel));
        IFreeAgentModel freeAgentModel1 = MockFreeAgent.getInvalidFreeAgentModel();
        assertFalse(freeAgentValidator.validateFreeAgentObject(freeAgentModel1));

    }
}
