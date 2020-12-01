package leagueobjectmodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = TradingModel.class)
public interface ITradingModel {
    int getLossPoint();

    void setLossPoint(int lossPoint);

    float getRandomTradeOfferChance();

    void setRandomTradeOfferChance(float randomTradeOfferChance);

    int getMaxPlayersPerTrade();

    void setMaxPlayersPerTrade(int maxPlayersPerTrade);

    float getRandomAcceptanceChance();

    void setRandomAcceptanceChance(float randomAcceptanceChance);

    TradingModel.GmTable getGmTable();

    void setGmTable(TradingModel.GmTable gmTable);
}
