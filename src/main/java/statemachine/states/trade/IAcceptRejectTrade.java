package statemachine.states.trade;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;

public interface IAcceptRejectTrade {
    ILeagueModel acceptRejectTrade(ILeagueModel league);

    ILeagueModel tradeRejected(ILeagueModel leagueModel);

    ILeagueModel tradeAccepted(ILeagueModel league);

    boolean swapTeam1(ITeamsModel team);

    boolean swapTeam2(ITeamsModel team);

}
