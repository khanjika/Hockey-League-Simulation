package leagueobjectmodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = GamePlayConfigModel.class)
public interface IGamePlayConfigModel {
    IAgingModel getAging();

    void setAging(IAgingModel aging);

    IInjuriesModel getInjuries();

    void setInjuries(IInjuriesModel injuries);

    ITrainingModel getTraining();

    void setTraining(ITrainingModel training);

    ITradingModel getTrading();

    void setTrading(ITradingModel trading);

}
