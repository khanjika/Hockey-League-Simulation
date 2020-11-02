package states;

import cli.CreateTeamCli;
import coach.CoachModel;
import league.ILeagueModel;
import league.LeagueModel;
import matchSchedules.PlayoffSchedule;
import serializeObject.SerializeObject;
import statemachine.StateMachine;

public class CreateTeamState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentModel;
    CreateTeamCli createTeamCli;
    LeagueModel updatedLeagueModel;
    PlayerSeasonsChoiceState playerSeasonsChoiceState;
    ILeagueModel iLeagueModel;

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

    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        System.out.println("Inside task method of create team state");
        this.updatedLeagueModel = createTeamCli.createNewTeam(currentModel);
        PlayoffSchedule playoffSchedule =new PlayoffSchedule();
        playoffSchedule.generatePlayoffSchedule(updatedLeagueModel);
        exit();
    }

    @Override
    public void exit() {
        System.out.println("Inside exit methof of the create team state");
       // System.out.println("Please Wait, Storing Data in the Database...");
        //here previously i was storing the data in database once the team was created not onve the team is
        //created i need to go to ask number of season simulate.
        if(true){

            System.out.println(this.updatedLeagueModel.getFreeAgents().size());
            System.out.println(this.updatedLeagueModel.getCoaches().size());
            for (CoachModel coachModel:this.updatedLeagueModel.getCoaches()){
                System.out.println(coachModel.getName());
            }
            System.out.println(this.updatedLeagueModel.getGeneralManagers().size());
            SerializeObject serializeObject = new SerializeObject();
            serializeObject.serializeLeagueObject(this.updatedLeagueModel);
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

