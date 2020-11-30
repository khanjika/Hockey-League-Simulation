package statemachine.states.statemachine.states;


import cli.CliAbstractFactory;
import cli.ICli;
import leagueobjectmodel.*;
import org.apache.log4j.Logger;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import statemachine.states.statemachine.StateMachine;

import java.util.Calendar;

public class PlayerSeasonsChoiceState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentModel;
    Integer enteredInput;
    ILeagueModel iLeagueModel;
    final static Logger logger = Logger.getLogger(PlayerSeasonsChoiceState.class);
    ICli cli = CliAbstractFactory.getInstance().getCli();

    public PlayerSeasonsChoiceState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

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
    public void entry() throws Exception {
        cli.printOutput("Enter Number of season you want to simulate");
        setEnteredInput(cli.readIntInput());
        cli.printOutput("You have entered " + enteredInput);
        task();
    }

    @Override
    public void task() throws Exception {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 0; i < enteredInput; i++) {
            stateMachine.getUpdateStateValue().updateInitializeSeasonStateValue(stateMachine, currentModel, currentYear + i);
            stateMachine.setCurrentState(stateMachine.getInitlailizeSeasonState());
            stateMachine.getCurrentState().entry();
        }
        exit();
    }


    @Override
    public void exit() {
        try {
            for (ConferenceModel conferenceModel : currentModel.getConferences()) {
                for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                    for (TeamsModel teamsModel : divisonModel.getTeams()) {
                        for (PlayerModel playerModel : teamsModel.getPlayers()) {
                            System.out.println(playerModel.getPlayerName() + " has goal " + playerModel.getGoalScorerCount());
                            if (playerModel.getPosition().equals(PlayerPosition.DEFENSE.toString())) {
                                cli.printOutput(playerModel.getPlayerName() + " is Defense and has penalty count of " + playerModel.getTotalPenaltyCount());
                            }
                            if (playerModel.getPosition().equals(PlayerPosition.GOALIE.toString())) {
                                cli.printOutput(playerModel.getPlayerName() + " is goalie having save count " + playerModel.getSaveForGoalie());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error while parsing the league Object");
            throw e;
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

