package leagueobjectmodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = TrainingModel.class)
public interface ITrainingModel {
    int getDaysUntilStatIncreaseCheck();

    void setDaysUntilStatIncreaseCheck(int daysUntilStatIncreaseCheck);
}
