package statemachine.states.updateStateValue;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.LeagueModel;

import statemachine.StateMachine;
import leagueobjectmodel.TeamsModel;

public interface IUpdateStateValue {
    void updateImportJsonStateValue(StateMachine stateMachine,String[] userArgument);

    void updateCreateTeamStateValue(StateMachine stateMachine, ILeagueModel leagueModel);

    void updatePlayerSeasonChoiceStateValue(StateMachine stateMachine, ILeagueModel leagueModel);

    void updateInitializeSeasonStateValue(StateMachine stateMachine,ILeagueModel leagueModel, int year);

    void updateTrainingSateValue(StateMachine stateMachine,ILeagueModel leagueModel);

    void updateSimulateGameStateValue(StateMachine stateMachine, ILeagueModel leagueModel, ITeamsModel teamOne,ITeamsModel teamTwo);

    void updateTradingStateValue(StateMachine stateMachine, ILeagueModel leagueModel);

    void updateAgingStateValue(StateMachine stateMachine, ILeagueModel leagueModel);

    void updateInjuryCheckStateValue(StateMachine stateMachine, ILeagueModel leagueModel, ITeamsModel teamsModel);

    void updatePersistStateValue(ILeagueModel leagueModel, StateMachine stateMachine, int year);
}

