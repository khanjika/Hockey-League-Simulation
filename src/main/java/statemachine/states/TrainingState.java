package statemachine.states;

import leagueobjectmodel.*;
import statemachine.StateMachine;
import statemachine.training.ITraining;
import statemachine.training.Training;

public class TrainingState implements ITransition {

    StateMachine stateMachine;
    ILeagueModel leagueModel;
    ITraining iTraining;

    public TrainingState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

  public  void updateTrainingStateValue(StateMachine stateMachine, ILeagueModel leagueModel){
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
