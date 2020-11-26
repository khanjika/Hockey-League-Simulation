package statemachine.states.statemachine.states.updateStateValue;

import leagueobjectmodel.LeagueModel;
import statemachine.states.statemachine.StateMachine;
import statemachine.states.statemachine.states.*;
import leagueobjectmodel.TeamsModel;

public class UpdateStateValue implements IUpdateStateValue{

    @Override
    public void updateImportJsonStateValue(StateMachine stateMachine, String[] userArgument) {
        ((ImportJsonState)(stateMachine.getImportJson())).updateImportJsonStateValue(userArgument,stateMachine);
    }

    @Override
    public void updateCreateTeamStateValue(StateMachine stateMachine, LeagueModel leagueModel) {
        ((CreateTeamState)(stateMachine.getCreateTeam())).updateCreateTeamStateValue(leagueModel, stateMachine);
    }

    @Override
    public void updatePlayerSeasonChoiceStateValue(StateMachine stateMachine, LeagueModel leagueModel) {
        ((PlayerSeasonsChoiceState)(stateMachine.getPlayerSeasonsChoice())).updatePlayerSeasonChoiceStateValue(leagueModel, stateMachine);
    }

    @Override
    public void updateInitializeSeasonStateValue(StateMachine stateMachine, LeagueModel leagueModel, int year) {
        ((InitializeSeasonState)(stateMachine.getInitlailizeSeasonState())).updateInitializeSeasonStateValue(stateMachine, leagueModel, year);
    }

    @Override
    public void updateTrainingSateValue(StateMachine stateMachine, LeagueModel leagueModel) {
        ((TrainingState)(stateMachine.getTrainingState())).updateTrainingStateValue(stateMachine, leagueModel);
    }

    @Override
    public void updateSimulateGameStateValue(StateMachine stateMachine, LeagueModel leagueModel, TeamsModel teamOne, TeamsModel teamTwo,boolean isPlayOff) {
        ((SimulateGameState)stateMachine.getSimulateGameState()).updateSimulateGameStateValue(stateMachine, leagueModel, teamOne, teamTwo,isPlayOff);
    }

    @Override
    public void updateTradingStateValue(StateMachine stateMachine, LeagueModel leagueModel) {
        ((TradingState)stateMachine.getTradingState()).updateTradingStateValue(stateMachine, leagueModel);
    }

    @Override
    public void updateAgingStateValue(StateMachine stateMachine, LeagueModel leagueModel) {
        ((AgingState)stateMachine.getAgingState()).updateAgingStateValue(stateMachine, leagueModel);
    }

    @Override
    public void updateInjuryCheckStateValue(StateMachine stateMachine, LeagueModel leagueModel, TeamsModel teamsModel) {
        ((InjuryCheckState)stateMachine.getInjuryCheckState()).updateInjuryCheckStateValue(stateMachine, leagueModel, teamsModel);
    }

//    @Override
//    public void updatePersistStateValue(LeagueModel leagueModel, StateMachine stateMachine, int year) {
//        ((PersistLeagueState)stateMachine.getPersistLeagueState()).updatePersistLeagueStateValue(leagueModel, stateMachine, year);
//    }
}
