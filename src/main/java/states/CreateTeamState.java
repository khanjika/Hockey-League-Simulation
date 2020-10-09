package states;

import cli.CreateTeamCli;
import league.ILeagueModel;
import league.LeagueModel;
import statemachine.StateMachine;

public class CreateTeamState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentModel;
    CreateTeamCli createTeamCli ;
    LeagueModel updatedLeagueModel;
    ILeagueModel iLeagueModel;

    public CreateTeamState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public CreateTeamState(LeagueModel leagueModel){
        System.out.println("Constructor of create team is created");
        iLeagueModel = new LeagueModel();
        createTeamCli =new CreateTeamCli();
        this.currentModel = leagueModel;
        System.out.println("Hello:"+this.currentModel.getLeagueName());
        System.out.println(this);
    }


    public CreateTeamState() {
        System.out.println("Empty constructor");
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
        System.out.println(this);
        System.out.println("prompt for new team data");
        System.out.println(currentModel.getLeagueName());
        task();
    }

    @Override
    public void task() {
        System.out.println("Inside the task method of create team state");
      this.updatedLeagueModel= createTeamCli.createNewTeam(currentModel);
        exit();
    }

    @Override
    public void exit() {
        System.out.println("persist data");
        //This method will start a chain to store the database
        iLeagueModel.storeLeagueInformation(updatedLeagueModel);
            System.out.println("Your data have been successfully stored in the database");
            stateMachine.setCurrentState(stateMachine.newTeamCreated());
            //I WILL BE USING THIS FOR THE TRANSITION.
          //  stateMachine.getCurrentState().entry();
//        }
//        else {
//            System.out.println("Sorry error occured");
//        }

    }
}
