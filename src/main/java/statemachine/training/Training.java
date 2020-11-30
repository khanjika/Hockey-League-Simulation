package statemachine.training;

import leagueobjectmodel.IPlayerModel;
import leagueobjectmodel.InjuriesModel;
import leagueobjectmodel.PlayerModel;
import leagueobjectmodel.HeadCoachModel;
import org.apache.log4j.Logger;
import statemachine.states.statemachine.states.InitializeSeasonState;

import java.time.LocalDate;

public class Training implements ITraining {

    TrainingConstants constants = new TrainingConstants();
    private static LocalDate currentDate;
    private InjuriesModel currentInjuriesModel;
    final static Logger logger = Logger.getLogger(Training.class);
    @Override
    public void performTraining(IPlayerModel player, HeadCoachModel headCoach, LocalDate currentDate) {
        Training.currentDate = currentDate;
        boolean isPlayerInjured = false;
        if (headCoach.getChecking() > constants.getRandomNumber()) {
            player.setChecking(player.getChecking() + 1);
        } else {
            if (checkForInjury(player)) {
                isPlayerInjured = true;
            }
        }
        if (headCoach.getSaving() > constants.getRandomNumber()) {
            player.setSaving(player.getSaving() + 1);
        } else {
            if (checkForInjury(player)) {
                isPlayerInjured = true;
            }
        }
        if (headCoach.getShooting() > constants.getRandomNumber()) {
            player.setShooting(player.getShooting() + 1);
        } else {
            if (checkForInjury(player)) {
                isPlayerInjured = true;
            }
        }
        if (headCoach.getSkating() > constants.getRandomNumber()) {
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
    }

    @Override
    public void setInjuriesModel(InjuriesModel injuriesModel) {
        currentInjuriesModel = injuriesModel;
    }

    private boolean checkForInjury(IPlayerModel player) {
        player.setInjuriesModel(currentInjuriesModel);
        player.checkPlayerInjury(player, currentDate);
        return player.isPlayerInjured();
    }
}
