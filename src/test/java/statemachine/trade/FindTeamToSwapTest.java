//package statemachine.trade;
//
//import leagueobjectmodel.ILeagueModel;
//import leagueobjectmodel.ITeamsModel;
//import leagueobjectmodel.PlayerModel;
//import mock.ModelMock;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FindTeamToSwapTest {
//
//    static ModelMock mock;
//    static ITradeModel model;
//    static ITeamsModel team;
//    static IFindTeamToSwap findTeamToSwap;
//    static ILeagueModel leagueModel;
//
//    @BeforeClass
//    public static void loadMockLeague() {
//        mock = new ModelMock ();
//        model = TradeAbstractFactory.instance ().createTradeModel ();
//        findTeamToSwap = TradeAbstractFactory.instance ().createTeamToSwap ();
//        List<PlayerModel> offeredPlayer = new ArrayList<> ();
//        leagueModel = mock.leagueModel ();
//        team = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1);
//        PlayerModel p = team.getPlayers ().get (1);
//        PlayerModel p1 = team.getPlayers ().get (4);
//        offeredPlayer.add (p);
//        offeredPlayer.add (p1);
//        model.setOfferedPlayer (offeredPlayer);
//    }
//
//    @Test
//    public void find() {
//        int totalCounter = 2;
//        leagueModel = findTeamToSwap.find (leagueModel, totalCounter, team);
//        String playerName = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1).getPlayers ().get (10).getPlayerName ();
//
//        Assert.assertEquals (playerName, "Mary Halen");
//    }
//
//    @Test
//    public void findTeamToTradePLayer() {
//        int totalCounter = 2;
//        team = findTeamToSwap.findTeamToTradePLayer (leagueModel, totalCounter, team);
//
//        Assert.assertEquals (team.getTeamName (), "Cairo Astros");
//    }
//
//    @Test
//    public void selectTeam() {
//        ITeamsModel possibleTeam = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (2);
//        possibleTeam.setIsGoalieStrong (1);
//        team.setIsDefenseStrong (1);
//        team.setIsForwardStrong (1);
//        List<PlayerModel> requestedPlayers = findTeamToSwap.selectTeam (possibleTeam, team);
//
//        Assert.assertEquals (requestedPlayers.size (), 1);
//    }
//}
