package statemachine.states.statemachine.states;


import org.apache.log4j.Logger;
import statemachine.states.statemachine.StateMachine;
import leagueobjectmodel.ILeagueModel;
public class TradingState implements ITransition {

    StateMachine stateMachine;
    ILeagueModel leagueModel;
    //IGenerateTradeOffer iGenerateTradeOffer;
    final static Logger logger = Logger.getLogger(TradingState.class);
    public TradingState(StateMachine stateMachine) {
        logger.info("Initializing Trading State");
        this.stateMachine = stateMachine;
    }

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
        //iGenerateTradeOffer = new GenerateTradeOffer();
        //iGenerateTradeOffer.checkTrading(leagueModel);
        exit();
    }

    @Override
    public void exit() {
        return;
    }
}
