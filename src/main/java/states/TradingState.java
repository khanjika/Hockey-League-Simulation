package states;

import league.LeagueModel;
import statemachine.StateMachine;

public class TradingState implements ITransition {

    StateMachine stateMachine;
    LeagueModel leagueModel;

    public TradingState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public TradingState(StateMachine stateMachine, LeagueModel leagueModel) {
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
    }

    @Override
    public void entry() {
        System.out.println("Inside Trading address=>" + leagueModel);
        task();
    }

    @Override
    public void task() {

    }

    @Override
    public void exit() {

    }

    //Dummy method will be replaced by Khnajika's method
    void performTrading(LeagueModel leagueModel) {
        //perform task
    }
}
