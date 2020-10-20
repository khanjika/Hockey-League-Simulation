package trade;
import league.LeagueModel;
import league.LeagueModelTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GenerateTradeOfferTest {

    @Test
    void checkTrading(){
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        GenerateTradeOffer generateOffer = new GenerateTradeOffer ();
        assertFalse (generateOffer.checkTrading (leagueModel));
    }
}
