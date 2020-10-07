package states;

import cli.CliCommunication;
import cli.ICliCommunication;
import cli.InitialCli;
import league.LeagueModel;
import statemachine.StateMachine;

public class ImportJsonState implements ITransition {
    StateMachine stateMachine;
    private  static ICliCommunication cliCommunication;
    String userInput;
    InitialCli initialCli;


    public ImportJsonState() {
        initialCli = new InitialCli();
        cliCommunication =new CliCommunication();
        cliCommunication =new CliCommunication();
    }

    public ImportJsonState(StateMachine newStateMachine) {
        stateMachine = newStateMachine;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void entry() {
        System.out.println("Parse Json Import");
        InitialCli initialCli = new InitialCli();
      userInput=  initialCli.initializedCommunication();
    }

    @Override
    public void task() {
        System.out.println("instantiate and configure league model");
        if(userInput.equalsIgnoreCase("yes")){

            //i need to transit to create team state and i want to pass the below variable.
            LeagueModel leagueModel = initialCli.parseJson();

        }
        else {


            stateMachine.setCurrentState(stateMachine.playerChoiceLoadTeam());
          //  cliCommunication.loadTeamFromDatabase();
        }


    }

    @Override
    public void exit() {

        stateMachine.setCurrentState(stateMachine.fileImported());
    }
}
