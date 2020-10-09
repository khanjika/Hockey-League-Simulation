package states;

import cli.CliCommunication;
import cli.ICliCommunication;
import cli.InitialCli;
import league.LeagueModel;
import statemachine.StateMachine;

public class ImportJsonState implements ITransition {
    StateMachine stateMachine;
    private static ICliCommunication cliCommunication;
    String userInput;
    InitialCli initialCli;
    CreateTeamState createTeamState;


    public ImportJsonState() {

        cliCommunication = new CliCommunication();
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
        initialCli = new InitialCli();
        userInput = initialCli.initializedCommunication();
        task();
    }

    @Override
    public void task() {
        if (userInput.equalsIgnoreCase("yes")) {
            InitialCli initialCli01 = new InitialCli();
            LeagueModel leagueModel = initialCli01.parseJson();
            if(leagueModel==null){

            }
            else {
                createTeamState = new CreateTeamState(leagueModel,stateMachine);
                stateMachine.setCreateTeam(createTeamState);
                stateMachine.setCurrentState(stateMachine.playerChoiceCreateTeam());
                exit();
            }

        } else if (userInput.equalsIgnoreCase("no")) {
            stateMachine.setCurrentState(stateMachine.playerChoiceLoadTeam());
            exit();

        } else {
            System.out.println(this.userInput);
            System.out.println("Enter YES or NO");
            exit();
        }
    }

    @Override
    public void exit() {
        stateMachine.getCurrentState().entry();
    }
}
