package statemachine.states.statemachine.states;


import leagueobjectmodel.ILeagueModel;
import statemachine.states.statemachine.StateMachine;
import statemachine.trade.IGenerateTradeOffer;
import statemachine.trade.TradeAbstractFactory;

public class TradingState implements ITransition {

    StateMachine stateMachine;
    ILeagueModel leagueModel;

    public TradingState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public void updateTradingStateValue(StateMachine stateMachine, ILeagueModel leagueModel) {
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
    }

    @Override
    public void entry() {
        task ();
    }

    @Override
    public void task() {
        IGenerateTradeOffer generateTradeOffer = TradeAbstractFactory.instance ().createTradeOffer ();
        generateTradeOffer.checkTrading (leagueModel);
        exit ();
    }

    @Override
    public void exit() {
        TradeAbstractFactory.instance ().setTradeOffer (null);
        return;
    }
}
