package statemachine.states.statemachine.states;

import cli.CliAbstractFactory;
import cli.ICli;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import statemachine.states.statemachine.StateMachine;

public class PersistLeagueState implements ITransition {


    StateMachine stateMachine;
    ILeagueModel currentLeagueModel;
    ILeagueModel leagueModel;
    ICli cli;
    private int currentYear;

    public PersistLeagueState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        leagueModel = LeagueObjectModelAbstractFactory.getInstance().getLeague();
        cli = CliAbstractFactory.getInstance().getCli();
    }

    public void updatePersistLeagueStateValue(ILeagueModel leagueModel, StateMachine stateMachine, int year){
        this.stateMachine = stateMachine;
        this.currentLeagueModel = leagueModel;
        currentYear = year;
    }
    @Override
    public void entry() {
        cli.printOutput("Please wait we are storing data to the JSON file..........");
        task();
    }

    @Override
    public void task() {
        leagueModel.storeLeagueInformation(currentLeagueModel);
    }

    @Override
    public void exit() {
        cli.printOutput("Data stored successfully to the JSON file");
        LeagueObjectModelAbstractFactory.getInstance().setLeague(null);
    }
}
