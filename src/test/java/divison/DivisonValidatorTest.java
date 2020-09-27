package divison;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisonValidatorTest {

    @Test
    void validateDivisionObject() {
        DivisonModelTest divisonModelTest = new DivisonModelTest();
        DivisonModel divisonModel=divisonModelTest.getDivisionObject();
        DivisonValidator divisonValidator = new DivisonValidator();
        assertTrue(divisonValidator.validateDivisionObject(divisonModel));
    }
}