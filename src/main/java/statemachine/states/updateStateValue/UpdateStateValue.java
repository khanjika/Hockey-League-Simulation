package statemachine.states.updateStateValue;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.LeagueModel;
import statemachine.StateMachine;
import statemachine.states.*;
import leagueobjectmodel.TeamsModel;

public class UpdateStateValue implements IUpdateStateValue{

    @Override
    public void updateImportJsonStateValue(StateMachine stateMachine, String[] userArgument) {
        ((ImportJsonState)(stateMachine.getImportJson())).updateImportJsonStateValue(userArgument,stateMachine);
    }

    @Override
    public void updateCreateTeamStateValue(StateMachine stateMachine, ILeagueModel leagueModel) {
        ((CreateTeamState)(stateMachine.getCreateTeam())).updateCreateTeamStateValue(leagueModel, stateMachine);
    }

    @Override
    public void updatePlayerSeasonChoiceStateValue(StateMachine stateMachine, ILeagueModel leagueModel) {
        ((PlayerSeasonsChoiceState)(stateMachine.getPlayerSeasonsChoice())).updatePlayerSeasonChoiceStateValue(leagueModel, stateMachine);
    }

    @Override
    public void updateInitializeSeasonStateValue(StateMachine stateMachine, ILeagueModel leagueModel, int year) {
        ((InitializeSeasonState)(stateMachine.getInitlailizeSeasonState())).updateInitializeSeasonStateValue(stateMachine, leagueModel, year);
    }

    @Override
    public void updateTrainingSateValue(StateMachine stateMachine, ILeagueModel leagueModel) {
        ((TrainingState)(stateMachine.getTrainingState())).updateTrainingStateValue(stateMachine, leagueModel);
    }

    @Override
    public void updateSimulateGameStateValue(StateMachine stateMachine, ILeagueModel leagueModel, ITeamsModel teamOne, ITeamsModel teamTwo) {
        ((SimulateGameState)stateMachine.getSimulateGameState()).updateSimulateGameStateValue(stateMachine, leagueModel, teamOne, teamTwo);
    }

    @Override
    public void updateTradingStateValue(StateMachine stateMachine, ILeagueModel leagueModel) {
        ((TradingState)stateMachine.getTradingState()).updateTradingStateValue(stateMachine, leagueModel);
    }

    @Override
    public void updateAgingStateValue(StateMachine stateMachine, ILeagueModel leagueModel) {
        ((AgingState)stateMachine.getAgingState()).updateAgingStateValue(stateMachine, leagueModel);
    }

    @Override
    public void updateInjuryCheckStateValue(StateMachine stateMachine, ILeagueModel leagueModel, ITeamsModel teamsModel) {
        ((InjuryCheckState)stateMachine.getInjuryCheckState()).updateInjuryCheckStateValue(stateMachine, leagueModel, teamsModel);
    }

    @Override
    public void updatePersistStateValue(ILeagueModel leagueModel, StateMachine stateMachine, int year) {
        ((PersistLeagueState)stateMachine.getPersistLeagueState()).updatePersistLeagueStateValue(leagueModel, stateMachine, year);
    }
}
