package conference;

import divison.DivisonModel;
import divison.DivisonModelTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConferenceModelTest {

    @Test
    void setDivisionsTest() {
        ConferenceModel conferenceModel = new ConferenceModel();
        conferenceModel.setDivisions(new ArrayList<DivisonModel>());
        assertNotNull(conferenceModel.getDivisions(), "Failed to set Divisions in Conference object");
    }

    @Test
    void getDivisionsTest() {
        ConferenceModel conferenceModel = new ConferenceModel();
        conferenceModel.setDivisions(new ArrayList<DivisonModel>());
        assertNotNull(conferenceModel.getDivisions(), "Failed to get Divisions in Conference object");
    }

    @Test
    void setConferenceNameTest() {
        ConferenceModel conferenceModel = new ConferenceModel();
        conferenceModel.setConferenceName("Conference one");
        assertEquals("Conference one", conferenceModel.getConferenceName(), "Failed to set conference name");
    }

    @Test
    void getConferenceNameTest() {
        ConferenceModel conferenceModel = new ConferenceModel();
        conferenceModel.setConferenceName("Conference one");
        assertEquals("Conference one", conferenceModel.getConferenceName(), "Failed to get conference name");
    }

    @Test
    void isConferenceAlreadyExist() {
        ModelConferencePersistent mock = new ModelConferencePersistent();
        assertTrue(mock.isConferenceAlreadyExist("Eastern Conference"));
    }

    @Test
    void getConferenceId() {
        ModelConferencePersistent mock = new ModelConferencePersistent();
        assertEquals(mock.getConferenceInformation("Easter", 1), 1);
    }

    @Test
    void storeConferenceInformation() {
        ModelConferencePersistent mock = new ModelConferencePersistent();
        assertEquals(1, mock.addConferenceInformation());
    }


    public static ConferenceModel getConferenceObject() {
        ConferenceModel conferenceModel = new ConferenceModel();
        conferenceModel.setConferenceName("Eastern Conference");
        List<DivisonModel> divisionModelObjectList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            DivisonModel divisonModel = DivisonModelTest.getDivisionObject();
            divisionModelObjectList.add(divisonModel);
        }
        conferenceModel.setDivisions(divisionModelObjectList);
        return conferenceModel;
    }
}
