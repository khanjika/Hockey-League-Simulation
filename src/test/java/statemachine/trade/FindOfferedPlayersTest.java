package statemachine.trade;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.PlayerModel;
import LeagueMockObject.ModelMock;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindOfferedPlayersTest {

    static IFindOfferedPlayers findOfferedPlayers;
    static ModelMock mock;

    private enum playerPosition {
        forward,
        defense,
        goalie
    }

    @BeforeClass
    public static void loadMockLeague() {
        findOfferedPlayers = TradeAbstractFactory.instance ().createOfferedPlayers ();
        mock = new ModelMock ();
    }

    @Test
    public void findPossibleTrade() {
        ILeagueModel leagueModel = mock.leagueModel ();
        ITeamsModel team = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1);
        leagueModel = findOfferedPlayers.findPossibleTrade (leagueModel, team);
        String playerName = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1).getPlayers ().get (10).getPlayerName ();

        Assert.assertEquals (playerName, "Mary Halen");
    }

    @Test
    public void identifyTypeOfTrade() {
        HashMap strengthMap = mock.strengthHashMapModel ();
        ILeagueModel leagueModel = mock.leagueModel ();
        ITeamsModel team = mock.teamModel ();
        int totalCounter = findOfferedPlayers.identifyTypeOfTrade (strengthMap, leagueModel, team);

        Assert.assertEquals (totalCounter, 2);
    }

    @Test
    public void setOfferedPlayers() {

        String position = playerPosition.defense.toString ();
        List<PlayerModel> offeredPlayer = new ArrayList<> ();
        ILeagueModel leagueModel = mock.leagueModel ();
        ITeamsModel team = mock.teamModel ();
        List<PlayerModel> playersList = findOfferedPlayers.setOfferedPlayers (position, offeredPlayer, leagueModel, team);

        Assert.assertEquals (playersList.size (), 1);
    }
}
