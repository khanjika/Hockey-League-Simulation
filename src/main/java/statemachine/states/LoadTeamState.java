package statemachine.states;

import cli.CliCommunication;
import leagueobjectmodel.LeagueModel;
import statemachine.StateMachine;

public class LoadTeamState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentLeague;
    CliCommunication cliCommunication;

    public LoadTeamState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
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
//        cliCommunication = new CliCommunication();
//        if (cliCommunication.loadTeamFromDatabase()) {
//            exit();
//        } else {
//            System.out.println("Encountered Error while loading Team");
//        }

    }

    @Override
    public void exit() {
        stateMachine.setCurrentState(stateMachine.teamLoaded());
        stateMachine.getCurrentState().entry();
    }
}
