package leagueobjectmodel;

public interface IGamePlayConfigModel {
    AgingModel getAging();

    void setAging(AgingModel aging);

    GameResolverModel getGameResolver();

    void setGameResolver(GameResolverModel gameResolver);

    InjuriesModel getInjuries();

    void setInjuries(InjuriesModel injuries);

    TrainingModel getTraining();

    void setTraining(TrainingModel training);

    TradingModel getTrading();

    void setTrading(TradingModel trading);

}
