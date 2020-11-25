package statemachine.states;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueModel;
import statemachine.StateMachine;

public class PersistLeagueState implements ITransition {


    StateMachine stateMachine;
    ILeagueModel iLeagueModel;
    private int currentYear;

    public PersistLeagueState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

//    public PersistLeagueState(LeagueModel leagueModel, StateMachine stateMachine, int year) {
//        this.stateMachine = stateMachine;
//        this.leagueModel = leagueModel;
//        currentYear = year;
//        iLeagueModel = new LeagueModel();
//    }

    public void updatePersistLeagueStateValue(ILeagueModel leagueModel, StateMachine stateMachine, int year){
        this.stateMachine = stateMachine;
        this.iLeagueModel = leagueModel;
        currentYear = year;
    }
    @Override
    public void entry() {
        System.out.println("Please wait we are storing data in the database..........");
        task();
    }

    @Override
    public void task() {
//        if(iLeagueModel.storeLeagueInformation(c)){
//            System.out.println("=====================================");
//            System.out.println("Your data have been successfully stored in the database");
//            System.out.println("=====================================");
//            stateMachine.setCurrentState(stateMachine.teamLoaded());
//        } else {
//            System.out.println("=====================================");
//            System.out.println("Error Encountered while storing data in the database");
//            System.out.println("=====================================");
//            System.exit(0);
//        }
    }

    @Override
    public void exit() {
        stateMachine.getCurrentState().entry();
    }
}
