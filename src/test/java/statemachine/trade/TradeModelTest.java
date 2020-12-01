package statemachine.trade;

import leagueobjectmodel.PlayerModel;
import LeagueMockObject.ModelMock;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TradeModelTest {

    ModelMock mock = new ModelMock ();
    ITradeModel model = TradeAbstractFactory.instance ().createTradeModel ();

    @Test
    void getOfferedPlayer() {
        model.setOfferedPlayer (mock.playerList ());
        List<PlayerModel> offeredPlayerList;
        List<PlayerModel> playersList = mock.playerList ();

        offeredPlayerList = model.getOfferedPlayer ();
        Assert.assertEquals (offeredPlayerList.size (), playersList.size ());
    }

    @Test
    void getRequestedPlayers() {
        model.setRequestedPlayers (mock.playerList ());
        List<PlayerModel> requestedPlayerList;
        List<PlayerModel> playersList = mock.playerList ();

        requestedPlayerList = model.getRequestedPlayers ();
        Assert.assertEquals (requestedPlayerList.size (), playersList.size ());
    }

    @Test
    void setOfferedPlayer() {
        model.setOfferedPlayer (mock.playerList ());

        Assert.assertEquals (model.getOfferedPlayer ().size (), 2);
    }

    @Test
    void setRequestedPlayers() {
        model.setRequestedPlayers (mock.playerList ());

        Assert.assertEquals (model.getRequestedPlayers ().size (), 2);
    }

}
