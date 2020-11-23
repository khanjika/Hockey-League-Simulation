package leagueobjectmodel;

import leagueobjectmodel.TradingModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TradingModelTest {

    @Test
    void getLossPoint() {
        TradingModel tradingModel = new TradingModel();
        tradingModel.setLossPoint(8);
        assertEquals(8, tradingModel.getLossPoint(), "Failed to get losspoint in Trading object");
    }

    @Test
    void setLossPoint() {
        TradingModel tradingModel = new TradingModel();
        tradingModel.setLossPoint(8);
        assertEquals(8, tradingModel.getLossPoint(), "Failed to set losspoint in Trading object");
    }

    @Test
    void getRandomTradeOfferChance() {
        TradingModel tradingModel = new TradingModel();
        tradingModel.setRandomTradeOfferChance(0.05f);
        assertEquals(0.05f, tradingModel.getRandomTradeOfferChance(), "Failed to get randomtradeofferhance in Trading object");
    }

    @Test
    void setRandomTradeOfferChance() {
        TradingModel tradingModel = new TradingModel();
        tradingModel.setRandomTradeOfferChance(0.05f);
        assertEquals(0.05f, tradingModel.getRandomTradeOfferChance(), "Failed to set randomtradeofferhance in Trading object");
    }

    @Test
    void getMaxPlayersPerTrade() {
        TradingModel tradingModel = new TradingModel();
        tradingModel.setMaxPlayersPerTrade(2);
        assertEquals(2, tradingModel.getMaxPlayersPerTrade(), "Failed to set maxplayerspertrade in Trading object");
    }

    @Test
    void setMaxPlayersPerTrade() {
        TradingModel tradingModel = new TradingModel();
        tradingModel.setMaxPlayersPerTrade(2);
        assertEquals(2, tradingModel.getMaxPlayersPerTrade(), "Failed to set maxplayerspertrade in Trading object");
    }

    @Test
    void getRandomAcceptanceChance() {
        TradingModel tradingModel = new TradingModel();
        tradingModel.setRandomAcceptanceChance(0.05f);
        assertEquals(0.05f, tradingModel.getRandomAcceptanceChance(), "Failed to set maxplayerspertrade in Trading object");
    }

    @Test
    void setRandomAcceptanceChance() {
        TradingModel tradingModel = new TradingModel();
        tradingModel.setRandomAcceptanceChance(0.05f);
        assertEquals(0.05f, tradingModel.getRandomAcceptanceChance(), "Failed to set maxplayerspertrade in Trading object");
    }

    public static TradingModel getTradingModel(int lossPoint, float randomTradeOfferChance, int maxPlayersPerTrade, float randomAcceptanceChance) {
        TradingModel tradingModel = new TradingModel();
        tradingModel.setLossPoint(lossPoint);
        tradingModel.setRandomTradeOfferChance(randomTradeOfferChance);
        tradingModel.setMaxPlayersPerTrade(maxPlayersPerTrade);
        tradingModel.setRandomAcceptanceChance(randomAcceptanceChance);
        return tradingModel;
    }

}
