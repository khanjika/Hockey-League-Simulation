package statemachine.states.trade;

import leagueobjectmodel.PlayerModel;

import java.util.List;

public interface ITradeModel {

    ITradeTeamPojo getTradeOfferedTeam();

    ITradeTeamPojo getTradeInitiatingTeam();

    List<PlayerModel> getOfferedPlayer();

    List<PlayerModel> getRequestedPlayers();

    void setTradeOfferedTeam(ITradeTeamPojo tradeOfferedTeam);

    void setTradeInitiatingTeam(ITradeTeamPojo tradeInitiatingTeam);

    void setOfferedPlayer(List<PlayerModel> offeredPlayer);

    void setRequestedPlayers(List<PlayerModel> requestedPlayers);
}
