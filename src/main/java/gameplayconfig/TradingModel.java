package gameplayconfig;

import com.google.gson.annotations.Expose;

import java.util.List;

public class TradingModel implements ITradingModel {

    private GmTable gmTable;
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

    public GmTable getGmTable() {
        return gmTable;
    }

    public void setGmTable(GmTable gmTable) {
        this.gmTable = gmTable;
    }

    public int addTradingModelInformation(TradingModel tradingModel) {
        iTradingPersistent = new TradingPersistent();
        return iTradingPersistent.storeTradingInformation(tradingModel.getLossPoint(), tradingModel.getRandomTradeOfferChance(), tradingModel.getMaxPlayersPerTrade(), tradingModel.getRandomAcceptanceChance());
    }

    public class GmTable {
        private float shrewd;
        private float gambler;
        private float normal;

        public  GmTable(){}
        public GmTable(float shrewd,float gambler,float normal){
            this.shrewd = shrewd;
            this.gambler = gambler;
            this.normal = normal;
        }

        public float getShrewd() {
            return shrewd;
        }

        public void setShrewd(float shrewd) {
            this.shrewd = shrewd;
        }

        public float getGambler() {
            return gambler;
        }

        public void setGambler(float gambler) {
            this.gambler = gambler;
        }

        public float getNormal() {
            return normal;
        }

        public void setNormal(float normal) {
            this.normal = normal;
        }
    }

}
