package statemachine.states.statemachine.states;


import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import statemachine.loadteam.ILoadTeam;
import statemachine.loadteam.LoadTeamAbstractFactory;
import statemachine.states.statemachine.StateMachine;

public class LoadTeamState implements ITransition {
    StateMachine stateMachine;
    ILeagueModel currentLeague;
    ILoadTeam parser;

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
        System.out.println(currentLeague.getLeagueName());
        stateMachine.getUpdateStateValue().updatePlayerSeasonChoiceStateValue(stateMachine,currentLeague);
        stateMachine.setCurrentState(stateMachine.teamLoaded());
        stateMachine.getCurrentState().entry();
    }
}
