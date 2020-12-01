package leagueobjectmodel;

import LeagueMockObject.MockPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerValidatorTest {

    IPlayerValidator playerValidator;
    @BeforeEach
    void Initialization(){
        playerValidator = LeagueObjectModelFactoryAbstractTest.getInstance().getPlayerValidator();
    }

    @Test
    void validatePlayerObject() {
        IPlayerModel playerModel = MockPlayer.getPlayerModel();
        assertTrue(playerValidator.validatePlayerObject(playerModel));
        IPlayerModel InValidPlayerModel = MockPlayer.getInvalidPlayerModel();
        assertFalse(playerValidator.validatePlayerObject(InValidPlayerModel));
    }
}
