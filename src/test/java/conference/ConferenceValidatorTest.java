package conference;

import league.LeagueModel;
import league.LeagueModelTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConferenceValidatorTest {

    @Test
    void validateConferenceObject() {
        ConferenceModelTest conferenceModelTest = new ConferenceModelTest();
        ConferenceModel conferenceModel = ConferenceModelTest.getConferenceObject();
        ConferenceValidator conferenceValidator =new ConferenceValidator();
       assertTrue(conferenceValidator.validateConferenceObject(conferenceModel));
    }

    @Test
    void isConferenceExistTest(){
        LeagueModel leagueModel= LeagueModelTest.getLeagueObject();
        ConferenceValidator conferenceValidator = new ConferenceValidator();
        assertTrue(conferenceValidator.isConferenceExist(leagueModel,"Eastern Conference"));
        assertFalse(conferenceValidator.isConferenceExist(leagueModel,"No Conference"));
    }
}
