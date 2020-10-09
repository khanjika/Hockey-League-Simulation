package states;

import league.LeagueModel;
import statemachine.StateMachine;
import states.ITransition;

import java.util.Scanner;

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

        task();
    }

    @Override
    public void task() {

        System.out.println("Enter Number of season you want to simulate");
        Scanner scannerObject =new Scanner(System.in);
        String enteredInupt = scannerObject.nextLine();
        System.out.println("You have entered "+enteredInupt);
        exit();

    }

    @Override
    public void exit() {
        stateMachine.setCurrentState(stateMachine.simulateSeasons());
        stateMachine.getCurrentState().entry();
    }
}

