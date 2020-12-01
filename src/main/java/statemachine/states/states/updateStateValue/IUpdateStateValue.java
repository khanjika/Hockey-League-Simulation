package statemachine.states.states.updateStateValue;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import statemachine.states.StateMachine;

public interface IUpdateStateValue {
    void updateImportJsonStateValue(StateMachine stateMachine, String[] userArgument);

    void updateCreateTeamStateValue(StateMachine stateMachine);

    void updatePlayerSeasonChoiceStateValue(StateMachine stateMachine, ILeagueModel leagueModel);

    void updateInitializeSeasonStateValue(StateMachine stateMachine,ILeagueModel leagueModel, int year);

    void updateTrainingSateValue(StateMachine stateMachine,ILeagueModel leagueModel);

    void updateSimulateGameStateValue(StateMachine stateMachine, ILeagueModel leagueModel, ITeamsModel teamOne, ITeamsModel teamTwo,boolean isPlayOff);

    void updateTradingStateValue(StateMachine stateMachine, ILeagueModel leagueModel);

    void updateAgingStateValue(StateMachine stateMachine, ILeagueModel leagueModel) throws Exception;

    void updateInjuryCheckStateValue(StateMachine stateMachine, ILeagueModel leagueModel, ITeamsModel teamsModel);

    void updatePersistStateValue(ILeagueModel leagueModel, StateMachine stateMachine, int year);

    void updateTrophyStateValue(ILeagueModel leagueModel, StateMachine stateMachine, int year);
}

