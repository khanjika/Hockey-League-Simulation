package freeagent;

import org.junit.jupiter.api.Test;
import players.PlayerModel;
import players.PlayerModelTest;
import players.PlayerValidator;

import static org.junit.jupiter.api.Assertions.*;

class FreeAgentValidatorTest {


    @Test
    void validateFreeAgentObject(){
        FreeAgentModel freeAgentModel = FreeAgentModelTest.getFreeAgentModel("Roshan","forward",20, 2.0f,5.0f,6.0f,7.0f );
        FreeAgentValidator freeAgentValidator = new FreeAgentValidator();
        //update to true
        assertTrue(freeAgentValidator.validateFreeAgentObject(freeAgentModel));
        FreeAgentModel InValidPlayerModel = FreeAgentModelTest.getFreeAgentModel("Roshan","XYZ",20, 2.0f,5.0f,6.0f,7.0f );
        FreeAgentValidator freeAgentValidator1 = new FreeAgentValidator();
        //update to true
        assertTrue(freeAgentValidator1.validateFreeAgentObject(InValidPlayerModel));

    }
}
