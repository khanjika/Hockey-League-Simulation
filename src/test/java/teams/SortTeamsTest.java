package teams;

import freeagent.FreeAgentModel;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import players.PlayerModel;
import trade.MockLeague;

import java.util.List;

public class SortTeamsTest {

    SortTeams sort = new SortTeams ();

    @Test
    void sortPlayersAscending() {
        MockLeague league = new MockLeague ();
        TeamsModel t = league.getTeamsObject1 ();

        List<PlayerModel> list = t.getPlayers ();
        list = sort.sortPlayersAscending (list);
        Assert.assertTrue (list.get (0).getPlayerStrength () <= list.get (1).getPlayerStrength ());
    }

    @Test
    void sortPlayersDescending() {
        MockLeague league = new MockLeague ();
        TeamsModel t = league.getTeamsObject1 ();

        List<PlayerModel> list = t.getPlayers ();
        list = sort.sortPlayersDescending (list);
        Assert.assertTrue (list.get (0).getPlayerStrength () >= list.get (1).getPlayerStrength ());
    }

    @Test
    void sortFreeAgentDescending() {
        MockLeague league = new MockLeague ();
        List<FreeAgentModel> list = league.getLeagueObject ().getFreeAgents ();

        list = sort.sortFreeAgentDescending (list);
        Assert.assertTrue (list.get (0).getFreeAgentStrength () >= list.get (1).getFreeAgentStrength ());
    }
}
