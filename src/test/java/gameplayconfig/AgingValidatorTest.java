package gameplayconfig;

import org.junit.jupiter.api.Test;
import players.PlayerModel;
import players.PlayerModelTest;
import players.PlayerValidator;

import static org.junit.jupiter.api.Assertions.*;

class AgingValidatorTest {

    @Test
    void validateAging() {
        AgingModel agingModel = AgingModelTest.getAgingModel(35,50);
        AgingValidator agingValidator = new AgingValidator();
        assertTrue(agingValidator.validateAging(agingModel));
        AgingModel InvalidagingModel = AgingModelTest.getAgingModel(0,0);
        assertFalse(agingValidator.validateAging(InvalidagingModel));
    }
}