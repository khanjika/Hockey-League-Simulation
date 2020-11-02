package trade;

import gameplayconfig.TradingModel;
import league.LeagueModel;
import teams.TeamsModel;

public interface IFindPlayerToSwap {
    LeagueModel findPlayersToSwap(LeagueModel league, TeamsModel team, ITradeTeamPojo tradingTeamDetails);

    ITradeModel offeredPlayer(TeamsModel team, TradingModel tradeModel);
}
