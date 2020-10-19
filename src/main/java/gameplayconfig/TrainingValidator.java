package gameplayconfig;

public class TrainingValidator implements ITrainingValidator{
    @Override
    public boolean validateTraining(TrainingModel trainingModel) {
        if(isNotNull(trainingModel.getDaysUntilStatIncreaseCheck())){
        return true;
        }
        else {
            return false;
        }
    }

    public boolean isNotNull(int value){
        if(value == 0){
            return false;
        }
        else {
            return true;
        }
}
}