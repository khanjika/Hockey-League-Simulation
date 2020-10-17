package states;

import league.ILeagueModel;
import league.LeagueModel;
import statemachine.StateMachine;

public class PersistLeagueState implements ITransition{


    StateMachine stateMachine;
    LeagueModel leagueModel;
    ILeagueModel iLeagueModel;
    public PersistLeagueState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public PersistLeagueState(LeagueModel leagueModel, StateMachine stateMachine) {
        this.stateMachine=stateMachine;
        this.leagueModel=leagueModel;
        iLeagueModel=new LeagueModel();
    }

    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        //DO NOT DELETE THE BELOW LINE

        if( iLeagueModel.storeLeagueInformation(leagueModel)){
            System.out.println("=====================================");
            System.out.println("Your data have been successfully stored in the database");
            System.out.println("=====================================");
            stateMachine.setCurrentState(stateMachine.teamLoaded());
        }
        else{
            System.out.println("=====================================");
            System.out.println("Error Encountered while storing data in the database");
            System.out.println("=====================================");
            System.exit(0);
        }
    }

    @Override
    public void exit() {
        stateMachine.getCurrentState().entry();
    }
}
