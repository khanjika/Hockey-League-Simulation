package trade;

import gameplayconfig.TradingModel;
import league.LeagueModel;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import players.PlayerModel;
import teams.TeamsModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPlayerToSwapTest {

    FindPlayerToSwap findPlayerToSwap = new FindPlayerToSwap ();

    @Test
    void sortPlayersAscending() {
        MockLeague league = new MockLeague ();
        TeamsModel t = league.getTeamsObject1 ();

        List<PlayerModel> list = t.getPlayers ();
        list = findPlayerToSwap.sortPlayersAscending (list);
        Assert.assertTrue (list.get (0).getPlayerStrength () <= list.get (1).getPlayerStrength ());
    }

    @Test
    void sortPlayersDescending() {
        MockLeague league = new MockLeague ();
        TeamsModel t = league.getTeamsObject1 ();

        List<PlayerModel> list = t.getPlayers ();
        list = findPlayerToSwap.sortPlayersDescending (list);
        Assert.assertTrue (list.get (0).getPlayerStrength () >= list.get (1).getPlayerStrength ());
    }

    @Test
    void findWeakPlayer() {
        List<PlayerModel> list = null;
        MockLeague league = new MockLeague ();
        TradingModel trade = new TradingModel ();

        trade = league.getLeagueObject ().getGameplayConfig ().getTrading ();
        TeamsModel t = league.getTeamsObject1 ();
        list = findPlayerToSwap.findWeakPlayer (t, trade);
        Assert.assertTrue (list.get (0).getPlayerStrength () == 15);
        Assert.assertFalse (list.get (0).getPlayerStrength () == 20);
    }


    @Test
    void teamWithMaxStrength() {
        MockLeague league = new MockLeague ();

        TeamsModel t = league.getTeamsObject1 ();
        List<PlayerModel> listOfPlayers = t.getPlayers ();
        Map<Float, ArrayList> finalPlayerMap = new HashMap<> ();
        Map<Float, ArrayList> strongPlayerDetails = findPlayerToSwap.teamWithMaxStrength (listOfPlayers, "Boston", "Atlantic", "Dalhousie Hockey League", false, finalPlayerMap);
        Assert.assertNotNull (strongPlayerDetails);

        Map.Entry<Float, ArrayList> entry = strongPlayerDetails.entrySet ().iterator ().next ();
        Float mapKey = entry.getKey ();
        Float value = 45f;
        Assert.assertEquals (mapKey, value);

        TeamsModel t1 = league.getTeamsObject2 ();
        List<PlayerModel> listOfPlayers1 = t1.getPlayers ();
        Map<Float, ArrayList> strongPlayerDetails1 = findPlayerToSwap.teamWithMaxStrength (listOfPlayers1, "Boston", "Atlantic", "Dalhousie Hockey League", false, strongPlayerDetails);
        Map.Entry<Float, ArrayList> entry1 = strongPlayerDetails1.entrySet ().iterator ().next ();
        Float mapKey1 = entry.getKey ();
        Float value1 = 37.5f;
        Assert.assertNotEquals (mapKey, value1);
    }

    @Test
    void playersFromTeam() {
        MockLeague league = new MockLeague ();
        TeamsModel t1 = league.getTeamsObject1 ();
        List<PlayerModel> players = league.getTeamsObject2 ().getPlayers ();
        List<PlayerModel> weakPlayers = new ArrayList<> ();
        weakPlayers.add (players.get (0));
        List<PlayerModel> playerTeam1 = findPlayerToSwap.playersFromTeam (t1, weakPlayers);
        Assert.assertEquals (playerTeam1.size (), 1);
        Assert.assertEquals (playerTeam1.get (0).getPosition (), "forward");
    }

    @Test
    void findTeamForSwap() {
        MockLeague league = new MockLeague ();
        TradeTeamPojo pojo = new TradeTeamPojo ();
        List<PlayerModel> weakPlayers = new ArrayList<> ();

        LeagueModel leaguemodel = league.getLeagueObject ();
        pojo.setConferenceName ("Eastern Conference");
        pojo.setDivisionName ("Atlantic");
        pojo.setTeamName ("Boston");

        List<PlayerModel> players = league.getTeamsObject1 ().getPlayers ();
        weakPlayers.add (players.get (0));

        Map<Float, ArrayList> swapingTeam = findPlayerToSwap.findTeamForSwap (leaguemodel, weakPlayers, pojo);
        Map.Entry<Float, ArrayList> entry = swapingTeam.entrySet ().iterator ().next ();
        Float mapKey = entry.getKey ();
        Float value = 17.5f;
        Assert.assertEquals (mapKey, value);
    }
}
