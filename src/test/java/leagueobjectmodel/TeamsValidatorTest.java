package leagueobjectmodel;

import LeagueMockObject.ModelMock;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TeamsValidatorTest {

    ModelMock mock = new ModelMock ();
    ITeamsValidator validator = LeagueObjectModelAbstractFactory.getInstance ().getTeamsValidator ();
    ITeamsModel teamsModel = mock.teamModel ();
    ILeagueModel league = mock.leagueModel ();

    @Test
    void isCaptainPresent() {
        List<PlayerModel> list = teamsModel.getPlayers ();
        list.get (0).setCaptain (true);
        list.get (1).setCaptain (true);
        validator.isCaptainPresent (list);

        Assert.assertTrue (list.get (0).isCaptain ());
        Assert.assertFalse (list.get (1).isCaptain ());
        Assert.assertFalse (list.get (2).isCaptain ());
        Assert.assertFalse (list.get (3).isCaptain ());
    }

    @Test
    void NoOfPlayersInTeam() {
        ITeamsModel team = league.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0);
        List<PlayerModel> list = team.getPlayers ();
        list.remove (0);
        league = validator.NoOfPlayersInTeam (list, league);

        ITeamsModel team1 = league.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0);
        Assert.assertEquals (team1.getPlayers ().size (), 30);
    }

    @Test
    void addingPlayer() {
        List<IFreeAgentModel> freeAgentList = mock.leagueModel ().getFreeAgents ();
        IFreeAgentModel freeAgent = freeAgentList.get (0);
        ITeamsModel team = league.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0);
        List<PlayerModel> list = team.getPlayers ();

        list = validator.addingPlayer (freeAgent, list);
        Assert.assertEquals (list.size (), 31);
    }

    @Test
    void addingFreeAgent() {
        List<IFreeAgentModel> freeAgentList = mock.leagueModel ().getFreeAgents ();
        ITeamsModel team = league.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0);
        PlayerModel player = team.getPlayers ().get (0);

        freeAgentList = validator.addingFreeAgent (player, freeAgentList);
        Assert.assertEquals (freeAgentList.size (), 83);
    }
}
