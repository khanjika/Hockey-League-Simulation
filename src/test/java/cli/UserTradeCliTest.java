package cli;

import org.junit.jupiter.api.Test;
import players.PlayerModel;
import teams.TeamsModel;
import trade.MockLeague;
import trade.TradeModel;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTradeCliTest {
    @Test
    void displayTeamDetailsTest(){
        ByteArrayInputStream userinput = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(userinput);
        UserTradeCli userTradeCli = new UserTradeCli();
        TradeModel trade = tradeMock();
        int value = userTradeCli.displayTeamDetails(trade);
        assertEquals(value,1);
    }
    @Test
    TradeModel tradeMock(){
        MockLeague league = new MockLeague ();
        TradeModel trade = new TradeModel ();
        List<PlayerModel> team1PLayers = new ArrayList<>();
        List<PlayerModel> team2PLayers = new ArrayList<> ();

        TeamsModel t1 = league.getTeamsObject1 ();
        PlayerModel p1 = t1.getPlayers ().get (0);
        team1PLayers.add (p1);
        trade.setRequestedPlayers (team1PLayers);

        TeamsModel t2 = league.getTeamsObject2 ();
        PlayerModel p2 = t2.getPlayers ().get (0);
        team2PLayers.add (p2);
        trade.setOfferedPlayer (team2PLayers);
        return trade;
    }
}
