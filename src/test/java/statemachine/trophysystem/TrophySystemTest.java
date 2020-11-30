package statemachine.trophysystem;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueModelTest;
import org.junit.jupiter.api.Test;

public class TrophySystemTest {

    ITrophySystem trophySystem = TrophySystemAbstractFactory.getInstance().getTrophySystem();
    ILeagueModel leagueModel = LeagueModelTest.getLeagueObject();

    @Test
    void performCalculationBeforePlayOffTest(){
        trophySystem.performCalculationBeforePlayOff(leagueModel, 2001);
        trophySystem.performCalculationBeforePlayOff(leagueModel,2002);
    }

    @Test
    void performCalculationAfterPlayOffTest(){
        trophySystem.performCalculationAfterPlayOff(leagueModel,2001);
        trophySystem.performCalculationAfterPlayOff(leagueModel,2002);
    }
//
//    @Test
//    void awardWinnersTest(){
//        trophySystem.awardWinners();
//    }
}
