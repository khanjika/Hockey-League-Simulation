package states;

import cli.CreateTeamCli;
import league.ILeagueModel;
import league.LeagueModel;
import statemachine.StateMachine;

public class CreateTeamState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentModel;
    CreateTeamCli createTeamCli;
    LeagueModel updatedLeagueModel;
    ILeagueModel iLeagueModel;

    public CreateTeamState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public CreateTeamState(LeagueModel leagueModel) {
        iLeagueModel = new LeagueModel();
        createTeamCli = new CreateTeamCli();
        this.currentModel = leagueModel;
    }


    public CreateTeamState() {

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
        exit();
    }

    @Override
    public void exit() {
        iLeagueModel.storeLeagueInformation(updatedLeagueModel);
        System.out.println("=====================================");
        System.out.println("Your data have been successfully stored in the database");
        System.out.println("=====================================");
        stateMachine.setCurrentState(stateMachine.teamLoaded());
        stateMachine.getCurrentState().entry();
        //I WILL BE USING THIS FOR THE TRANSITION.
        //  stateMachine.getCurrentState().entry();
//        }
//        else {
//            System.out.println("Sorry error occured");
//        }

    }
}
