package statemachine.states.trade;

public class TradeAbstractFactory implements ITradeAbstractFactory {

    private static TradeAbstractFactory uniqueInstance = null;
    private IGenerateTradeOffer tradeOffer;
    private IFindOfferedPlayers offeredPlayers;
    private IAcceptRejectTrade acceptRejectTrade;
    private ITradeModel tradeModel;
    private ITradeTeamPojo tradeTeamPojo;
    private IFindTeamToSwap teamToSwap;
    private ICalculateStrength calculateStrength;

//    private TradeAbstractFactory() {
//        tradeOffer = new GenerateTradeOffer ();
//        offeredPlayers = new FindOfferedPlayers ();
//        teamToSwap = new FindTeamToSwap ();
//        acceptRejectTrade = new AcceptRejectTrade ();
//        tradeModel = new TradeModel ();
//        tradeTeamPojo = new TradeTeamPojo ();
//        calculateStrength = new CalculateStrength ();
//    }

    public static ITradeAbstractFactory getUniqueInstance() {
        if (null == uniqueInstance) {
            uniqueInstance = new TradeAbstractFactory ();
        }
        return uniqueInstance;
    }

    public static ITradeAbstractFactory getInstance() {
        return new TradeAbstractFactory ();
    }


    @Override
    public IAcceptRejectTrade getAcceptRejectTrade() {
        if (acceptRejectTrade == null) {
            acceptRejectTrade = new AcceptRejectTrade ();
        }
        return acceptRejectTrade;
    }

    @Override
    public IFindOfferedPlayers getOfferedPlayers() {
        if (offeredPlayers == null) {
            offeredPlayers = new FindOfferedPlayers ();
        }
        return offeredPlayers;
    }

    @Override
    public IGenerateTradeOffer getTradeOffer() {
        if (tradeOffer == null) {
            tradeOffer = new GenerateTradeOffer ();
        }
        return tradeOffer;
    }

    @Override
    public ITradeModel getTradeModel() {
        if(tradeModel == null){
            tradeModel = new TradeModel ();
        }
        return tradeModel;
    }

    @Override
    public ITradeTeamPojo getTeamPojo() {
       if(tradeTeamPojo == null){
           tradeTeamPojo = new TradeTeamPojo ();
       }
       return tradeTeamPojo;
    }

    @Override
    public IFindTeamToSwap getTeamToSwap() {
       if(teamToSwap == null){
           teamToSwap = new FindTeamToSwap ();
       }
       return teamToSwap;
    }

    @Override
    public ICalculateStrength getStrength() {
        if(calculateStrength == null){
            calculateStrength = new CalculateStrength ();
        }
        return calculateStrength;
    }
}
