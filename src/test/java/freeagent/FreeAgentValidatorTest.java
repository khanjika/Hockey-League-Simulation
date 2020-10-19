package freeagent;

import org.junit.jupiter.api.Test;
import players.PlayerModel;
import players.PlayerModelTest;
import players.PlayerValidator;

import static org.junit.jupiter.api.Assertions.*;

class FreeAgentValidatorTest {


    @Test
    void validateFreeAgentObject(){
        FreeAgentModel freeAgentModel = FreeAgentModelTest.getFreeAgentModel("Roshan","forward",true);
        FreeAgentValidator freeAgentValidator = new FreeAgentValidator();
        //update to true
        assertFalse(freeAgentValidator.validateFreeAgentObject(freeAgentModel));
        FreeAgentModel InValidPlayerModel = FreeAgentModelTest.getFreeAgentModel("Roshan","XYZ",true);
        //update to true
        assertFalse(freeAgentValidator.validateFreeAgentObject(InValidPlayerModel));

    }
}
