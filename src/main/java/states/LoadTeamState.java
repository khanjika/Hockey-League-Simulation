package states;

import cli.CliCommunication;
import cli.CreateTeamCli;
import league.LeagueModel;
import statemachine.StateMachine;
import states.ITransition;

public class LoadTeamState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentLeague;
    CliCommunication cliCommunication;

    public LoadTeamState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public LoadTeamState(LeagueModel leagueModel) {

        this.currentLeague = leagueModel;
    }

    public LoadTeamState() {
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public LeagueModel getCurrentLeague() {
        return currentLeague;
    }

    public void setCurrentLeague(LeagueModel currentLeague) {
        this.currentLeague = currentLeague;
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
        cliCommunication = new CliCommunication();
        if (cliCommunication.loadTeamFromDatabase()) {
            exit();
        } else {
            System.out.println("Encountered Error while loading Team");
        }

    }

    @Override
    public void exit() {
        stateMachine.setCurrentState(stateMachine.teamLoaded());
        stateMachine.getCurrentState().entry();
    }
}
