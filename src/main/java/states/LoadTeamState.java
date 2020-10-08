package states;

import league.LeagueModel;
import statemachine.StateMachine;
import states.ITransition;

public class LoadTeamState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentLeague;

    public LoadTeamState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public LoadTeamState(LeagueModel leagueModel){this.currentLeague = leagueModel;}

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
        System.out.println("Prompt for team name");
        task();
    }

    @Override
    public void task() {
        System.out.println("load team data");
        exit();
    }

    @Override
    public void exit() {
        System.out.println("instantiate model objects");
        stateMachine.setCurrentState(stateMachine.teamLoaded());
        stateMachine.getCurrentState().entry();
    }
}
