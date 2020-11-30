package statemachine.states.statemachine.states;

import leagueobjectmodel.ConferenceModel;
import leagueobjectmodel.DivisonModel;
import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.PlayerModel;
import org.apache.log4j.Logger;
import statemachine.states.statemachine.StateMachine;
import leagueobjectmodel.TeamsModel;
import leagueobjectmodel.*;
import statemachine.training.ITraining;
import statemachine.training.TrainingAbstractFactory;

public class TrainingState implements ITransition {

    StateMachine stateMachine;
    ILeagueModel leagueModel;
    ITraining iTraining;
    final static Logger logger = Logger.getLogger(TrainingState.class);
    public TrainingState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

      public  void updateTrainingStateValue(StateMachine stateMachine, ILeagueModel leagueModel){
        if(stateMachine==null || leagueModel==null){
            logger.error("Statemachine or LeagueModel is not initialized in the training state");
            throw new NullPointerException("Statemachine or LeagueModel is not initialized in the training state");
        }
            this.stateMachine = stateMachine;
            this.leagueModel = leagueModel;
        }
        @Override
        public void entry() {
            task();
        }

        @Override
        public void task() {
            iTraining = TrainingAbstractFactory.getInstance().getTraining();
            iTraining.setInjuriesModel(leagueModel.getGameplayConfig().getInjuries());
            try {
                for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
                    for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                        for (ITeamsModel teamsModel : divisonModel.getTeams()) {
                            for (IPlayerModel playerModel : teamsModel.getPlayers()) {
                                iTraining.performTraining(playerModel, teamsModel.getHeadCoach(), stateMachine.getCurrentDate());
                            }
                        }
                    }
                }
            }
           catch (Exception e){
                logger.error("Error while parsing the leageu Object");
                throw e;
           }
        }

        @Override
        public void exit() { }
}
