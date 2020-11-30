package statemachine.states.statemachine.states;

import cli.CliAbstractFactory;
import cli.ICli;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import org.apache.log4j.Logger;
import statemachine.states.statemachine.StateMachine;

public class PersistLeagueState implements ITransition {


    StateMachine stateMachine;
    ILeagueModel currentLeagueModel;
    ILeagueModel leagueModel;
    private int currentYear;
    ICli cli = CliAbstractFactory.getInstance().getCli();
    final static Logger logger = Logger.getLogger(PersistLeagueState.class);

    public PersistLeagueState(StateMachine stateMachine) {
        logger.info("Initializing PersisteLeague State");
        this.stateMachine = stateMachine;
        leagueModel = LeagueObjectModelAbstractFactory.getInstance().getLeague();
    }

    public void updatePersistLeagueStateValue(ILeagueModel leagueModel, StateMachine stateMachine, int year){
        this.stateMachine = stateMachine;
        this.currentLeagueModel = leagueModel;
        this.currentYear = year;
    }
    @Override
    public void entry() {
        cli.printOutput("Please wait we are storing data in the database..........");
        task();
    }

    @Override
    public void task() {
        leagueModel.storeLeagueInformation(currentLeagueModel);
    }

    @Override
    public void exit() throws Exception {
       // stateMachine.getCurrentState().entry();
    }
}
