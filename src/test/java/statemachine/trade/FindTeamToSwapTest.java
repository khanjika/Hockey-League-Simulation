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

public class FindTeamToSwapTest {

    static ModelMock mock;
    static ITradeModel model;
    static ITeamsModel team;
    static ITeamsModel team1;
    static IFindTeamToSwap findTeamToSwap;
    static ILeagueModel leagueModel;

    @BeforeClass
    public static void load() {
        model = TradeAbstractFactory.instance ().createTradeModel ();
        findTeamToSwap = TradeAbstractFactory.instance ().createTeamToSwap ();
        mock = new ModelMock ();
        leagueModel = mock.leagueModel ();
        team = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1);
        team1 = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (2);
        List<PlayerModel> offeredPlayer = mock.playerList ();
        model.setOfferedPlayer (offeredPlayer);
    }

    @Test
    public void find() {
        int totalCounter = 2;
        leagueModel = findTeamToSwap.find (leagueModel, totalCounter, team);
        String playerName = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1).getPlayers ().get (10).getPlayerName ();

        Assert.assertEquals (playerName, "Mary Halen");
    }

    @Test
    public void findTeamToTradePLayer() {
        int totalCounter = 2;
        team = findTeamToSwap.findTeamToTradePLayer (leagueModel, totalCounter, team);

        Assert.assertEquals (team.getTeamName (), "Cairo Astros");
    }

    @Test
    public void findTeamToTradePick() {
        int round = findTeamToSwap.findTeamToTradePick (team1, team);

        Assert.assertEquals (round, 0);
    }

    @Test
    public void selectTeam() {
        ITeamsModel possibleTeam = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (2);
        possibleTeam.setIsGoalieStrong (1);
        team.setIsDefenseStrong (1);
        team.setIsForwardStrong (1);
        List<PlayerModel> requestedPlayers = findTeamToSwap.selectTeam (possibleTeam, team);

        Assert.assertEquals (requestedPlayers.size (), 1);
    }

    @Test
    public void findSuitablePlayers() {
        String position = "goalie";
        List<PlayerModel> requestedPlayers = new ArrayList<> ();
        requestedPlayers = findTeamToSwap.findSuitablePlayers (team1, position, requestedPlayers, team);

        Assert.assertEquals (requestedPlayers.size (), 1);
    }
}
