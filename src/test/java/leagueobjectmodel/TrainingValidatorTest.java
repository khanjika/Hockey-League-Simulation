package leagueobjectmodel;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrainingValidatorTest {

    @Test
    void validateTraining() {
        TrainingModel trainingModel = new TrainingModel();
        TrainingValidator trainingValidator = new TrainingValidator();
        trainingModel = TrainingModelTest.getTrainingModel(100);
        assertTrue(trainingValidator.validateTraining(trainingModel));
        TrainingModel trainingModel1 = new TrainingModel();
        trainingModel1 = TrainingModelTest.getTrainingModel(0);
        assertFalse(trainingValidator.validateTraining(trainingModel1));
    }
}
