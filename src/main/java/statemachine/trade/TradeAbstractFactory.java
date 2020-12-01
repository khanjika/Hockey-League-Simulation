package statemachine.trade;

public abstract class TradeAbstractFactory {

    private static TradeAbstractFactory uniqueInstance = null;

    public static TradeAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new TradeAbstractFactoryConcrete ();
        }
        return uniqueInstance;
    }

    public abstract IAcceptRejectTrade createAcceptRejectTrade();

    public abstract IFindOfferedPlayers createOfferedPlayers();

    public abstract IGenerateTradeOffer createTradeOffer();

    public abstract ITradeModel createTradeModel();

    public abstract IFindTeamToSwap createTeamToSwap();

    public abstract ICalculateStrength createStrength();

    public abstract IUserTradeCli createUserTradeCli();

    public abstract void setTradeOffer(IGenerateTradeOffer tradeOffer);
}
