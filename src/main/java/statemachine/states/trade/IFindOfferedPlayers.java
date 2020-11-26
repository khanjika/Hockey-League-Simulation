package statemachine.states.trade;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;

public interface IFindOfferedPlayers {
    void findStrength(ILeagueModel league, ITeamsModel team, ITradeModel trade);
}
