package gameplayconfig;

import com.google.gson.annotations.Expose;
import training.Training;

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

    IAgingModel iAgingModel;
    IInjuriesModel iInjuriesModel;
    ITradingModel iTradingModel;
    IGameResolverModel iGameResolverModel;
    ITrainingModel iTraining;
    IGamePlayConfigPersistent iGamePlayConfigPersistent;

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

    public int addGamePlayConfigInformation(GamePlayConfigModel gamePlayConfigModel){
        iAgingModel=new AgingModel();
        iInjuriesModel=new InjuriesModel();
        iGameResolverModel=new GameResolverModel();
        iTradingModel=new TradingModel();
        iTraining = new TrainingModel();
        iTraining = new TrainingModel();
        iGamePlayConfigPersistent=new GamePlayConfigPersistent();

        int aginId= iAgingModel.addAgingInformation(gamePlayConfigModel.getAging());
        int injuriesId= iInjuriesModel.addInjuriesInformation(gamePlayConfigModel.getInjuries());
        int trainingId= iTraining.addTrainingModelInformation(gamePlayConfigModel.getTraining());
        int tradingId= iTradingModel.addTradingModelInformation(gamePlayConfigModel.getTrading());
        int gameResolverId= iGameResolverModel.addGameResolverInformation(gamePlayConfigModel.getGameResolver());

      int gamePlayConfigId=  iGamePlayConfigPersistent.storeGamePlayConfigInformation(aginId,gameResolverId,injuriesId,trainingId,tradingId);

      return gamePlayConfigId;
    }
}
