package statemachine.states.trade;

public interface ITradeAbstractFactory {

    public IAcceptRejectTrade getAcceptRejectTrade();

    public IFindOfferedPlayers getOfferedPlayers();

    public IGenerateTradeOffer getTradeOffer();

    public ITradeModel getTradeModel();

    public ITradeTeamPojo getTeamPojo();

    public IFindTeamToSwap getTeamToSwap();

    public ICalculateStrength getStrength();
}
