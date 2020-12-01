package leagueobjectmodel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TradingValidatorTest {

    @Test
    void validateTrading() {
        TradingModel tradingModel = TradingModelTest.getTradingModel(8, 0.05f, 2, 0.05f);
        TradingValidator tradingValidator = new TradingValidator();
        assertTrue(tradingValidator.validateTrading(tradingModel));
        TradingModel invalidTrainingModel = TradingModelTest.getTradingModel(8, 0.05f, 0, 0.05f);
        assertFalse(tradingValidator.validateTrading(invalidTrainingModel));
    }
}
