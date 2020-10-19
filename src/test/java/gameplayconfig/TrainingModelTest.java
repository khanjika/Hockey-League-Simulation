package gameplayconfig;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainingModelTest {

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
}