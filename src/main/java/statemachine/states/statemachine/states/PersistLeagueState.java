package statemachine.states.statemachine.states;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import statemachine.states.statemachine.StateMachine;

public class PersistLeagueState implements ITransition {


    StateMachine stateMachine;
    ILeagueModel currentLeagueModel;
    ILeagueModel leagueModel;
    private int currentYear;

    public PersistLeagueState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        leagueModel = LeagueObjectModelAbstractFactory.getInstance().getLeague();
    }

    public void updatePersistLeagueStateValue(ILeagueModel leagueModel, StateMachine stateMachine, int year){
        this.stateMachine = stateMachine;
        this.currentLeagueModel = leagueModel;
        currentYear = year;
    }
    @Override
    public void entry() {
        System.out.println("Please wait we are storing data in the database..........");
        task();
    }

    @Override
    public void task() {
        leagueModel.storeLeagueInformation(currentLeagueModel);
    }

    @Override
    public void exit() throws Exception {
        stateMachine.getCurrentState().entry();
    }
}
