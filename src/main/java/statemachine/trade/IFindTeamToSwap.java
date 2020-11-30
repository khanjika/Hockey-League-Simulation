package statemachine.trade;

import leagueobjectmodel.ILeagueModel;

public interface IFindTeamToSwap {
    ILeagueModel find(ILeagueModel leagueModel);

    void findPossibleTeam(ILeagueModel leagueModel);
}
