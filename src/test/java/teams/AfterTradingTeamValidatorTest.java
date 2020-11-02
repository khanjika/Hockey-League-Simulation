package teams;

import freeagent.FreeAgentModel;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import players.PlayerModel;
import trade.MockLeague;

import java.util.ArrayList;
import java.util.List;

public class AfterTradingTeamValidatorTest {

    AfterTradingTeamValidator validator = new AfterTradingTeamValidator ();

    @Test
    void isCaptainPresent() {
        List<PlayerModel> list = null;
        MockLeague league = new MockLeague ();

        TeamsModel t = league.getTeamsObject1 ();
        List<PlayerModel> listOfPlayers = t.getPlayers ();

        validator.isCaptainPresent (listOfPlayers);
        Assert.assertFalse (listOfPlayers.get (1).isCaptain ());
        Assert.assertTrue (listOfPlayers.get (0).isCaptain ());
    }

    @Test
    void addingFreeAgent() {
        PlayerModel p = new PlayerModel ();
        MockLeague league = new MockLeague ();

        List<FreeAgentModel> freeAgents = new ArrayList<> ();

        p.setPlayerName ("Khanjika");
        p.setPosition ("forward");
        p.setSaving (18);
        p.setChecking (10);
        p.setShooting (9);
        p.setSkating (8);
        freeAgents = validator.addingFreeAgent (p);

        Assert.assertEquals (freeAgents.size (), 1);
    }

    @Test
    void removeGoalies() {
        List<PlayerModel> player = new ArrayList<> ();
        MockLeague league = new MockLeague ();
        int counterGoalie = 2;

        TeamsModel t = league.getTeamsObject1 ();
        List<PlayerModel> p = t.getPlayers ();
        validator.removeGoalies (counterGoalie, p);

        Assert.assertEquals (p.size (), 4);
    }

    @Test
    void addingPlayer() {
        FreeAgentModel f = new FreeAgentModel ();
        MockLeague league = new MockLeague ();

        List<PlayerModel> playersList = new ArrayList<> ();

        f.setPlayerName ("Khanjika");
        f.setPosition ("forward");
        f.setSaving (18);
        f.setChecking (10);
        f.setShooting (9);
        f.setSkating (8);
        playersList = validator.addingPlayer (f);

        Assert.assertEquals (playersList.size (), 1);
    }

    @Test
    void removeSkaters() {
        List<PlayerModel> player = new ArrayList<> ();
        MockLeague league = new MockLeague ();
        int counterSkater = 18;

        TeamsModel t = league.getTeamsObject1 ();
        List<PlayerModel> p = t.getPlayers ();
        validator.removeSkaters (counterSkater, p);

        Assert.assertEquals (p.size (), 4);
    }

}
