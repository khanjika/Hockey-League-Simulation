package gameplayconfig;

public class TradingModel implements ITradingModel{
    private int lossPoint;
    private float randomTradeOfferChance;
    private int maxPlayersPerTrade;
    private float randomAcceptanceChance;

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
}
