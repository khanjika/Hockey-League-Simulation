package statemachine.states;

import statemachine.jsonparser.IParser;
import statemachine.jsonparser.Parser;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import statemachine.StateMachine;
import statemachine.jsonparser.ParserAbstractFactory;

public class LoadTeamState implements ITransition {
    StateMachine stateMachine;
    ILeagueModel currentLeague;
    IParser parser;

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
        parser = ParserAbstractFactory.getInstance().getParser();
        currentLeague = parser.loadTeamFromDatabase();
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
