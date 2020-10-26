package players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerValidatorTest {

    @Test
    void validatePlayerObject(){
        PlayerModel playerModel = PlayerModelTest.getPlayerModel("Roshan","forward",true,20,10,10,10,10);
        PlayerValidator playerValidator = new PlayerValidator();
        assertTrue(playerValidator.validatePlayerObject(playerModel));
        PlayerModel InValidPlayerModel = PlayerModelTest.getPlayerModel("Roshan","XYZ",true,20,10,10,10,0);
        assertFalse(playerValidator.validatePlayerObject(InValidPlayerModel));
    }
}