package statemachine.states.states;


import cli.CliAbstractFactory;
import cli.ICli;
import leagueobjectmodel.*;
import org.apache.log4j.Logger;
import statemachine.states.StateMachine;

import java.util.Calendar;

public class PlayerSeasonsChoiceState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentModel;
    Integer enteredInput;
    ILeagueModel iLeagueModel;
    final static Logger logger = Logger.getLogger(PlayerSeasonsChoiceState.class);
    ICli cli = CliAbstractFactory.getInstance().getCli();

    public PlayerSeasonsChoiceState(StateMachine stateMachine) {
        logger.info("Initializing PlayerSeasonsChoice State");
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
    public void exit() throws Exception {
        try {
            for (IConferenceModel conferenceModel : currentModel.getConferences()) {
                for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                    for (ITeamsModel teamsModel : divisonModel.getTeams()) {
                        for (PlayerModel playerModel : teamsModel.getPlayers()) {
                            cli.printOutput(playerModel.getPlayerName() + " has goal " + playerModel.getGoalScorerCount());
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
        stateMachine.getUpdateStateValue().updatePersistStateValue(currentModel, stateMachine, 0);
        stateMachine.setCurrentState(stateMachine.getPersistLeagueState());
        stateMachine.getCurrentState().entry();
    }
}

