package gameplayconfig;

public class MockTrainingPersistent {
    int storeTrainingInformation(int daysUntilStateIncreaseCheck){
        return 0;
    }
    TrainingModel getTrainingInformation(int gamePlayConfigId){
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDaysUntilStatIncreaseCheck(100);
        return trainingModel;
    }
}
