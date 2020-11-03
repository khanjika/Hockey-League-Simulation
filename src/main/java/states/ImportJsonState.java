package states;

import cli.IInitCli;
import cli.InitialCli;
import conference.ConferenceModel;
import divison.DivisonModel;
import league.LeagueModel;
import players.PlayerModel;
import statemachine.StateMachine;
import teams.TeamsModel;

public class ImportJsonState implements ITransition {
    StateMachine stateMachine;
    IInitCli initialCli;
    ITransition createTeamState;

    private String cliArgument;
    private LeagueModel inMemoryLeagueModel;

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

            for (ConferenceModel conferenceModel : inMemoryLeagueModel.getConferences()) {
                for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                    for (TeamsModel teamsModel : divisonModel.getTeams()) {
                        teamsModel.calculateTeamStrength(teamsModel);
                        for (PlayerModel playerModel : teamsModel.getPlayers()) {
                            playerModel.calculatePlayerStrength(playerModel);
                        }
                    }
                }
            }
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
