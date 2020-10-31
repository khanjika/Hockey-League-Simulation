package trade;

import gameplayconfig.TradingModel;
import league.LeagueModel;
import teams.TeamsModel;

public interface IFindPlayerToSwap {
    LeagueModel swapPlayer(LeagueModel league, TeamsModel team, ITradeTeamPojo tradingTeamDetails);

    TradeModel offeredPlayer(TeamsModel team, TradingModel tradeModel);
}
