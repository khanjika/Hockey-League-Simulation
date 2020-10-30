package gameplayconfig;

import com.google.gson.annotations.Expose;

public class GamePlayConfigModel implements IGamePlayConfigModel{
    @Expose
    AgingModel aging;
    @Expose
    GameResolverModel gameResolver;
    @Expose
    InjuriesModel injuries;
    @Expose
    TrainingModel training;
    @Expose
    TradingModel trading;

    public AgingModel getAging() {
        return aging;
    }

    public void setAging(AgingModel aging) {
        this.aging = aging;
    }

    public GameResolverModel getGameResolver() {
        return gameResolver;
    }

    public void setGameResolver(GameResolverModel gameResolver) {
        this.gameResolver = gameResolver;
    }

    public InjuriesModel getInjuries() {
        return injuries;
    }

    public void setInjuries(InjuriesModel injuries) {
        this.injuries = injuries;
    }

    public TrainingModel getTraining() {
        return training;
    }

    public void setTraining(TrainingModel training) {
        this.training = training;
    }

    public TradingModel getTrading() {
        return trading;
    }

    public void setTrading(TradingModel trading) {
        this.trading = trading;
    }
}
