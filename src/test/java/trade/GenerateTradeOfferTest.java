package trade;

import gameplayconfig.TradingModel;
import league.LeagueModel;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import teams.TeamsModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateTradeOfferTest {

    GenerateTradeOffer generateOffer = new GenerateTradeOffer ();
    TradingModel trade = new TradingModel ();

    @Test
    void calculateLossPoint() {
        MockLeague league = new MockLeague ();

        trade = league.getLeagueObject ().getGameplayConfig ().getTrading ();
        assertTrue (generateOffer.calculateLossPoint (9, trade));
        assertFalse (generateOffer.calculateLossPoint (7, trade));
    }

    @Test
    void makeTradeOffer() {
        MockLeague league = new MockLeague ();

        trade = league.getLeagueObject ().getGameplayConfig ().getTrading ();
        trade.setRandomTradeOfferChance (2.0f);
        assertTrue (generateOffer.makeTradeOffer (trade));
    }

    @Test
    void checkTrading() {
        MockLeague league = new MockLeague ();
        LeagueModel leagueModel = league.getLeagueObject ();

        leagueModel.getGameplayConfig ().getTrading ().setRandomAcceptanceChance (1);
        leagueModel.getGameplayConfig ().getTrading ().setRandomTradeOfferChance (1);
        leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0).setLossPoint (9);
        leagueModel =generateOffer.checkTrading (leagueModel);

        List<TeamsModel> t = leagueModel.getConferences ().get (0).getDivisions ().get (0).getTeams ();
        String team1Player1 = t.get (0).getPlayers ().get (0).getPlayerName ();
        String team1Player2 = t.get (0).getPlayers ().get (3).getPlayerName ();

        String team2Player1 = t.get (1).getPlayers ().get (0).getPlayerName ();
        String team2Player2 = t.get (1).getPlayers ().get (3).getPlayerName ();

        Assert.assertEquals (team1Player1,"A0");
        Assert.assertEquals (team1Player2,"C0");
        Assert.assertEquals (team2Player1,"C0");
        Assert.assertEquals (team2Player2,"A0");
    }
}
