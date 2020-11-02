package league;

import conference.ConferenceModel;
import conference.ConferenceModelTest;
import conference.ConferenceValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeagueValidatorTest {

    @Test
    void validateLeagueObject() throws Exception {
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        LeagueValidator leagueValidator =new LeagueValidator();
        //update to true
        assertTrue(leagueValidator.validateLeagueObject(leagueModel));
    }
}