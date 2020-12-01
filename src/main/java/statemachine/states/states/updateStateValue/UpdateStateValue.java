package statemachine.states.states.updateStateValue;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import statemachine.states.StateMachine;
import statemachine.states.states.*;

public class UpdateStateValue implements IUpdateStateValue{

    @Override
    public void updateImportJsonStateValue(StateMachine stateMachine, String[] userArgument) {
        ((ImportJsonState)(stateMachine.getImportJson())).updateImportJsonStateValue(userArgument,stateMachine);
    }

    @Override
    public void updateCreateTeamStateValue(StateMachine stateMachine) {
        ((CreateTeamState)(stateMachine.getCreateTeam())).updateCreateTeamStateValue(stateMachine);
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

    public void updateSimulateGameStateValue(StateMachine stateMachine, ILeagueModel leagueModel, ITeamsModel teamOne, ITeamsModel teamTwo,boolean isPlayOff) {
        ((SimulateGameState)stateMachine.getSimulateGameState()).updateSimulateGameStateValue(stateMachine, leagueModel, teamOne, teamTwo,isPlayOff);
    }

    @Override
    public void updateTradingStateValue(StateMachine stateMachine, ILeagueModel leagueModel) {
        ((TradingState)stateMachine.getTradingState()).updateTradingStateValue(stateMachine, leagueModel);
    }

    @Override
    public void updateAgingStateValue(StateMachine stateMachine, ILeagueModel leagueModel) throws Exception {
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

    @Override
    public void updateTrophyStateValue(ILeagueModel leagueModel, StateMachine stateMachine, int year){
        ((TrophySystemState)stateMachine.getTrophySystemState()).updateTrophyStateValue(stateMachine,leagueModel, year);
    }
}
