package gameplayconfig;

public interface ITradingPersistent {
    int storeTradingInformation(int lossPoint, float randomTradeOfferChance, int maxPlayerPerTrade, float randomAcceptanceChance);

    TradingModel getTradingInformation(int gamePlayConfigId);
}
