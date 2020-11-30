package statemachine.trade;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.PlayerModel;

import java.util.List;

public interface IFindTeamToSwap {
    ILeagueModel find(ILeagueModel leagueModel, int totalCounter, ITeamsModel team);

    ITeamsModel findTeamToTradePLayer(ILeagueModel leagueModel, int totalCounter, ITeamsModel team);

    List<PlayerModel> selectTeam(ITeamsModel team, ITeamsModel teamInitiatingTrade);
}
