package leagueobjectmodel;

import com.google.gson.annotations.Expose;

public class TradingModel implements ITradingModel {

    @Expose
    private GmTable gmTable;
    @Expose
    private int lossPoint;
    @Expose
    private float randomTradeOfferChance;
    @Expose
    private int maxPlayersPerTrade;
    @Expose
    private float randomAcceptanceChance;

    @Override
    public int getLossPoint() {
        return lossPoint;
    }

    @Override
    public void setLossPoint(int lossPoint) {
        this.lossPoint = lossPoint;
    }

    @Override
    public float getRandomTradeOfferChance() {
        return randomTradeOfferChance;
    }

    @Override
    public void setRandomTradeOfferChance(float randomTradeOfferChance) {
        this.randomTradeOfferChance = randomTradeOfferChance;
    }

    @Override
    public int getMaxPlayersPerTrade() {
        return maxPlayersPerTrade;
    }

    @Override
    public void setMaxPlayersPerTrade(int maxPlayersPerTrade) {
        this.maxPlayersPerTrade = maxPlayersPerTrade;
    }

    @Override
    public float getRandomAcceptanceChance() {
        return randomAcceptanceChance;
    }

    @Override
    public void setRandomAcceptanceChance(float randomAcceptanceChance) {
        this.randomAcceptanceChance = randomAcceptanceChance;
    }

    @Override
    public GmTable getGmTable() {
        return gmTable;
    }

    @Override
    public void setGmTable(GmTable gmTable) {
        this.gmTable = gmTable;
    }

    public class GmTable {
        @Expose
        private float shrewd;
        @Expose
        private float gambler;
        @Expose
        private float normal;

        public GmTable() {
        }

        public GmTable(float shrewd, float gambler, float normal) {
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
