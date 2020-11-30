package statemachine.trade;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.PlayerModel;

import java.util.List;

public interface IAcceptRejectTrade {
    ILeagueModel acceptRejectTrade(ILeagueModel league);

    ILeagueModel tradeRejected(ILeagueModel leagueModel);

    ILeagueModel tradeAccepted(ILeagueModel league);

    boolean swapTeam(ITeamsModel team, List<PlayerModel> team1, List<PlayerModel> team2);

}
