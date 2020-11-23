package leagueobjectmodel;

import com.google.gson.annotations.Expose;

public class TrainingModel implements ITrainingModel {
    @Expose
    private int daysUntilStatIncreaseCheck;

    public int getDaysUntilStatIncreaseCheck() {
        return daysUntilStatIncreaseCheck;
    }

    public void setDaysUntilStatIncreaseCheck(int daysUntilStatIncreaseCheck) {
        this.daysUntilStatIncreaseCheck = daysUntilStatIncreaseCheck;
    }
}
