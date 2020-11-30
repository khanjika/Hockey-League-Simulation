package statemachine.trade;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.PlayerModel;

import java.util.HashMap;
import java.util.List;

public interface IFindOfferedPlayers {
    ILeagueModel findPossibleTrade(ILeagueModel league, ITeamsModel team);

    int identifyTypeOfTrade(HashMap strengthMap, ILeagueModel league, ITeamsModel team);

    List<PlayerModel> setOfferedPlayers(String position, List<PlayerModel> offeredPlayer, ILeagueModel league, ITeamsModel team);
}
