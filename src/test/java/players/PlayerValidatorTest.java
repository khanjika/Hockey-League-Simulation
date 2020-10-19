package players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerValidatorTest {

    @Test
    void validatePlayerObject(){
        PlayerModel playerModel = PlayerModelTest.getPlayerModel("Roshan","forward",true);
        PlayerValidator playerValidator = new PlayerValidator();
        //need to update to true
        assertFalse(playerValidator.validatePlayerObject(playerModel));
        PlayerModel InValidPlayerModel = PlayerModelTest.getPlayerModel("Roshan","XYZ",true);
        assertFalse(playerValidator.validatePlayerObject(InValidPlayerModel));
    }



}