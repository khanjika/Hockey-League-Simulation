package players;

import mock.MockPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerValidatorTest {

    @Test
    void validatePlayerObject() {
        PlayerModel playerModel = MockPlayer.getPlayerModel();
        PlayerValidator playerValidator = new PlayerValidator();
        assertTrue(playerValidator.validatePlayerObject(playerModel));
        PlayerModel InValidPlayerModel = MockPlayer.getInvalidPlayerModel();
        assertFalse(playerValidator.validatePlayerObject(InValidPlayerModel));
    }
}
