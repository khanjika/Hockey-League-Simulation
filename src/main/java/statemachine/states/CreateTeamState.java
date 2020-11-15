package statemachine.states;

import cli.CreateTeamCli;
import league.LeagueModel;
import statemachine.StateMachine;

public class CreateTeamState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentModel;
    CreateTeamCli createTeamCli;

    LeagueModel updatedLeagueModel;
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

    public void updateCreateTeamStateValue(LeagueModel leagueModel, StateMachine stateMachine){
        createTeamCli = new CreateTeamCli();
        this.currentModel = leagueModel;
        this.stateMachine = stateMachine;
    }
    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public LeagueModel getUpdatedLeagueModel() {
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
        exit();
    }

    @Override
    public void exit() {
        //THIS IS USED FOR SERIALIZTION PUROPOSE
      //  SerializeObject serializeObject = new SerializeObject();
        //serializeObject.serializeLeagueObject(this.updatedLeagueModel);
        stateMachine.getUpdateStateValue().updatePlayerSeasonChoiceStateValue(stateMachine,updatedLeagueModel);
        stateMachine.setCurrentState(stateMachine.getPlayerSeasonsChoice());
        stateMachine.getCurrentState().entry();
    }

}

