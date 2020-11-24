package leagueobjectmodel;

import com.google.gson.annotations.Expose;

public class TrainingModel implements ITrainingModel {
    @Expose
    private int daysUntilStatIncreaseCheck;

    @Override
    public int getDaysUntilStatIncreaseCheck() {
        return daysUntilStatIncreaseCheck;
    }

    @Override
    public void setDaysUntilStatIncreaseCheck(int daysUntilStatIncreaseCheck) {
        this.daysUntilStatIncreaseCheck = daysUntilStatIncreaseCheck;
    }
}
