package leagueobjectmodel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameResolverValidatorTest {

    @Test
    void validateGameResolver() {
        GameResolverModel gameResolverModel = GameResolverModelTest.getgameResolverModel(0.1f);
        GameResolverValidator gameResolverValidator = new GameResolverValidator();
        assertTrue(gameResolverValidator.validateGameResolver(gameResolverModel));
        GameResolverModel invalidGameResolverModel = GameResolverModelTest.getgameResolverModel(0);
        assertFalse(gameResolverValidator.validateGameResolver(invalidGameResolverModel));
    }
}
