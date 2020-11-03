package states;

import league.LeagueModel;
import statemachine.StateMachine;
import states.ITransition;

import java.util.Calendar;
import java.util.Scanner;

public class PlayerSeasonsChoiceState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentModel;
    Integer enteredInput;
    ITransition persistLeagueState;
    InitializeSeasonState initializeSeasonState;

    public PlayerSeasonsChoiceState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public PlayerSeasonsChoiceState(LeagueModel leagueModel, StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        this.currentModel = leagueModel;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public Integer getEnteredInput() {
        return enteredInput;
    }

    public void setEnteredInput(Integer enteredInput) {
        this.enteredInput = enteredInput;
    }

    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        System.out.println("Enter Number of season you want to simulate");
        Scanner scannerObject = new Scanner(System.in);
        setEnteredInput(scannerObject.nextInt());
        System.out.println("You have entered " + enteredInput);
        exit();
    }

    @Override
    public void exit() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 0; i < enteredInput; i++) {
            initializeSeasonState = new InitializeSeasonState(stateMachine,currentModel,currentYear+i);
            stateMachine.setInitlailizeSeasonState(initializeSeasonState);
            stateMachine.setCurrentState(stateMachine.getInitlailizeSeasonState());
            stateMachine.getCurrentState().entry();

        }
        persistLeagueState=new PersistLeagueState(currentModel,stateMachine,currentYear);
        stateMachine.setPersistLeagueStae(persistLeagueState);
        stateMachine.setCurrentState(stateMachine.getPersistLeagueState());
        stateMachine.getCurrentState().entry();

    }
}

