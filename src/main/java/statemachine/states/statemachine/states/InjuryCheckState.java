package statemachine.states.statemachine.states;

import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.IPlayerModel;
import leagueobjectmodel.PlayerModel;
import statemachine.states.statemachine.StateMachine;
import leagueobjectmodel.*;
import java.time.LocalDate;

public class InjuryCheckState implements ITransition {
    StateMachine stateMachine;
    ILeagueModel leagueModel;
    ITeamsModel teamsModelTemp;
    LocalDate currentDate;
    IPlayerModel playerModel;

    public InjuryCheckState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

//    public InjuryCheckState(StateMachine stateMachine, LeagueModel leagueModel, TeamsModel teamsModel) {
//
//        this.stateMachine = stateMachine;
//        this.leagueModel = leagueModel;
//        this.teamsModelTemp = teamsModel;
//        currentDate = stateMachine.getCurrentDate();
//    }

    public void updateInjuryCheckStateValue(StateMachine stateMachine, ILeagueModel leagueModel, ITeamsModel teamsModel){
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
        this.teamsModelTemp = teamsModel;
        currentDate = stateMachine.getCurrentDate();
    }

    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        playerModel = new PlayerModel();
        playerModel.setInjuriesModel(leagueModel.getGameplayConfig().getInjuries());
        for (PlayerModel playerModel : teamsModelTemp.getPlayers()) {
            playerModel.setInjuriesModel(leagueModel.getGameplayConfig().getInjuries());
            playerModel.checkPlayerInjury(playerModel, currentDate);
            teamsModelTemp.roasterReplacement(playerModel);
        }
    }

    @Override
    public void exit() {
    }
}
