package divison;

import league.LeagueModel;
import league.LeagueModelTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisonValidatorTest {

    @Test
    void validateDivisionObjectTest() {
        DivisonModel divisonModel=DivisonModelTest.getDivisionObject();
        DivisonValidator divisonValidator = new DivisonValidator();
        //need to update to true
        assertFalse(divisonValidator.validateDivisionObject(divisonModel));
    }

    @Test
    void isDivisionExistTest()
    {
            LeagueModel leagueModel= LeagueModelTest.getLeagueObject();
            DivisonValidator divisonValidator=new DivisonValidator();
            assertTrue(divisonValidator.isDivisionExist(leagueModel,"Atlantic"));
            assertFalse(divisonValidator.isDivisionExist(leagueModel,"XYZ"));
    }
}
