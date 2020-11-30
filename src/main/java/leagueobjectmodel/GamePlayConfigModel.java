package leagueobjectmodel;

import com.google.gson.annotations.Expose;

public class GamePlayConfigModel implements IGamePlayConfigModel {
    @Expose
    AgingModel aging;
    GameResolverModel gameResolver;
    @Expose
    InjuriesModel injuries;
    @Expose
    TrainingModel training;
    @Expose
    TradingModel trading;

    public GamePlayConfigModel() {
        aging = new AgingModel();
        gameResolver = new GameResolverModel();
        injuries = new InjuriesModel();
        training = new TrainingModel();
        trading = new TradingModel();
    }

    @Override
    public AgingModel getAging() {
        return aging;
    }

    @Override
    public void setAging(AgingModel aging) {
        this.aging = aging;
    }

    @Override
    public GameResolverModel getGameResolver() {
        return gameResolver;
    }

    @Override
    public void setGameResolver(GameResolverModel gameResolver) {
        this.gameResolver = gameResolver;
    }

    @Override
    public InjuriesModel getInjuries() {
        return injuries;
    }

    @Override
    public void setInjuries(InjuriesModel injuries) {
        this.injuries = injuries;
    }

    @Override
    public TrainingModel getTraining() {
        return training;
    }

    @Override
    public void setTraining(TrainingModel training) {
        this.training = training;
    }

    @Override
    public TradingModel getTrading() {
        return trading;
    }

    @Override
    public void setTrading(TradingModel trading) {
        this.trading = trading;
    }

}
