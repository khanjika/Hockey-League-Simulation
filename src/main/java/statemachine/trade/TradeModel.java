package statemachine.trade;

import com.google.gson.annotations.Expose;
import leagueobjectmodel.PlayerModel;

import java.util.List;

public class TradeModel implements ITradeModel {

    @Expose
    private ITradeTeamPojo tradeInitiatingTeam;

    @Expose
    private ITradeTeamPojo tradeOfferedTeam;

    @Expose
    private List<PlayerModel> offeredPlayer;

    @Expose
    private List<PlayerModel> requestedPlayers;

    @Override
    public ITradeTeamPojo getTradeOfferedTeam() {
        return tradeOfferedTeam;
    }

    @Override
    public void setTradeOfferedTeam(ITradeTeamPojo tradeOfferedTeam) {
        this.tradeOfferedTeam = tradeOfferedTeam;
    }

    @Override
    public ITradeTeamPojo getTradeInitiatingTeam() {
        return tradeInitiatingTeam;
    }

    @Override
    public void setTradeInitiatingTeam(ITradeTeamPojo tradeInitiatingTeam) {
        this.tradeInitiatingTeam = tradeInitiatingTeam;
    }

    @Override
    public List<PlayerModel> getOfferedPlayer() {
        return offeredPlayer;
    }

    @Override
    public void setOfferedPlayer(List<PlayerModel> offeredPlayer) {
        this.offeredPlayer = offeredPlayer;
    }

    @Override
    public List<PlayerModel> getRequestedPlayers() {
        return requestedPlayers;
    }

    @Override
    public void setRequestedPlayers(List<PlayerModel> requestedPlayers) {
        this.requestedPlayers = requestedPlayers;
    }

}
