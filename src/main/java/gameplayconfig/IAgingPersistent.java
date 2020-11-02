package gameplayconfig;

public interface IAgingPersistent {
    int storeAgingInfomration(int averageRetiremtAge,int maximumAge);
    AgingModel getAgingInformation(int gamePlayConfigId);
}
