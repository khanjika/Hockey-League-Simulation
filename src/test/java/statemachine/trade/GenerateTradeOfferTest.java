package statemachine.trade;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.ITradingModel;
import LeagueMockObject.ModelMock;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateTradeOfferTest {

    IGenerateTradeOffer gen = TradeAbstractFactory.instance ().createTradeOffer ();
    ModelMock mock = new ModelMock ();

    @Test
    void calculateLossPoint() {
        ITradingModel tradeModel = mock.tradeModel ();
        assertTrue (gen.calculateLossPoint (9, tradeModel));
        assertFalse (gen.calculateLossPoint (6, tradeModel));
    }

    @Test
    void calculateTradeChance() {
        ITeamsModel teamModel = mock.teamModel ();
        ITradingModel tradeModel = mock.tradeModel ();
        tradeModel.setRandomTradeOfferChance (2.0f);
        assertTrue (gen.calculateTradeChance (tradeModel, teamModel));
    }


    @Test
    void checkTrading() {
        IGenerateTradeOffer gen = TradeAbstractFactory.instance ().createTradeOffer ();
        ILeagueModel league = mock.leagueModel ();
        league.getGameplayConfig ().getTrading ().setRandomAcceptanceChance (1);
        league.getGameplayConfig ().getTrading ().setRandomTradeOfferChance (1);
        league.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1).setLossPoint (9);

        league = gen.checkTrading (league);
        String playerName = league.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1).getPlayers ().get (10).getPlayerName ();

        Assert.assertEquals (playerName, "Mary Halen");
    }
}
