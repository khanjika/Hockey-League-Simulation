package statemachine.states.updateStateValue;

import league.LeagueModel;

import statemachine.StateMachine;
import teams.TeamsModel;

public interface IUpdateStateValue {
    void updateImportJsonStateValue(StateMachine stateMachine,String[] userArgument);

    void updateCreateTeamStateValue(StateMachine stateMachine, LeagueModel leagueModel);

    void updatePlayerSeasonChoiceStateValue(StateMachine stateMachine, LeagueModel leagueModel);

    void updateInitializeSeasonStateValue(StateMachine stateMachine,LeagueModel leagueModel, int year);

    void updateTrainingSateValue(StateMachine stateMachine,LeagueModel leagueModel);

    void updateSimulateGameStateValue(StateMachine stateMachine, LeagueModel leagueModel, TeamsModel teamOne,TeamsModel teamTwo,boolean isPlayOff);

    void updateTradingStateValue(StateMachine stateMachine, LeagueModel leagueModel);

    void updateAgingStateValue(StateMachine stateMachine, LeagueModel leagueModel);

    void updateInjuryCheckStateValue(StateMachine stateMachine, LeagueModel leagueModel, TeamsModel teamsModel);

    void updatePersistStateValue(LeagueModel leagueModel, StateMachine stateMachine, int year);
}

