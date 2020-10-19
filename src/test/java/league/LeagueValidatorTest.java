package league;

import conference.ConferenceModel;
import conference.ConferenceModelTest;
import conference.ConferenceValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeagueValidatorTest {

    @Test
    void validateLeagueObject() {
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        LeagueValidator leagueValidator =new LeagueValidator();
        //update to true
        assertFalse(leagueValidator.validateLeagueObject(leagueModel));
    }
}