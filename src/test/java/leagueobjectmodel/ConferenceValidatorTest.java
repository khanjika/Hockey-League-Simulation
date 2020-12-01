package leagueobjectmodel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConferenceValidatorTest {

    @Test
    void validateConferenceObject() {
        ConferenceModelTest conferenceModelTest = new ConferenceModelTest();
        ConferenceModel conferenceModel = ConferenceModelTest.getConferenceObject();
        ConferenceValidator conferenceValidator = new ConferenceValidator();
        assertFalse(conferenceValidator.validateConferenceObject(conferenceModel));
    }
}
