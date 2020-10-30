package training;

import conference.ConferenceModel;
import divison.DivisonModel;
import league.LeagueModel;
import players.PlayerModel;
import teams.HeadCoachModel;
import teams.TeamsModel;

import java.time.LocalDate;

public class Training {

    TrainingConstants constants = new TrainingConstants();
    private static LocalDate currentDate;
    private LeagueModel currentLeague;
    public void trainingLogic(LeagueModel currentLeagueModel, LocalDate date) {
        currentLeague = currentLeagueModel;
        currentDate = date;
        for (ConferenceModel currentConference : currentLeagueModel.getConferences()) {
            for (DivisonModel currentDivision : currentConference.getDivisions()) {
                for (TeamsModel currentTeam : currentDivision.getTeams()) {
                    for (PlayerModel player : currentTeam.getPlayers()) {
                        performTraining(player, currentTeam.getHeadCoach());
//                        if (performTraining(player, currentTeam.getHeadCoach())){

//                            return true;
//                        }
                    }
                }
            }
        }
//        return false;
    }
    private void performTraining(PlayerModel player, HeadCoachModel headCoach){
        if (headCoach.getChecking() > constants.getRandomNumber()) {
            player.setChecking(player.getChecking() + 1);
        }else{
            if(checkForInjury(player)){
                player.setPlayerInjured(true);
            }
        }
        if (headCoach.getSaving() > constants.getRandomNumber()) {
            player.setSaving(player.getSaving() + 1);
        }else{
            if(checkForInjury(player)){
                player.setPlayerInjured(true);
            }
        }
        if (headCoach.getShooting() > constants.getRandomNumber()) {
            player.setShooting(player.getShooting() + 1);
        }else{
            if(checkForInjury(player)){
                player.setPlayerInjured(true);
            }
        }
        if (headCoach.getSkating() > constants.getRandomNumber()) {
            player.setSkating(player.getSkating() + 1);
        }else{
            if(checkForInjury(player)){
                player.setPlayerInjured(true);
            }
        }
    }

    private boolean checkForInjury(PlayerModel player){
        player.setInjuriesModel(currentLeague.getGameplayConfig().getInjuries());
        player.checkPlayerInjury(player, currentDate);
        if(player.isPlayerInjured()){
            return true;
        }
        return false;
    }
}
