package training;

import gameplayconfig.InjuriesModel;
import players.PlayerModel;
import teams.HeadCoachModel;

import java.time.LocalDate;

public interface ITraining {
    void performTraining(PlayerModel player, HeadCoachModel headCoach, LocalDate currentDate);

    void setInjuriesModel(InjuriesModel injuriesModel);
}
