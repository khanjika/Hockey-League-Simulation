package statemachine.states.statemachine.states;

import leagueobjectmodel.*;

import statemachine.states.statemachine.StateMachine;
import statemachine.jsonparser.IParser;
import statemachine.jsonparser.ParserAbstractFactory;

public class ImportJsonState implements ITransition {
    StateMachine stateMachine;
    IParser parser;
    ITransition createTeamState;
    private String cliArgument;
    private ILeagueModel inMemoryLeagueModel;

    public ImportJsonState(StateMachine currentStateMachine) {
        stateMachine = currentStateMachine;
        parser = ParserAbstractFactory.getInstance().getParser();
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
            inMemoryLeagueModel = parser.parseJson(cliArgument);
            if(inMemoryLeagueModel==null){
                throw new RuntimeException("Error while parsing the in Memory Legaue Model");
            }
            LeagueObjectModelAbstractFactory.getInstance().setLeague(inMemoryLeagueModel);
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
