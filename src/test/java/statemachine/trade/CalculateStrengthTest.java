package statemachine.trade;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.PlayerModel;
import LeagueMockObject.ModelMock;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class CalculateStrengthTest {

    ICalculateStrength calculateStrength = TradeAbstractFactory.instance ().createStrength ();
    ModelMock mock = new ModelMock ();

    private enum playerPosition {
        forward,
        defense,
        goalie
    }

    @Test
    void totalStrengthCounter() {
        ILeagueModel league = mock.leagueModel ();
        ITeamsModel teamModel = mock.teamModel ();
        HashMap strength = calculateStrength.findPositionStrength (teamModel);
        int totalCounter = calculateStrength.totalStrengthCounter (teamModel, strength, league);
        Assert.assertEquals (totalCounter, 2);
    }

    @Test
    void findPositionStrength() {
        ITeamsModel teamModel = mock.teamModel ();
        HashMap strength = calculateStrength.findPositionStrength (teamModel);
        float forwardStrength = (float) strength.get (playerPosition.forward.toString ());
        float defenseStrength = (float) strength.get (playerPosition.defense.toString ());
        float goalieStrength = (float) strength.get (playerPosition.goalie.toString ());
        Assert.assertNotNull (forwardStrength);
        Assert.assertNotNull (defenseStrength);
        Assert.assertNotNull (goalieStrength);
    }

    @Test
    void findTeamStrength() {
        List<PlayerModel> playerList = mock.playerList ();
        float strength = calculateStrength.findTeamStrength (playerList);
        Assert.assertNotNull (strength);
    }
}
