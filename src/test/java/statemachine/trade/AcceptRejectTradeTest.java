package statemachine.trade;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.PlayerModel;
import LeagueMockObject.ModelMock;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AcceptRejectTradeTest {
    static ModelMock mock;
    static ITradeModel model;
    static ITeamsModel team1;
    static ITeamsModel team2;
    static IFindTeamToSwap findTeamToSwap;
    static ILeagueModel leagueModel;
    static IAcceptRejectTrade acceptRejectTrade;
    static List<PlayerModel> offeredPlayer;
    static List<PlayerModel> requestedPlayer;

    @BeforeClass
    public static void load() {
        model = TradeAbstractFactory.instance ().createTradeModel ();
        acceptRejectTrade = TradeAbstractFactory.instance ().createAcceptRejectTrade ();
        findTeamToSwap = TradeAbstractFactory.instance ().createTeamToSwap ();
        mock = new ModelMock ();
        offeredPlayer = mock.playerList ();
        model.setOfferedPlayer (offeredPlayer);
        requestedPlayer = new ArrayList<> ();
        leagueModel = mock.leagueModel ();
        team1 = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1);
        team2 = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (2);
        PlayerModel p2 = team2.getPlayers ().get (5);
        requestedPlayer.add (p2);
        model.setRequestedPlayers (requestedPlayer);
    }

    @Test
    public void acceptRejectTrade() {
        leagueModel = acceptRejectTrade.acceptRejectTrade (leagueModel, team1, team2);
        String playerName = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1).getPlayers ().get (10).getPlayerName ();

        Assert.assertEquals (playerName, "Mary Halen");
    }

    @Test
    public void tradeRejected() {
        leagueModel.getGameplayConfig ().getTrading ().setRandomAcceptanceChance (0);
        leagueModel = acceptRejectTrade.tradeRejected (leagueModel, team1, team2);
        String playerName = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1).getPlayers ().get (10).getPlayerName ();
        Assert.assertNotEquals (playerName, "Mary Halen");

        leagueModel.getGameplayConfig ().getTrading ().setRandomAcceptanceChance (1);
        leagueModel = acceptRejectTrade.tradeRejected (leagueModel, team1, team2);
        String player = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1).getPlayers ().get (10).getPlayerName ();

        Assert.assertEquals (player, "Mary Halen");

    }

    @Test
    public void tradeAccepted() {
        leagueModel = acceptRejectTrade.tradeAccepted (leagueModel, team1, team2);
        String playerName = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1).getPlayers ().get (10).getPlayerName ();

        Assert.assertEquals (playerName, "Mary Halen");
        Assert.assertEquals (team1.getPlayers ().size (), 30);
        Assert.assertEquals (team2.getPlayers ().size (), 30);
    }

    @Test
    public void swapTeam() {
        boolean result = acceptRejectTrade.swapTeam (team1, requestedPlayer, offeredPlayer);
        Assert.assertEquals (result, true);
    }


}
