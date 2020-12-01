package leagueobjectmodel;

public class TrainingValidator implements ITrainingValidator {
    @Override
    public boolean validateTraining(TrainingModel trainingModel) {
        return isNotNull(trainingModel.getDaysUntilStatIncreaseCheck());
    }
    private boolean isNotNull(int value) {
        if(value==0){
            return false;
        }
        else
            return true;
    }
}
