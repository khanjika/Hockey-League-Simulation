package leagueobjectmodel;

import leagueobjectmodel.TrainingModel;
import org.junit.jupiter.api.Test;

public class TrainingModelTest {

    @Test
    void getDaysUntilStatIncreaseCheck() {
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDaysUntilStatIncreaseCheck(100);
    }

    @Test
    void setDaysUntilStatIncreaseCheck() {
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDaysUntilStatIncreaseCheck(100);
    }

    public static TrainingModel getTrainingModel(int DaysUntilStatIncreaseCheck) {
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDaysUntilStatIncreaseCheck(DaysUntilStatIncreaseCheck);
        return trainingModel;
    }
}
