package trade;

import gameplayconfig.TradingModel;
import league.LeagueModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateTradeOfferTest {

    GenerateTradeOffer generateOffer = new GenerateTradeOffer ();

    @Test
    void calculateLossPoint() {
        MockLeague league = new MockLeague ();
        TradingModel trade = new TradingModel ();

        trade = league.getLeagueObject ().getGameplayConfig ().getTrading ();
        assertTrue (generateOffer.calculateLossPoint (9, trade));
        assertFalse (generateOffer.calculateLossPoint (7, trade));
    }

    @Test
    void makeTradeOffer() {
        MockLeague league = new MockLeague ();
        TradingModel trade = new TradingModel ();

        trade = league.getLeagueObject ().getGameplayConfig ().getTrading ();
        trade.setRandomTradeOfferChance (2.0f);
        assertTrue (generateOffer.makeTradeOffer (trade));
    }

    @Test
    void checkTrading() {
        MockLeague league = new MockLeague ();
        LeagueModel leagueModel = league.getLeagueObject ();
        assertFalse (generateOffer.checkTrading (leagueModel));
    }

}
