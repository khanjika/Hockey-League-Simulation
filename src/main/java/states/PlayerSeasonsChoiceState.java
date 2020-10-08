package states;

import league.LeagueModel;
import statemachine.StateMachine;
import states.ITransition;

public class PlayerSeasonsChoiceState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentModel;

    public PlayerSeasonsChoiceState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }
    public PlayerSeasonsChoiceState(LeagueModel leagueModel){this.currentModel = leagueModel;}

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public LeagueModel getCurrentModel() {
        return currentModel;
    }

    public void setCurrentModel(LeagueModel currentModel) {
        this.currentModel = currentModel;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void entry() {
        System.out.println("Output choice to user");
    }

    @Override
    public void task() {
        System.out.println("Wait for input");
    }

    @Override
    public void exit() {
        System.out.println("Transition to choice");
        // get choice from user and pass as parameter
        stateMachine.setCurrentState(stateMachine.simulateSeasons());
    }
}

