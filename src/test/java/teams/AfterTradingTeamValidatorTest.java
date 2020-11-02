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
        Assert.assertTrue (listOfPlayers.get (0).isCaptain ());
        Assert.assertFalse (listOfPlayers.get (1).isCaptain ());
        Assert.assertFalse (listOfPlayers.get (2).isCaptain ());
        Assert.assertFalse (listOfPlayers.get (3).isCaptain ());
    }

    @Test
    void addingFreeAgent() {
        PlayerModel p = new PlayerModel ();
        MockLeague league = new MockLeague ();
        List<FreeAgentModel> freeAgents = new ArrayList<> ();
        freeAgents = league.getLeagueObject ().getFreeAgents ();

        p.setPlayerName ("Khanjika");
        p.setPosition ("forward");
        p.setSaving (18);
        p.setChecking (10);
        p.setShooting (9);
        p.setSkating (8);
        freeAgents = validator.addingFreeAgent (p, freeAgents);

        Assert.assertEquals (freeAgents.size (), 13);
    }

    @Test
    void addingPlayer() {
        FreeAgentModel f = new FreeAgentModel ();
        MockLeague league = new MockLeague ();
        List<PlayerModel> playersList = new ArrayList<> ();

        playersList = league.getLeagueObject ().getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0).getPlayers ();

        f.setPlayerName ("Khanjika");
        f.setPosition ("forward");
        f.setSaving (18);
        f.setChecking (10);
        f.setShooting (9);
        f.setSkating (8);
        playersList = validator.addingPlayer (f, playersList);

        Assert.assertEquals (playersList.size (), 5);
    }

    @Test
    void removeGoalies() {
        MockLeague league = new MockLeague ();
        List<PlayerModel> playersList = new ArrayList<> ();
        List<FreeAgentModel> freeAgents = new ArrayList ();

        playersList = league.getLeagueObject ().getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0).getPlayers ();
        freeAgents = league.getLeagueObject ().getFreeAgents ();
        int noOfGoaliesRemoved = 1;
        validator.removeGoalies (noOfGoaliesRemoved, playersList, freeAgents);

        Assert.assertEquals (freeAgents.size (), 13);
        Assert.assertEquals (playersList.size (), 3);
    }

    @Test
    void removeSkaters() {
        MockLeague league = new MockLeague ();
        List<PlayerModel> playersList = new ArrayList<> ();
        List<FreeAgentModel> freeAgents = new ArrayList ();

        playersList = league.getLeagueObject ().getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0).getPlayers ();
        freeAgents = league.getLeagueObject ().getFreeAgents ();
        int noOfSkatersRemoved = 1;

        validator.removeSkaters (noOfSkatersRemoved, playersList, freeAgents);

        Assert.assertEquals (playersList.size (), 3);
        Assert.assertEquals (freeAgents.size (), 13);
    }
}