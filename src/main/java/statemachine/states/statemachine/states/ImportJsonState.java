package statemachine.states.statemachine.states;


import leagueobjectmodel.*;
import org.apache.log4j.Logger;
import statemachine.states.statemachine.StateMachine;
import statemachine.jsonparser.IParser;
import statemachine.jsonparser.ParserAbstractFactory;

public class ImportJsonState implements ITransition {
    StateMachine stateMachine;
    IParser parser;
    ITransition createTeamState;
    private String cliArgument;
    private ILeagueModel inMemoryLeagueModel;
    final static Logger logger = Logger.getLogger(ImportJsonState.class);

    public ImportJsonState(StateMachine currentStateMachine) {
        stateMachine = currentStateMachine;
        parser = ParserAbstractFactory.getInstance().getParser();
    }

    public void updateImportJsonStateValue(String[] args, StateMachine currentStateMachine){
        if(currentStateMachine==null){
            logger.error("State machine object is not initialized in the import json state");
            throw new NullPointerException("StateMachine Object is not Initialized in the import json state");
        }
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
            logger.info("User has not provided any argument in the path");
            stateMachine.setCurrentState(stateMachine.playerChoiceLoadTeam());
            exit();
        } else {
            logger.info("user has provided argument in the path");
            inMemoryLeagueModel = parser.parseJson(cliArgument);
            if(inMemoryLeagueModel==null){
                throw new NullPointerException("Error while parsing the in Memory League Object");
            }
            LeagueObjectModelAbstractFactory.getInstance().setLeague(inMemoryLeagueModel);
            int teamCount=0;
            for (IConferenceModel conferenceModel : inMemoryLeagueModel.getConferences()) {
                for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                    for (ITeamsModel teamsModel : divisonModel.getTeams()) {
                        teamCount++;
                        teamsModel.calculateTeamStrength(teamsModel);
                        for (IPlayerModel playerModel : teamsModel.getPlayers()) {
                            playerModel.calculatePlayerStrength(playerModel);
                        }
                    }
                }
            }
            //System.out.println("total team are" +teamCount);
            task();
        }
    }

    @Override
    public void task() {
        createTeamState = stateMachine.getCreateTeam();
        if(createTeamState==null){
            logger.info("inside the task method of the Import json and the create team state is not initialized");
            throw new NullPointerException("inside the task method of the Import json and the create team state is not initialized.");
        }
        stateMachine.setCreateTeam(createTeamState);
        stateMachine.getUpdateStateValue().updateCreateTeamStateValue(stateMachine);
        stateMachine.setCurrentState(stateMachine.getCreateTeam());
        exit();
    }

    @Override
    public void exit() {
        stateMachine.getCurrentState().entry();
    }
}
