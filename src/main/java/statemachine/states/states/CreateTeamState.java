package statemachine.states.states;

import cli.CliAbstractFactory;
import cli.ICli;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import org.apache.log4j.Logger;
import statemachine.createteam.CreateTeamAbstractFactory;
import statemachine.createteam.ICreateTeam;
import statemachine.states.StateMachine;

public class CreateTeamState implements ITransition {
    StateMachine stateMachine;
    ILeagueModel currentModel;
    ICreateTeam createTeam;
    ILeagueModel updatedLeagueModel;
    final static Logger logger = Logger.getLogger(CreateTeamState.class);
    ICli cli = CliAbstractFactory.getInstance().getCli();
    public CreateTeamState(StateMachine stateMachine) {
        if (stateMachine == null) {
            logger.error("State machine is not intialized in the create Team state");
            throw new NullPointerException("State machine is not intialized in the create Team state");
        }
        logger.info("Initializing CreateTeam State");
        this.stateMachine = stateMachine;
    }

    public void updateCreateTeamStateValue(StateMachine stateMachine) {
        createTeam = CreateTeamAbstractFactory.instance().createCreateTeam();
        this.currentModel = LeagueObjectModelAbstractFactory.getInstance().getLeague();
        if(this.currentModel==null){
            logger.error("Exception while fetching league model object from the abstract factory");
            throw new NullPointerException("Exception while fetching league model object from the abstract factory");
        }
        this.stateMachine = stateMachine;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public ILeagueModel getUpdatedLeagueModel() {
        return updatedLeagueModel;
    }

    public void setUpdatedLeagueModel(LeagueModel updatedLeagueModel) {
        this.updatedLeagueModel = updatedLeagueModel;
    }

    @Override
    public void entry() throws Exception {
        task();
    }

    @Override
    public void task() throws Exception {
        this.updatedLeagueModel = createTeam.createNewTeam(currentModel);
        if (this.updatedLeagueModel == null) {
            cli.printOutput("Team already exists");
            task();
        }
        exit();
    }

    @Override
    public void exit() throws Exception {
        stateMachine.getUpdateStateValue().updatePlayerSeasonChoiceStateValue(stateMachine, updatedLeagueModel);
        if(stateMachine.getPlayerSeasonsChoice()==null){
            throw new NullPointerException("Player season choice state is not initialized properly");
        }
        else {
            stateMachine.setCurrentState(stateMachine.getPlayerSeasonsChoice());
            stateMachine.getCurrentState().entry();
        }
    }

}

