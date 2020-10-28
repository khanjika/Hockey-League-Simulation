package training;

import conference.ConferenceModel;
import divison.DivisonModel;
import league.LeagueModel;
import players.PlayerModel;
import teams.HeadCoachModel;
import teams.TeamsModel;

public class Training {

    TrainingConstants constants = new TrainingConstants();

    public LeagueModel trainingLogic(LeagueModel currentLeagueModel) {
        for (ConferenceModel currentConference : currentLeagueModel.getConferences()) {
            for (DivisonModel currentDivision : currentConference.getDivisions()) {
                for (TeamsModel currentTeam : currentDivision.getTeams()) {
                    for (PlayerModel player : currentTeam.getPlayers()) {
                        performTraining(player, currentTeam.getHeadCoach());
                    }
                }
            }
        }
        return currentLeagueModel;
    }
    private boolean performTraining(PlayerModel player, HeadCoachModel headCoach){
        if (headCoach.getChecking() > constants.getRandomNumber()) {
            player.setChecking(player.getChecking() + 1);
        }else{
//            player.checkPlayerInjury();
//            player.isPlayerInjured();
        }
        if (headCoach.getSaving() > constants.getRandomNumber()) {
            player.setSaving(player.getSaving() + 1);
        }else{
//            player.checkPlayerInjury();
//            player.isPlayerInjured();
        }
        if (headCoach.getShooting() > constants.getRandomNumber()) {
            player.setShooting(player.getShooting() + 1);
        }else{
//            player.checkPlayerInjury();
//            player.isPlayerInjured();
        }
        if (headCoach.getSkating() > constants.getRandomNumber()) {
            player.setSkating(player.getSkating() + 1);
        }else{
//            player.checkPlayerInjury();
//            player.isPlayerInjured();
        }

        return false;
    }
}
