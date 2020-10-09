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
    CreateTeamState createTeamState;


    public ImportJsonState() {
        System.out.println("constructor of import json created");

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
        initialCli = new InitialCli();
        userInput=  initialCli.initializedCommunication();
        task();
    }

    @Override
    public void task() {
        System.out.println(userInput);
        System.out.println("instantiate and configure league model");
        if(userInput.equalsIgnoreCase("yes")){
            System.out.println("YES input");
            InitialCli initialCli01 =new InitialCli();
            LeagueModel leagueModel = initialCli01.parseJson();
            createTeamState = new CreateTeamState(leagueModel);
            stateMachine.setCreateTeam(createTeamState);
            System.out.println("Going to Create Team state");
            stateMachine.setCurrentState(stateMachine.playerChoiceCreateTeam());
        }
        else if(userInput.equalsIgnoreCase("no")){
            //cliCommunication.loadTeamFromDatabase();
            stateMachine.setCurrentState(stateMachine.playerChoiceLoadTeam());

        }
        else {
            System.out.println(this.userInput);
            System.out.println("Enter YES or NO");

        }

        exit();
    }

    @Override
    public void exit() {
        stateMachine.getCurrentState().entry();
    }
}
