package statemachine.states;

import statemachine.jsonparser.CliCommunication;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import statemachine.StateMachine;

public class LoadTeamState implements ITransition {
    StateMachine stateMachine;
    ILeagueModel currentLeague;
    CliCommunication cliCommunication;

    public LoadTeamState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        currentLeague = LeagueObjectModelAbstractFactory.getInstance().getLeague();
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
        cliCommunication = new CliCommunication();
        currentLeague = cliCommunication.loadTeamFromDatabase();
        if (currentLeague == null){
            task();
        }
        else {
            exit();
        }
    }

    @Override
    public void exit() {
        System.out.println(currentLeague.getLeagueName());
        stateMachine.getUpdateStateValue().updatePlayerSeasonChoiceStateValue(stateMachine,currentLeague);
        stateMachine.setCurrentState(stateMachine.teamLoaded());
        stateMachine.getCurrentState().entry();
    }
}
