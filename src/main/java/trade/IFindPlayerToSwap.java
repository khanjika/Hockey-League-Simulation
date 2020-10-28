package trade;

import gameplayconfig.TradingModel;
import league.LeagueModel;
import players.PlayerModel;
import teams.TeamsModel;

import java.util.List;

public interface IFindPlayerToSwap {
    void swapPlayer(TeamsModel team, TradingModel trade, LeagueModel league, ITradeTeamPojo tradingTeamDetails);
    List<PlayerModel> sortPlayersDescending(List<PlayerModel> players);
    List<PlayerModel> sortPlayersAscending(List<PlayerModel> players);
}
