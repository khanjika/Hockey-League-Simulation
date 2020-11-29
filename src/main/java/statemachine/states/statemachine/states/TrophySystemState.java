package statemachine.states.statemachine.states;

import leagueobjectmodel.ILeagueModel;
import statemachine.states.statemachine.StateMachine;
import statemachine.trophysystem.ITrophySystem;
import statemachine.trophysystem.TrophySystemAbstractFactory;

public class TrophySystemState implements ITransition{

    StateMachine stateMachine;
    ILeagueModel leagueModel;
    ITrophySystem trophySystem = TrophySystemAbstractFactory.getInstance().getTrophySystem();
    int year;

    public TrophySystemState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public  void updateTrophyStateValue(StateMachine stateMachine, ILeagueModel leagueModel,int year){
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
        this.year = year;
    }
    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        trophySystem.awardWinners();
    }

    @Override
    public void exit() {

    }
}
