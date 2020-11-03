package gameplayconfig;

public class MockAgingPersistent {
    int storeAgingInfomration(int averageRetiremtAge, int maximumAge) {
        return 0;
    }

    AgingModel getAgingInformation(int gamePlayConfigId) {
        AgingModel agingModel = new AgingModel();
        agingModel.setAverageRetirementAge(35);
        agingModel.setMaximumAge(50);
        return agingModel;
    }
}


