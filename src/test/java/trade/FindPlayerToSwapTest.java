package trade;

import conference.ConferenceModel;
import divison.DivisonModel;
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
    void offeredPlayer() {
        MockLeague league = new MockLeague ();
        TradingModel tradeModel = new TradingModel ();
        ITradeModel trade = new TradeModel ();

        tradeModel = league.getLeagueObject ().getGameplayConfig ().getTrading ();
        TeamsModel team1 = league.getTeamsObject1 ();

        trade = findPlayerToSwap.offeredPlayer (team1, tradeModel);
        Assert.assertEquals (trade.getOfferedPlayer ().get (0).getPlayerName (), "A0");
        Assert.assertEquals (trade.getOfferedPlayer ().size (), 1);
    }

    @Test
    void playersFromTeam() {
        MockLeague league = new MockLeague ();
        TradeModel trade = new TradeModel ();

        TeamsModel t1 = league.getTeamsObject1 ();
        List<PlayerModel> offeredPlayersList = new ArrayList<> ();
        PlayerModel p = t1.getPlayers ().get (0);
        offeredPlayersList.add (p);

        TeamsModel t2 = league.getTeamsObject2 ();
        trade.setOfferedPlayer (offeredPlayersList);

        List<PlayerModel> potentialPlayers = findPlayerToSwap.playersFromTeam (t2, trade);
        Assert.assertEquals (potentialPlayers.size (), 1);
        Assert.assertEquals (potentialPlayers.get (0).getPosition (), "forward");
    }


    @Test
    void teamWithMaxStrength() {
        MockLeague league = new MockLeague ();
        Map<Float, ArrayList> requestingPlayerMap = new HashMap<> ();
        TradeTeamPojo pojo = new TradeTeamPojo ();

        pojo.setConferenceName ("Eastern Conference");
        pojo.setDivisionName ("Atlantic");
        pojo.setTeamName ("Halifax");

        TeamsModel t2 = league.getTeamsObject2 ();
        List<PlayerModel> listOfPlayers = t2.getPlayers ();

        requestingPlayerMap = findPlayerToSwap.teamWithMaxStrength (listOfPlayers, pojo, requestingPlayerMap);
        Assert.assertNotNull (requestingPlayerMap);

        TeamsModel t1 = league.getTeamsObject1 ();
        List<PlayerModel> listOfPlayers1 = t1.getPlayers ();

        requestingPlayerMap = findPlayerToSwap.teamWithMaxStrength (listOfPlayers1, pojo, requestingPlayerMap);

        Map.Entry<Float, ArrayList> entry = requestingPlayerMap.entrySet ().iterator ().next ();
        Float mapKey = entry.getKey ();
        Float value = 75f;
        Assert.assertEquals (mapKey, value);
    }


    @Test
    void findTeamForSwap() {
        MockLeague league = new MockLeague ();
        TradeTeamPojo pojo = new TradeTeamPojo ();
        ITradeModel trade = new TradeModel ();

        LeagueModel leaguemodel = league.getLeagueObject ();
        pojo.setConferenceName ("Eastern Conference");
        pojo.setDivisionName ("Atlantic");
        pojo.setTeamName ("Boston");

        TeamsModel t1 = league.getTeamsObject1 ();
        List<PlayerModel> offeredPlayersList = new ArrayList<> ();
        PlayerModel p = t1.getPlayers ().get (0);
        offeredPlayersList.add (p);

        TeamsModel t2 = league.getTeamsObject2 ();
        trade.setOfferedPlayer (offeredPlayersList);

        trade = findPlayerToSwap.findTeamForSwap (leaguemodel, pojo, trade);
        Assert.assertEquals (trade.getRequestedPlayers ().size (), 1);
        Assert.assertEquals (trade.getRequestedPlayers ().get (0).getPlayerName (), "C0");
    }

    @Test
    void findPlayersToSwap() {
        MockLeague league = new MockLeague ();
        TeamsModel t = new TeamsModel ();
        TradeTeamPojo pojo1 = new TradeTeamPojo ();
        LeagueModel leagueModel = league.getLeagueObject ();

        for (ConferenceModel conference : leagueModel.getConferences ()) {
            for (DivisonModel division : conference.getDivisions ()) {
                for (TeamsModel team : division.getTeams ()) {
                    t = team;
                    break;
                }
            }
        }

        pojo1.setConferenceName ("Eastern Conference");
        pojo1.setDivisionName ("Atlantic");
        pojo1.setTeamName ("Boston");

        LeagueModel leagueAfterTrade = findPlayerToSwap.findPlayersToSwap (leagueModel, t, pojo1);

        String player1Name = leagueAfterTrade.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0).getPlayers ().get (0).getPlayerName ();
        String player2Name = leagueAfterTrade.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0).getPlayers ().get (2).getPlayerName ();

        String player1 = leagueAfterTrade.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1).getPlayers ().get (0).getPlayerName ();
        String player2 = leagueAfterTrade.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1).getPlayers ().get (3).getPlayerName ();

        Assert.assertEquals (player1Name, "A0");
        Assert.assertEquals (player2Name, "C0");

        Assert.assertEquals (player1, "C0");
        Assert.assertEquals (player2, "A0");
    }
}
