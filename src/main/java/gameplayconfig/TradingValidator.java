package gameplayconfig;

public class TradingValidator implements ITradingValidator {

    @Override
    public boolean validateTrading(TradingModel tradingModel) {
        if (isNotNull(tradingModel.getLossPoint()) && isNotNull(tradingModel.getMaxPlayersPerTrade()) &&
        isNotNull(tradingModel.getRandomAcceptanceChance()) && isNotNull(tradingModel.getRandomTradeOfferChance())) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isNotNull(int value) {
        if (value == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isNotNull(float value) {
        if (value == 0) {
            return false;
        } else {
            return true;
        }
    }
}