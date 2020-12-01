package statemachine.training;


import leagueobjectmodel.IInjuriesModel;
import leagueobjectmodel.IPlayerModel;
import leagueobjectmodel.HeadCoachModel;

import java.time.LocalDate;

public interface ITraining {
    void performTraining(IPlayerModel player, HeadCoachModel headCoach, LocalDate currentDate);

    void setInjuriesModel(IInjuriesModel injuriesModel);
}
