package leagueobjectmodel;

import com.google.gson.annotations.Expose;


public class GamePlayConfigModel implements IGamePlayConfigModel {
    @Expose
    IAgingModel aging;
    @Expose
    IInjuriesModel injuries;
    @Expose
    ITrainingModel training;
    @Expose
    ITradingModel trading;

    public GamePlayConfigModel() {
    }

    @Override
    public IAgingModel getAging() {
        return aging;
    }

    @Override
    public void setAging(IAgingModel aging) {
        this.aging = aging;
    }


    @Override
    public IInjuriesModel getInjuries() {
        return injuries;
    }

    @Override
    public void setInjuries(IInjuriesModel injuries) {
        this.injuries = injuries;
    }

    @Override
    public ITrainingModel getTraining() {
        return training;
    }

    @Override
    public void setTraining(ITrainingModel training) {
        this.training = training;
    }

    @Override
    public ITradingModel getTrading() {
        return trading;
    }

    @Override
    public void setTrading(ITradingModel trading) {
        this.trading = trading;
    }

}
