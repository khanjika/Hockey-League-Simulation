package training;

import conference.ConferenceModel;
import divison.DivisonModel;
import league.LeagueModel;
import players.PlayerModel;
import teams.TeamsModel;

public class Training {

    TrainingConstants constants = new TrainingConstants();
    public LeagueModel trainingLogic(LeagueModel currentLeagueModel) {
        for (ConferenceModel currentConference : currentLeagueModel.getConferences()) {
            for (DivisonModel currentDivision : currentConference.getDivisions()) {
                for (TeamsModel currentTeam : currentDivision.getTeams()) {
                    if (currentTeam.getHeadCoach().getChecking() > constants.getRandomNumber()) {
                        for (PlayerModel player : currentTeam.getPlayers()) {
                            player.setChecking(player.getChecking() + 1);
                        }
                    }
                    else {

                    }
                    if (currentTeam.getHeadCoach().getSaving() > constants.getRandomNumber()) {
                        for (PlayerModel player : currentTeam.getPlayers()) {
                            player.setSaving(player.getSaving() + 1);
                        }
                    }
                    else {

                    }
                    if (currentTeam.getHeadCoach().getShooting() > constants.getRandomNumber()) {
                        for (PlayerModel player : currentTeam.getPlayers()) {
                            player.setShooting(player.getShooting() + 1);
                        }
                    }
                    else {

                    }
                    if (currentTeam.getHeadCoach().getSkating() > constants.getRandomNumber()) {
                        for (PlayerModel player : currentTeam.getPlayers()) {
                            player.setSkating(player.getSkating() + 1);
                        }
                    }
                    else {

                    }
                }
            }
        }
        return currentLeagueModel;
    }
}
