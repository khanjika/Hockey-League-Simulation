package statemachine.states;

import statemachine.createteam.CreateTeamCli;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import statemachine.StateMachine;

public class CreateTeamState implements ITransition {
    StateMachine stateMachine;
    ILeagueModel currentModel;
    CreateTeamCli createTeamCli;

    ILeagueModel updatedLeagueModel;
    PlayerSeasonsChoiceState playerSeasonsChoiceState;

    public CreateTeamState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

//    public CreateTeamState(LeagueModel leagueModel, StateMachine stateMachine) {
//        iLeagueModel = new LeagueModel();
//        createTeamCli = new CreateTeamCli();
//        this.currentModel = leagueModel;
//        this.stateMachine = stateMachine;
//    }

    public void updateCreateTeamStateValue(ILeagueModel leagueModel, StateMachine stateMachine){
        createTeamCli = new CreateTeamCli();
        this.currentModel = LeagueObjectModelAbstractFactory.getInstance().getLeague();
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
    public void entry() {
        task();
    }

    @Override
    public void task() {
        this.updatedLeagueModel = createTeamCli.createNewTeam(currentModel);
     //   PlayoffSchedule playoffSchedule = new PlayoffSchedule();
       // playoffSchedule.generatePlayoffSchedule(updatedLeagueModel);
        if (this.updatedLeagueModel == null){
            System.out.println("Team already exists");
            task();
        }
        exit();
    }

    @Override
    public void exit() {
        //THIS IS USED FOR SERIALIZTION PUROPOSE
      //SerializeObject serializeObject = new SerializeObject();
        //serializeObject.serializeLeagueObject(this.updatedLeagueModel);
        stateMachine.getUpdateStateValue().updatePlayerSeasonChoiceStateValue(stateMachine,updatedLeagueModel);
        stateMachine.setCurrentState(stateMachine.getPlayerSeasonsChoice());
        stateMachine.getCurrentState().entry();
    }

}

