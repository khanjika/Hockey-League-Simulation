package leagueobjectmodel;

public interface IGamePlayConfigModel {
    IAgingModel getAging();

    void setAging(AgingModel aging);

    IInjuriesModel getInjuries();

    void setInjuries(InjuriesModel injuries);

    TrainingModel getTraining();

    void setTraining(TrainingModel training);

    TradingModel getTrading();

    void setTrading(TradingModel trading);

}
