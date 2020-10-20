package states;

import cli.InitialCli;
import league.LeagueModel;
import matchSchedules.IRegularSeasonSchedule;
import matchSchedules.RegularSeasonSchedule;
import statemachine.StateMachine;

public class ImportJsonState implements ITransition {
    StateMachine stateMachine;
    InitialCli initialCli;
    private boolean userInput;
    private String cliArgument;
    private LeagueModel inMemoryLeagueModel;
    CreateTeamState createTeamState;

    public ImportJsonState(StateMachine currentStateMachine) {
        stateMachine = currentStateMachine;
    }

    public ImportJsonState(String[] args, StateMachine currentStateMachine) {
        if (args.length == 0) {
            cliArgument = null;
        } else {
            cliArgument = args[0];
        }
        initialCli = new InitialCli();
        stateMachine = currentStateMachine;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void entry() {
        if (cliArgument == null) {
            stateMachine.setCurrentState(stateMachine.playerChoiceLoadTeam());
            exit();
        } else {
            inMemoryLeagueModel = initialCli.parseJson(cliArgument);
            task();
        }
    }

    @Override
    public void task() {
        createTeamState = new CreateTeamState(inMemoryLeagueModel, stateMachine);
        stateMachine.setCreateTeam(createTeamState);
        stateMachine.setCurrentState(stateMachine.playerChoiceCreateTeam());
        exit();
    }

    @Override
    public void exit() {
        stateMachine.getCurrentState().entry();
    }
}
