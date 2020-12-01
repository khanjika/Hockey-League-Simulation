package statemachine.trade;

public class TradeAbstractFactoryConcrete extends TradeAbstractFactory {

    private IGenerateTradeOffer tradeOffer;
    private IFindOfferedPlayers offeredPlayers;
    private IAcceptRejectTrade acceptRejectTrade;
    private ITradeModel tradeModel;
    private IFindTeamToSwap teamToSwap;
    private ICalculateStrength calculateStrength;
    private IUserTradeCli userTradeCli;

    public TradeAbstractFactoryConcrete() {
        super ();
    }

    @Override
    public IAcceptRejectTrade createAcceptRejectTrade() {
        if (acceptRejectTrade == null) {
            acceptRejectTrade = new AcceptRejectTrade ();
        }
        return acceptRejectTrade;
    }

    @Override
    public IFindOfferedPlayers createOfferedPlayers() {
        if (offeredPlayers == null) {
            offeredPlayers = new FindOfferedPlayers ();
        }
        return offeredPlayers;
    }

    @Override
    public IGenerateTradeOffer createTradeOffer() {
        if (tradeOffer == null) {
            tradeOffer = new GenerateTradeOffer ();
        }
        return tradeOffer;
    }

    @Override
    public void setTradeOffer(IGenerateTradeOffer tradeOffer) {
        this.tradeOffer = tradeOffer;
    }

    @Override
    public ITradeModel createTradeModel() {
        if (tradeModel == null) {
            tradeModel = new TradeModel ();
        }
        return tradeModel;
    }

    @Override
    public IFindTeamToSwap createTeamToSwap() {
        if (teamToSwap == null) {
            teamToSwap = new FindTeamToSwap ();
        }
        return teamToSwap;
    }

    @Override
    public ICalculateStrength createStrength() {
        if (calculateStrength == null) {
            calculateStrength = new CalculateStrength ();
        }
        return calculateStrength;
    }

    @Override
    public IUserTradeCli createUserTradeCli() {
        if (userTradeCli == null) {
            userTradeCli = new UserTradeCli ();
        }
        return userTradeCli;
    }

}
