package training;

import conference.ConferenceModel;
import divison.DivisonModel;
import gameplayconfig.InjuriesModel;
import league.LeagueModel;
import players.PlayerModel;
import teams.HeadCoachModel;
import teams.TeamsModel;

import java.time.LocalDate;

public class Training implements  ITraining{

    TrainingConstants constants = new TrainingConstants();
    private static LocalDate currentDate;
    private static InjuriesModel currentInjuriesModel;

    public void performTraining(PlayerModel player, HeadCoachModel headCoach,LocalDate currentDate){
        this.currentDate=currentDate;
        boolean isPlayerInjured = false;
        if (headCoach.getChecking() > constants.getRandomNumber()) {
            player.setChecking(player.getChecking() + 1);
        }else{
            if(checkForInjury(player)){
                isPlayerInjured = true;
            }
        }
        if (headCoach.getSaving() > constants.getRandomNumber()) {
            player.setSaving(player.getSaving() + 1);
        }else{
            if(checkForInjury(player)){
                isPlayerInjured = true;
            }
        }
        if (headCoach.getShooting() > constants.getRandomNumber()) {
            player.setShooting(player.getShooting() + 1);
        }else{
            if(checkForInjury(player)){
                isPlayerInjured = true;
            }
        }
        if (headCoach.getSkating() > constants.getRandomNumber()) {
            player.setSkating(player.getSkating() + 1);
        }else{
            if(checkForInjury(player)){
                isPlayerInjured = true;
            }
        }
        if (isPlayerInjured == true){
            player.setPlayerInjured(true);
            player.calculatePlayerStrength(player);
        }
    }

    @Override
    public void setInjuriesModel(InjuriesModel injuriesModel) {
        currentInjuriesModel=injuriesModel;
    }

    private boolean checkForInjury(PlayerModel player){
        player.setInjuriesModel(currentInjuriesModel);
        player.checkPlayerInjury(player, currentDate);
        if(player.isPlayerInjured()){
            return true;
        }
        return false;
    }
}
