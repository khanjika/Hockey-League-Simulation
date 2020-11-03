package states;

import conference.ConferenceModel;
import divison.DivisonModel;
import league.LeagueModel;
import players.PlayerModel;
import statemachine.StateMachine;
import teams.TeamsModel;
import training.ITraining;
import training.Training;

public class TrainingState implements ITransition {

    StateMachine stateMachine;
    LeagueModel leagueModel;
    ITraining iTraining;

    public TrainingState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public TrainingState(StateMachine stateMachine, LeagueModel leagueModel) {
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
    }

    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        iTraining = new Training();
        iTraining.setInjuriesModel(leagueModel.getGameplayConfig().getInjuries());
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                for (TeamsModel teamsModel : divisonModel.getTeams()) {
                    for (PlayerModel playerModel : teamsModel.getPlayers()) {
                        iTraining.performTraining(playerModel, teamsModel.getHeadCoach(), stateMachine.getCurrentDate());
                    }
                }
            }
        }
    }

    @Override
    public void exit() {
        return;
    }
}
