package states;

import cli.CreateTeamCli;
import conference.ConferenceModel;
import divison.DivisonModel;
import league.ILeagueModel;
import league.LeagueModel;
import matchSchedules.PlayoffSchedule;
import statemachine.StateMachine;
import teams.TeamsModel;

public class CreateTeamState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentModel;
    CreateTeamCli createTeamCli;
    LeagueModel updatedLeagueModel;
    PlayerSeasonsChoiceState playerSeasonsChoiceState;
    ILeagueModel iLeagueModel;
    PersistLeagueState persistLeagueState;

    public CreateTeamState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public CreateTeamState(LeagueModel leagueModel,StateMachine stateMachine) {
        iLeagueModel = new LeagueModel();
        createTeamCli = new CreateTeamCli();
        this.currentModel = leagueModel;
        this.stateMachine =stateMachine;
    }


    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public LeagueModel getCurrentModel() {
        return currentModel;
    }

    public void setCurrentModel(LeagueModel currentModel) {
        this.currentModel = currentModel;
    }


    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        this.updatedLeagueModel = createTeamCli.createNewTeam(currentModel);
        PlayoffSchedule playoffSchedule =new PlayoffSchedule();
        playoffSchedule.generatePlayoffSchedule(updatedLeagueModel);
       // exit();
    }

    @Override
    public void exit() {
       // System.out.println("Please Wait, Storing Data in the Database...");
        //here previously i was storing the data in database once the team was created not onve the team is
        //created i need to go to ask number of season simulate.
        if(true){

//        if(iLeagueModel.storeLeagueInformation(updatedLeagueModel)) {
            playerSeasonsChoiceState=new PlayerSeasonsChoiceState(updatedLeagueModel,stateMachine);
            stateMachine.setPlayerSeasonsChoice(playerSeasonsChoiceState);
            stateMachine.setCurrentState(stateMachine.getPlayerSeasonsChoice());
//            persistLeagueState=new PersistLeagueState(updatedLeagueModel,stateMachine);
//            stateMachine.setPersistLeagueStae(persistLeagueState);
//            stateMachine.setCurrentState(stateMachine.getPersistLeagueStae());
            stateMachine.getCurrentState().entry();

        }
        }

    }

