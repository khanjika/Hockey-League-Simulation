package statemachine.trophysystem;

import LeagueMockObject.MockLeagueAbstractFactory;
import leagueobjectmodel.ILeagueModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

public class TrophySystemTest {

    ITrophySystem trophySystem = TrophySystemAbstractFactoryTest.instance().createTrophySystem();
    ILeagueModel leagueModel = MockLeagueAbstractFactory.getMockInstance().createLeague();

    void performCalculationBeforePlayOff(){
        trophySystem.performCalculationBeforePlayOff(leagueModel,2000);
        trophySystem.performCalculationBeforePlayOff(leagueModel,2001);
    }

    void performCalculationAfterPlayOff(){
        trophySystem.performCalculationAfterPlayOff(leagueModel,2000);
        trophySystem.performCalculationAfterPlayOff(leagueModel,2001);
    }

    void awardWinners(){
        trophySystem.awardWinners();
    }

    @Test
    void TrophySystemTest(){
        try {
            performCalculationBeforePlayOff();
            performCalculationAfterPlayOff();
            awardWinners();
        }catch (Exception e){
            fail("Error while notifying observers");
        }
    }
}
