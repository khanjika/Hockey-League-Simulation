package statemachine.states.statemachine.states;


import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import statemachine.states.statemachine.StateMachine;

import java.util.Calendar;
import java.util.Scanner;

public class PlayerSeasonsChoiceState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentModel;
    Integer enteredInput;
    ILeagueModel iLeagueModel;
    ITransition persistLeagueState;
    InitializeSeasonState initializeSeasonState;

    public PlayerSeasonsChoiceState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    //    public PlayerSeasonsChoiceState(LeagueModel leagueModel, StateMachine stateMachine) {
//        this.stateMachine = stateMachine;
//        this.currentModel = leagueModel;
//    }
//
    public void updatePlayerSeasonChoiceStateValue(ILeagueModel leagueModel, StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        this.currentModel = (LeagueModel) leagueModel;
        iLeagueModel = LeagueObjectModelAbstractFactory.getInstance().getLeague();
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
//            initializeSeasonState = new InitializeSeasonState(stateMachine, currentModel, currentYear + i);
//            stateMachine.setInitiailizeSeasonState(initializeSeasonState);
            stateMachine.getUpdateStateValue().updateInitializeSeasonStateValue(stateMachine, currentModel, currentYear + i);
            stateMachine.setCurrentState(stateMachine.getInitlailizeSeasonState());
            stateMachine.getCurrentState().entry();
        }

        currentModel.getGameplayConfig().getTrading().getGmTable();
//        for (ConferenceModel conferenceModel : currentModel.getConferences()) {
//            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
//                for (TeamsModel teamsModel : divisonModel.getTeams()) {
//                    for (PlayerModel playerModel : teamsModel.getPlayers()) {
//                        System.out.println(playerModel.getPlayerName() + " has goal " + playerModel.getGoalScorerCount());
//                        if (playerModel.getPosition().equals("defense")) {
//                            System.out.println(playerModel.getPlayerName() + " is Defense and has penalty count of " + playerModel.getTotalPenaltyCount());
//                        }
//                        if (playerModel.getPosition().equals("goalie")) {
//                            System.out.println(playerModel.getPlayerName() + " is goalie having save count " + playerModel.getSaveForGoalie());
//                        }
//                    }
//                }
//            }
//        }
        iLeagueModel.storeLeagueInformation(currentModel);
        //This will be used to store the information
//        stateMachine.getUpdateStateValue().updatePersistStateValue(currentModel, stateMachine, currentYear);
//        stateMachine.setPersistLeagueState(persistLeagueState);
//        stateMachine.setCurrentState(stateMachine.getPersistLeagueState());
//        stateMachine.getCurrentState().entry();
    }
}

