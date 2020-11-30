package statemachine.states.statemachine.states;


import cli.CliAbstractFactory;
import cli.ICli;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import statemachine.loadteam.ILoadTeam;
import statemachine.loadteam.LoadTeamAbstractFactory;
import statemachine.states.statemachine.StateMachine;

public class LoadTeamState implements ITransition {
    StateMachine stateMachine;
    ILeagueModel currentLeague;
    ILoadTeam parser;
    ICli cli;

    public LoadTeamState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        currentLeague = LeagueObjectModelAbstractFactory.getInstance().getLeague();
        cli = CliAbstractFactory.getInstance().getCli();
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void entry() throws Exception {
        task();
    }

    @Override

    public void task() throws Exception {
        parser = LoadTeamAbstractFactory.instance().createLoadTeam();
        currentLeague = parser.getData();
        if (currentLeague == null){
            task();
        }
        else {
            exit();
        }
    }

    @Override
    public void exit() throws Exception {
        cli.printOutput(currentLeague.getLeagueName());
        stateMachine.getUpdateStateValue().updatePlayerSeasonChoiceStateValue(stateMachine,currentLeague);
        stateMachine.setCurrentState(stateMachine.teamLoaded());
        stateMachine.getCurrentState().entry();
    }
}
