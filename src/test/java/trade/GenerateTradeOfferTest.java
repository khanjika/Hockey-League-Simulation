//package trade;
//
//import leagueobjectmodel.TradingModel;
//import leagueobjectmodel.LeagueModel;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import leagueobjectmodel.TeamsModel;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class GenerateTradeOfferTest {
//
//    GenerateTradeOffer generateOffer = new GenerateTradeOffer();
//    TradingModel trade = new TradingModel();
//
//    @Test
//    void calculateLossPoint() {
//        MockLeague league = new MockLeague();
//
//        trade = MockLeague.getLeagueObject().getGameplayConfig().getTrading();
//        assertTrue(generateOffer.calculateLossPoint(9, trade));
//        assertFalse(generateOffer.calculateLossPoint(7, trade));
//    }
//
//    @Test
//    void makeTradeOffer() {
//        MockLeague league = new MockLeague();
//
//        trade = MockLeague.getLeagueObject().getGameplayConfig().getTrading();
//        trade.setRandomTradeOfferChance(2.0f);
//        assertTrue(generateOffer.makeTradeOffer(trade));
//    }
//
//    @Test
//    void checkTrading() {
//        MockLeague league = new MockLeague();
//        LeagueModel leagueModel = MockLeague.getLeagueObject();
//
//        leagueModel.getGameplayConfig().getTrading().setRandomAcceptanceChance(1);
//        leagueModel.getGameplayConfig().getTrading().setRandomTradeOfferChance(1);
//        leagueModel.getConferences().get(0).getDivisions().get(0).getTeams().get(0).setLossPoint(9);
//        leagueModel = generateOffer.checkTrading(leagueModel);
//
//        List<TeamsModel> t = leagueModel.getConferences().get(0).getDivisions().get(0).getTeams();
//
//        String team1Player1 = t.get(0).getPlayers().get(0).getPlayerName();
//        String team2Player1 = t.get(1).getPlayers().get(0).getPlayerName();
//        String team2Player2 = t.get(1).getPlayers().get(3).getPlayerName();
//
//        Assert.assertEquals(team2Player1, "C0");
//        Assert.assertEquals(team2Player2, "A0");
//    }
//}
