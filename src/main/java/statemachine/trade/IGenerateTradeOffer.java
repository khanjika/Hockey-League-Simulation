package statemachine.trade;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.ITradingModel;

public interface IGenerateTradeOffer {

    ILeagueModel checkTrading(ILeagueModel leagueModel);

    boolean calculateLossPoint(float lossMatches, ITradingModel tradeModel);

    boolean calculateTradeChance(ITradingModel tradeModel, ITeamsModel team);
}
