package states;

import league.LeagueModel;
import statemachine.StateMachine;
import states.ITransition;

import java.util.Scanner;

public class PlayerSeasonsChoiceState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentModel;
    Integer enteredInput;

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

    public Integer getEnteredInput() {
        return enteredInput;
    }

    public void setEnteredInput(Integer enteredInput) {
        this.enteredInput = enteredInput;
    }

    @Override
    public void task() {

        System.out.println("Enter Number of season you want to simulate");
        Scanner scannerObject =new Scanner(System.in);
        setEnteredInput(scannerObject.nextInt());
        System.out.println("You have entered "+enteredInput);
        exit();

    }

    @Override
    public void exit() {
        stateMachine.setCurrentState(stateMachine.simulateSeasons());
        stateMachine.getCurrentState().entry();
    }
}

