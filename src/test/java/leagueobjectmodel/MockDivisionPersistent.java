package leagueobjectmodel;

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
