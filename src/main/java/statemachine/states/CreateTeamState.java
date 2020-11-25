package statemachine.states;

import statemachine.createteam.CreateTeam;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import statemachine.StateMachine;
import statemachine.createteam.CreateTeamAbstractFactory;
import statemachine.createteam.ICreateTeam;

public class CreateTeamState implements ITransition {
    StateMachine stateMachine;
    ILeagueModel currentModel;
    ICreateTeam createTeam;

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
        createTeam = CreateTeamAbstractFactory.getInstance().getCreateTeam();
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
        this.updatedLeagueModel = createTeam.createNewTeam(currentModel);
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

