package statemachine.states.states;


import database.IDeserializeObject;
import database.SerializeObjectAbstractFactory;
import leagueobjectmodel.*;
import org.apache.log4j.Logger;
import statemachine.states.StateMachine;

public class ImportJsonState implements ITransition {
    StateMachine stateMachine;
    IDeserializeObject parser;
    ITransition createTeamState;
    private String cliArgument;
    private ILeagueModel inMemoryLeagueModel;
    final static Logger logger = Logger.getLogger(ImportJsonState.class);

    public ImportJsonState(StateMachine currentStateMachine) {
        logger.info("Initializing ImportJson State");
        stateMachine = currentStateMachine;
        parser = SerializeObjectAbstractFactory.instance().createParser();
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
    public void entry() throws Exception {
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
            try {
                for (IConferenceModel conferenceModel : inMemoryLeagueModel.getConferences()) {
                    for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                        for (ITeamsModel teamsModel : divisonModel.getTeams()) {
                            teamsModel.calculateTeamStrength(teamsModel);
                            for (IPlayerModel playerModel : teamsModel.getPlayers()) {
                                playerModel.calculatePlayerStrength(playerModel);
                            }
                        }
                    }
                }

            }catch (Exception e){
                logger.error("Error while parsing the league model");
                throw e;
            }
            task();
        }
    }

    @Override
    public void task() throws Exception {
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
    public void exit() throws Exception {
        stateMachine.getCurrentState().entry();
    }
}
