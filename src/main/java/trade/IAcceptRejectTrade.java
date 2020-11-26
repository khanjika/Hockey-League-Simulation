package trade;

import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.TeamsModel;

public interface IAcceptRejectTrade {
    LeagueModel acceptRejectTrade(ITradeTeamPojo Team2, ITradeTeamPojo Team1, ITradeModel trade, LeagueModel league);

    LeagueModel tradeRejected(ITradeTeamPojo team2, ITradeTeamPojo team1, LeagueModel leagueModel, ITradeModel trade);

    LeagueModel tradeAccepted(ITradeTeamPojo team2, ITradeTeamPojo team1, ITradeModel trade, LeagueModel league);

    boolean swapTeam1(TeamsModel team, ITradeModel trade);

    boolean swapTeam2(TeamsModel team, ITradeModel trade);

}
