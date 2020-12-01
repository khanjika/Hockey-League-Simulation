package leagueobjectmodel;

public class TradingValidator implements ITradingValidator {

    @Override
    public boolean validateTrading(TradingModel tradingModel) {
        return isNotNull(tradingModel.getLossPoint()) && isNotNull(tradingModel.getMaxPlayersPerTrade()) &&
                isNotNull(tradingModel.getRandomAcceptanceChance()) && isNotNull(tradingModel.getRandomTradeOfferChance());
    }

    public boolean isNotNull(int value) {
        if(value==0){
            return false;
        }
        else
            return true;
    }

    public boolean isNotNull(float value) {
        if(value==0){
            return false;
        }
        else
            return true;
    }
}
