package statemachine.states;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueModel;
import statemachine.StateMachine;


public class TradingState implements ITransition {

    StateMachine stateMachine;
    ILeagueModel leagueModel;
//    IGenerateTradeOffer iGenerateTradeOffer;

    public TradingState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

//    public TradingState(StateMachine stateMachine, LeagueModel leagueModel) {
//
//    }
//
    public void updateTradingStateValue(StateMachine stateMachine, ILeagueModel leagueModel){
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
    }

    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
//        iGenerateTradeOffer = new GenerateTradeOffer();
//        iGenerateTradeOffer.checkTrading(leagueModel);
        exit();
    }

    @Override
    public void exit() {
        return;
    }
}
