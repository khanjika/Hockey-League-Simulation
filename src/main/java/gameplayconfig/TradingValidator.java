package gameplayconfig;

public class TradingValidator implements ITradingValidator {

    @Override
    public boolean validateTrading(TradingModel tradingModel) {
        return isNotNull(tradingModel.getLossPoint()) && isNotNull(tradingModel.getMaxPlayersPerTrade()) &&
                isNotNull(tradingModel.getRandomAcceptanceChance()) && isNotNull(tradingModel.getRandomTradeOfferChance());
    }

    public boolean isNotNull(int value) {
        return value != 0;
    }

    public boolean isNotNull(float value) {
        return value != 0;
    }
}
