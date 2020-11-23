package trade;

import leagueobjectmodel.TradingModel;
import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.TeamsModel;

public interface IFindPlayerToSwap {
    LeagueModel findPlayersToSwap(LeagueModel league, TeamsModel team, ITradeTeamPojo tradingTeamDetails);

    ITradeModel offeredPlayer(TeamsModel team, TradingModel tradeModel);
}
