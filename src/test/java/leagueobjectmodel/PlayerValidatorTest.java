package leagueobjectmodel;

import LeagueMockObject.MockPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerValidatorTest {

    @Test
    void validatePlayerObject() {
        IPlayerModel playerModel = MockPlayer.getPlayerModel();
        PlayerValidator playerValidator = new PlayerValidator();
        assertTrue(playerValidator.validatePlayerObject(playerModel));
        IPlayerModel InValidPlayerModel = MockPlayer.getInvalidPlayerModel();
        assertFalse(playerValidator.validatePlayerObject(InValidPlayerModel));
    }
}
