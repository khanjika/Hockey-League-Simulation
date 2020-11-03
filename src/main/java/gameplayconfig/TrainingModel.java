package gameplayconfig;

import com.google.gson.annotations.Expose;
import training.Training;

public class TrainingModel implements ITrainingModel{
    @Expose
    private int daysUntilStatIncreaseCheck;

    ITrainingPersistent iTrainingPersistent;
    public int getDaysUntilStatIncreaseCheck() {
        return daysUntilStatIncreaseCheck;
    }

    public void setDaysUntilStatIncreaseCheck(int daysUntilStatIncreaseCheck) {
        this.daysUntilStatIncreaseCheck = daysUntilStatIncreaseCheck;
    }

    @Override
    public int addTrainingModelInformation(TrainingModel trainingModel) {
        iTrainingPersistent=new TrainingPersistent();
        return iTrainingPersistent.storeTrainingInformation(trainingModel.getDaysUntilStatIncreaseCheck());
    }
}
