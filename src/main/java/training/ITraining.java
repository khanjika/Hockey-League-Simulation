package training;

import gameplayconfig.InjuriesModel;
import league.LeagueModel;
import players.PlayerModel;
import teams.HeadCoachModel;

import java.time.LocalDate;

public interface ITraining {
     void performTraining(PlayerModel player, HeadCoachModel headCoach, LocalDate currentDate);
     void setInjuriesModel(InjuriesModel injuriesModel);
}
