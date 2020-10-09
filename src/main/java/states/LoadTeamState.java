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
        System.out.println("Load team state object created");
        this.stateMachine = stateMachine;

    }

    public LoadTeamState(LeagueModel leagueModel) {
        System.out.println("Load team state object created with league model");
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
        System.out.println("Inside the LoadTeam state");
        task();
    }

    @Override
    public void task() {
        System.out.println("load team data");
        cliCommunication = new CliCommunication();
        if(cliCommunication.loadTeamFromDatabase())
        {
            //HERE in true need to do some work
            exit();
        }
        else{
            //IT migh have caugh problem..EXIT from the DB
        }

    }

    @Override
    public void exit() {

        stateMachine.setCurrentState(stateMachine.teamLoaded());
        stateMachine.getCurrentState().entry();
    }
}
