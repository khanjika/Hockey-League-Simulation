package statemachine.training;

import leagueobjectmodel.HeadCoachModel;
import leagueobjectmodel.IInjuriesModel;
import leagueobjectmodel.IPlayerModel;
import org.apache.log4j.Logger;

import java.time.LocalDate;

public class Training implements ITraining {

    private static LocalDate currentDate;
    private IInjuriesModel currentInjuriesModel;
    final static Logger logger = Logger.getLogger(Training.class);
    @Override
    public void performTraining(IPlayerModel player, HeadCoachModel headCoach, LocalDate currentDate) {
        if(player == null || headCoach == null || currentDate == null){
            logger.error(TrainingConstants.LoggerTrainingError.getValue());
            throw new NullPointerException(TrainingConstants.ExceptionError.getValue());
        }
        logger.info(TrainingConstants.LoggerTrainingInfo.getValue());

        Training.currentDate = currentDate;
        boolean isPlayerInjured = false;
        if (headCoach.getChecking() > Math.random()) {
            player.setChecking(player.getChecking() + 1);
        } else {
            if (checkForInjury(player)) {
                isPlayerInjured = true;
            }
        }
        if (headCoach.getSaving() > Math.random()) {
            player.setSaving(player.getSaving() + 1);
        } else {
            if (checkForInjury(player)) {
                isPlayerInjured = true;
            }
        }
        if (headCoach.getShooting() > Math.random()) {
            player.setShooting(player.getShooting() + 1);
        } else {
            if (checkForInjury(player)) {
                isPlayerInjured = true;
            }
        }
        if (headCoach.getSkating() > Math.random()) {
            player.setSkating(player.getSkating() + 1);
        } else {
            if (checkForInjury(player)) {
                isPlayerInjured = true;
            }
        }
        if (isPlayerInjured) {
            player.setPlayerInjured(true);
            player.calculatePlayerStrength(player);
        }
        else{
            headCoach.setTrainingPlayerPoints(headCoach.getTrainingPlayerPoints() + 1);
        }
    }

    @Override
    public void setInjuriesModel(IInjuriesModel injuriesModel) {
        currentInjuriesModel = injuriesModel;
    }

    private boolean checkForInjury(IPlayerModel player) {
        player.setInjuriesModel(currentInjuriesModel);
        player.checkPlayerInjury(player, currentDate);
        return player.isPlayerInjured();
    }
}
