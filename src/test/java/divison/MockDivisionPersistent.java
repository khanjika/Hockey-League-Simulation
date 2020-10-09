package divison;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MockDivisionPersistent {

    int addDivisionInformation() {
        return 1;
    }

    boolean isDivisionAlreadyExist(String divisionName, int conferenceId) {
        return true;
    }

    int getDivisionInformation(String divisionName, int conferenceId) {
        return 1;
    }
}
