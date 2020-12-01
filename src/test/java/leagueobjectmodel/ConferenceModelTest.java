package leagueobjectmodel;

import LeagueMockObject.MockLeagueAbstractFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConferenceModelTest {
    IConferenceModel conferenceModel;

    @BeforeEach
    void initializeVariable() {
        conferenceModel = LeagueObjectModelFactoryAbstractTest.getInstance().getConference();
    }

    @Test
    void setDivisionsTest() {
        conferenceModel.setDivisions(new ArrayList<IDivisonModel>());
        assertNotNull(conferenceModel.getDivisions(), "Failed to set Divisions in Conference object");
    }

    @Test
    void getDivisionsTest() {
        conferenceModel.setDivisions(new ArrayList<IDivisonModel>());
        assertNotNull(conferenceModel.getDivisions(), "Failed to get Divisions in Conference object");
    }

    @Test
    void setConferenceNameTest() {
        conferenceModel.setConferenceName("Conference one");
        assertEquals("Conference one", conferenceModel.getConferenceName(), "Failed to set conference name");
    }

    @Test
    void getConferenceNameTest() {
        conferenceModel.setConferenceName("Conference one");
        assertEquals("Conference one", conferenceModel.getConferenceName(), "Failed to get conference name");
    }


    public static ConferenceModel getConferenceObject() {
        ConferenceModel conferenceModel = new ConferenceModel();
        conferenceModel.setConferenceName("Eastern Conference");
        List<IDivisonModel> divisionModelObjectList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IDivisonModel divisonModel = LeagueObjectModelFactoryAbstractTest.getInstance().getDivision();
            divisionModelObjectList.add(divisonModel);
        }
        conferenceModel.setDivisions(divisionModelObjectList);
        return conferenceModel;
    }
}
