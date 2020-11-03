package gameplayconfig;

public class TrainingValidator implements ITrainingValidator {
    @Override
    public boolean validateTraining(TrainingModel trainingModel) {
        return isNotNull(trainingModel.getDaysUntilStatIncreaseCheck());
    }

    private boolean isNotNull(int value) {
        return value != 0;
    }
}
