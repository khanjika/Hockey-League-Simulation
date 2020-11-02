package trade;

import league.LeagueModel;
import players.PlayerModel;
import teams.TeamsModel;

import java.util.List;

public interface IAcceptRejectTrade {
    LeagueModel acceptRejectTrade(ITradeTeamPojo Team2, ITradeTeamPojo Team1, TradeModel trade, LeagueModel league);

    LeagueModel tradeRejected(ITradeTeamPojo team2, ITradeTeamPojo team1, LeagueModel leagueModel, TradeModel trade);

    LeagueModel tradeAccepted(ITradeTeamPojo team2, ITradeTeamPojo team1, TradeModel trade, LeagueModel league);

    boolean swapTeam1(TeamsModel team, TradeModel trade);

    boolean swapTeam2(TeamsModel team, TradeModel trade);

}
