package leagueobjectmodel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class LeagueValidatorTest {

    @Test
    void validateLeagueObject() throws Exception {
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        LeagueValidator leagueValidator = new LeagueValidator();
        assertFalse(leagueValidator.validateLeagueObject(leagueModel));
    }
}
