package statemachine.states;

import statemachine.jsonparser.IInitCli;
import statemachine.jsonparser.InitialCli;
import leagueobjectmodel.*;
import statemachine.StateMachine;

public class ImportJsonState implements ITransition {
    StateMachine stateMachine;
    IInitCli initialCli;
    ITransition createTeamState;
    private String cliArgument;
    private ILeagueModel inMemoryLeagueModel;

    public ImportJsonState(StateMachine currentStateMachine) {
        stateMachine = currentStateMachine;

        initialCli = new InitialCli();
    }
    public ImportJsonState(String[] args, StateMachine currentStateMachine) {
        if (args.length == 0) {
            cliArgument = null;
        } else {
            cliArgument = args[0];
        }
        stateMachine = currentStateMachine;
    }

    public void updateImportJsonStateValue(String[] args, StateMachine currentStateMachine){
        if (args.length == 0) {
            cliArgument = null;
        } else {
            cliArgument = args[0];
        }
        stateMachine = currentStateMachine;

    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void entry() {
        if (cliArgument == null) {
            stateMachine.setCurrentState(stateMachine.playerChoiceLoadTeam());
            exit();
        } else {
            inMemoryLeagueModel = initialCli.parseJson(cliArgument);
            if(inMemoryLeagueModel==null){
                throw new RuntimeException("Error while parsing the in Memory Legaue Model");
            }
            for (ConferenceModel conferenceModel : inMemoryLeagueModel.getConferences()) {
                for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                    for (TeamsModel teamsModel : divisonModel.getTeams()) {
                        teamsModel.calculateTeamStrength(teamsModel);
                        for (PlayerModel playerModel : teamsModel.getPlayers()) {
                            playerModel.calculatePlayerStrength(playerModel);
                        }
                    }
                }
            }
            task();
        }
    }

    @Override
    public void task() {
        createTeamState = stateMachine.getCreateTeam();
        stateMachine.setCreateTeam(createTeamState);
        stateMachine.getUpdateStateValue().updateCreateTeamStateValue(stateMachine,inMemoryLeagueModel);
        stateMachine.setCurrentState(stateMachine.getCreateTeam());
        exit();
    }

    @Override
    public void exit() {
        stateMachine.getCurrentState().entry();
    }
}
