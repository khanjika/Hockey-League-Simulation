package states;

import league.LeagueModel;
import players.IPlayerModel;
import players.PlayerModel;
import statemachine.StateMachine;
import teams.TeamsModel;

import java.time.LocalDate;

//here first i need to pass two parameter first will be the leageu model object so
// the the placyer can be injured the second will be the teammodel object.
//this thing will be called for both the team model.
//the third argument will be the date at which the player is injured.

public class InjuryCheckState implements ITransition {
    StateMachine stateMachine;
    LeagueModel leagueModel;
    TeamsModel teamsModelTemp;
    LocalDate currentDate;
    IPlayerModel playerModel;

    public InjuryCheckState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public InjuryCheckState(StateMachine stateMachine, LeagueModel leagueModel, TeamsModel teamsModel) {
        //System.out.println("Injury check state constructor "+leagueModel+"      " + stateMachine+"  "+ teamsModel);
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
        this.teamsModelTemp=teamsModel;
        currentDate =stateMachine.getCurrentDate();
    }

    @Override
    public void entry() {
        //System.out.println("Inside Entry Method of Injury Check State");
        task();
    }

    @Override
    public void task() {
        playerModel = new PlayerModel();
        playerModel.setInjuriesModel(leagueModel.getGameplayConfig().getInjuries());
        for (PlayerModel playerModel : teamsModelTemp.getPlayers()) {
            playerModel.setInjuriesModel(leagueModel.getGameplayConfig().getInjuries());
            playerModel.checkPlayerInjury(playerModel, currentDate);
        }
    }

    @Override
    public void exit() {
    }
}
