package conference;

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
}