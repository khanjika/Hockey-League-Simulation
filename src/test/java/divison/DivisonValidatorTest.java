package divison;

import league.LeagueModel;
import league.LeagueModelTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DivisonValidatorTest {

    @Test
    void validateDivisionObjectTest() {
        DivisonModel divisonModel = DivisonModelTest.getDivisionObject();
        DivisonValidator divisonValidator = new DivisonValidator();
        assertTrue(divisonValidator.validateDivisionObject(divisonModel));
    }

    @Test
    void isDivisionExistTest() {
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        DivisonValidator divisonValidator = new DivisonValidator();
        assertTrue(divisonValidator.isDivisionExist(leagueModel, "Atlantic"));
        assertFalse(divisonValidator.isDivisionExist(leagueModel, "XYZ"));
    }
}
