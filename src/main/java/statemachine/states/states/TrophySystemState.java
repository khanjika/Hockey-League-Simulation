package statemachine.states.states;

import leagueobjectmodel.ILeagueModel;
import org.apache.log4j.Logger;
import statemachine.states.StateMachine;
import statemachine.trophysystem.ITrophySystem;
import statemachine.trophysystem.TrophySystemAbstractFactory;

public class TrophySystemState implements ITransition{

    StateMachine stateMachine;
    ILeagueModel leagueModel;
    ITrophySystem trophySystem = TrophySystemAbstractFactory.instance().createTrophySystem();
    final static Logger logger = Logger.getLogger(TrophySystemState.class);
    int year;

    public TrophySystemState(StateMachine stateMachine) {
        logger.info("Initializing TrophySystemState State");
        this.stateMachine = stateMachine;
    }

    public  void updateTrophyStateValue(StateMachine stateMachine, ILeagueModel leagueModel,int year){
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
        this.year = year;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }
    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        trophySystem.awardWinners();
    }


    public void exit() {
        TrophySystemAbstractFactory.instance().setTrophySystem(null);
    }
}
