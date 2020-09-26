package conference;

import divison.DivisonModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ConferenceModelTest {

    @Test
    void setDivisionsTest(){
        ConferenceModel conferenceModel = new ConferenceModel();
        conferenceModel.setDivisions(new ArrayList<DivisonModel>());
        assertNotNull(conferenceModel.getDivisions(),"Failed to set Divisions in Conference object");
    }

    @Test
    void getDivisionsTest(){
        ConferenceModel conferenceModel = new ConferenceModel();
        conferenceModel.setDivisions(new ArrayList<DivisonModel>());
        assertNotNull(conferenceModel.getDivisions(),"Failed to get Divisions in Conference object");
    }

    @Test
    void setConferenceNameTest(){
        ConferenceModel conferenceModel = new ConferenceModel();
        conferenceModel.setConferenceName("Conference one");
        assertEquals("Conference one",conferenceModel.getConferenceName(),"Failed to set conference name");
    }

    @Test
    void getConferenceNameTest(){
        ConferenceModel conferenceModel = new ConferenceModel();
        conferenceModel.setConferenceName("Conference one");
        assertEquals("Conference one",conferenceModel.getConferenceName(),"Failed to get conference name");
    }
}