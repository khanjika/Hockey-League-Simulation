package gameplayconfig;

import com.google.gson.annotations.Expose;

public class TradingModel implements ITradingModel{
    @Expose
    private int lossPoint;
    @Expose
    private float randomTradeOfferChance;
    @Expose
    private int maxPlayersPerTrade;
    @Expose
    private float randomAcceptanceChance;

    ITradingPersistent iTradingPersistent;
    public int getLossPoint() {
        return lossPoint;
    }

    public void setLossPoint(int lossPoint) {
        this.lossPoint = lossPoint;
    }

    public float getRandomTradeOfferChance() {
        return randomTradeOfferChance;
    }

    public void setRandomTradeOfferChance(float randomTradeOfferChance) {
        this.randomTradeOfferChance = randomTradeOfferChance;
    }

    public int getMaxPlayersPerTrade() {
        return maxPlayersPerTrade;
    }

    public void setMaxPlayersPerTrade(int maxPlayersPerTrade) {
        this.maxPlayersPerTrade = maxPlayersPerTrade;
    }

    public float getRandomAcceptanceChance() {
        return randomAcceptanceChance;
    }

    public void setRandomAcceptanceChance(float randomAcceptanceChance) {
        this.randomAcceptanceChance = randomAcceptanceChance;
    }

    public int addTradingModelInformation(TradingModel tradingModel){
        iTradingPersistent=new TradingPersistent();
        return iTradingPersistent.storeTradingInformation(tradingModel.getLossPoint(),tradingModel.getRandomTradeOfferChance(),tradingModel.getMaxPlayersPerTrade(),tradingModel.getRandomAcceptanceChance());
    }
}
