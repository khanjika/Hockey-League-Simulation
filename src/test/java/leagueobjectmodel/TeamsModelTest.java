package leagueobjectmodel;

import LeagueMockObject.ModelMock;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TeamsModelTest {

    ITeamsModel teamModel = LeagueObjectModelAbstractFactory.getInstance ().getTeams ();
    ModelMock mock = new ModelMock ();

    @Test
    void sortPlayersOfTeamAscending() {
        List<PlayerModel> playerList = mock.teamModel ().getPlayers ();
        teamModel.sortPlayersOfTeamAscending (playerList);

        Assert.assertTrue (playerList.get (0).getPlayerStrength () < playerList.get (1).getPlayerStrength ());
    }

    @Test
    void sortPlayersOfTeamDescending() {
        List<PlayerModel> playerList = mock.teamModel ().getPlayers ();
        teamModel.sortPlayersOfTeamDescending (playerList);

        Assert.assertTrue (playerList.get (0).getPlayerStrength () > playerList.get (1).getPlayerStrength ());
    }
}
