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
        exit();
    }

    @Override
    public void exit() {
        System.out.println("Please Wait, Storing Data in the Database...");
        if(true){

//        if(iLeagueModel.storeLeagueInformation(updatedLeagueModel)) {
            persistLeagueState=new PersistLeagueState(updatedLeagueModel,stateMachine);
            stateMachine.setPersistLeagueStae(persistLeagueState);
            stateMachine.setCurrentState(stateMachine.getPersistLeagueStae());
            stateMachine.getCurrentState().entry();
            //THE ABOVE CODE WILL BE USED TO CHANGE THE STATE
//
//            System.out.println("=====================================");
//            System.out.println("Your data have been successfully stored in the database");
//            System.out.println("=====================================");
          //  stateMachine.setCurrentState(stateMachine.teamLoaded());
          //  stateMachine.getCurrentState().entry();
        }
        }
//        else {
//            System.out.println("=====================================");
//            System.out.println("Error Encountered while storing data in the database");
//            System.out.println("=====================================");
//        }

    }

