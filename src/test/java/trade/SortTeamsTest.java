package trade;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import players.PlayerModel;
import teams.TeamsModel;

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
}
