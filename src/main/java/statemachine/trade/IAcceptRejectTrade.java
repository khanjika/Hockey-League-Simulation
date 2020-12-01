package statemachine.trade;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.PlayerModel;

import java.util.List;

public interface IAcceptRejectTrade {
    ILeagueModel acceptRejectTrade(ILeagueModel league, ITeamsModel initiateTeam, ITeamsModel offeredTeam);

    ILeagueModel tradeRejected(ILeagueModel leagueModel, ITeamsModel initiateTeam, ITeamsModel offeredTeam);

    ILeagueModel tradeAccepted(ILeagueModel league, ITeamsModel initiateTeam, ITeamsModel offeredTeam);

    boolean swapTeam(ITeamsModel team, List<PlayerModel> team1, List<PlayerModel> team2);

}
