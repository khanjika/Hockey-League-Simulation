package gameplayconfig;

public class MockTradingPersistent {
    int storeTradingInformation(int lossPoint, float randomTradeOfferChance, int maxPlayerPerTrade, float randomAcceptanceChance) {
        return 0;
    }

    TradingModel getTradingInformation(int gamePlayConfigId) {
        TradingModel tradingModel = new TradingModel();
        tradingModel.setRandomAcceptanceChance(0.05f);
        tradingModel.setMaxPlayersPerTrade(2);
        tradingModel.setRandomTradeOfferChance(0.05f);
        tradingModel.setLossPoint(8);
        return tradingModel;
    }
}
