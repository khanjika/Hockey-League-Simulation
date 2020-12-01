package leagueobjectmodel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DivisonValidatorTest {

    @Test
    void validateDivisionObjectTest() {
        IDivisonModel divisionModel = LeagueObjectModelFactoryAbstractTest.getInstance().getDivision();
        DivisonValidator divisonValidator = new DivisonValidator();
        assertFalse(divisonValidator.validateDivisionObject(divisionModel));
    }

}
