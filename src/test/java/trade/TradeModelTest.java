package trade;

import coach.CoachModel;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import players.PlayerModel;
import teams.TeamsModel;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TradeModelTest {

    @Test
    void getOfferedPlayer() {
        MockLeague league = new MockLeague ();
        TradeModel trade = new TradeModel ();
        List<PlayerModel> team1PLayers = new ArrayList<> ();
        List<PlayerModel> offeredPlayerList = new ArrayList<> ();

        TeamsModel t1 = league.getTeamsObject1 ();
        PlayerModel p1 = t1.getPlayers ().get (0);
        team1PLayers.add (p1);
        trade.setOfferedPlayer (team1PLayers);

        offeredPlayerList = trade.getOfferedPlayer ();
        Assert.assertEquals (offeredPlayerList, team1PLayers);
    }

    @Test
    void getRequestedPlayers() {
        MockLeague league = new MockLeague ();
        TradeModel trade = new TradeModel ();
        List<PlayerModel> team1PLayers = new ArrayList<> ();
        List<PlayerModel> requestedPlayerList = new ArrayList<> ();

        TeamsModel t1 = league.getTeamsObject1 ();
        PlayerModel p1 = t1.getPlayers ().get (0);
        team1PLayers.add (p1);
        trade.setOfferedPlayer (team1PLayers);

        requestedPlayerList = trade.getOfferedPlayer ();
        Assert.assertEquals (requestedPlayerList, team1PLayers);
    }

    @Test
    void setOfferedPlayer(){
        MockLeague league = new MockLeague ();
        TradeModel trade = new TradeModel ();
        List<PlayerModel> team1PLayers = new ArrayList<> ();
        List<PlayerModel> offeredPlayerList = new ArrayList<> ();

        TeamsModel t1 = league.getTeamsObject1 ();
        PlayerModel p1 = t1.getPlayers ().get (0);
        team1PLayers.add (p1);

        trade.setOfferedPlayer (team1PLayers);

        Assert.assertEquals (trade.getOfferedPlayer ().size (), 1);
    }

    @Test
    void setRequestedPlayers(){
        MockLeague league = new MockLeague ();
        TradeModel trade = new TradeModel ();
        List<PlayerModel> team1PLayers = new ArrayList<> ();
        List<PlayerModel> requestPlayerList = new ArrayList<> ();

        TeamsModel t1 = league.getTeamsObject1 ();
        PlayerModel p1 = t1.getPlayers ().get (0);
        team1PLayers.add (p1);

        trade.setRequestedPlayers (team1PLayers);
        Assert.assertEquals (trade.getRequestedPlayers ().size (), 1);
    }

}
