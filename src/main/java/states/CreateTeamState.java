package states;

import league.LeagueModel;
import statemachine.StateMachine;

public class CreateTeamState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentModel;

    public CreateTeamState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public CreateTeamState(LeagueModel leagueModel){
        this.currentModel = leagueModel;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public LeagueModel getCurrentModel() {
        return currentModel;
    }

    public void setCurrentModel(LeagueModel currentModel) {
        this.currentModel = currentModel;
    }


    @Override
    public void entry() {
        System.out.println("prompt for team data");
        System.out.println(currentModel.getConferences());
        task();
    }

    @Override
    public void task() {
        System.out.println("instantiate league model");
        exit();
    }

    @Override
    public void exit() {
        System.out.println("persist data");
        stateMachine.setCurrentState(stateMachine.newTeamCreated());
        stateMachine.getCurrentState().entry();
    }
}
