package statemachine.training;

import leagueobjectmodel.InjuriesModel;
import leagueobjectmodel.PlayerModel;
import leagueobjectmodel.HeadCoachModel;

import java.time.LocalDate;

public interface ITraining {
    void performTraining(PlayerModel player, HeadCoachModel headCoach, LocalDate currentDate);

    void setInjuriesModel(InjuriesModel injuriesModel);
}
