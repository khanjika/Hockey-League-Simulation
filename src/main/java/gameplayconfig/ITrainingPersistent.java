package gameplayconfig;

public interface ITrainingPersistent {

    int storeTrainingInformation(int daysUntilStateIncreaseCheck);
    TrainingModel getTrainingInformation(int gamePlayConfigId);

}
