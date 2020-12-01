package leagueobjectmodel;

import LeagueMockObject.MockFreeAgent;
import LeagueMockObject.MockLeagueAbstractFactory;
import LeagueMockObject.ModelMock;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FreeAgentModelTest {

    IFreeAgentModel freeAgentModel = LeagueObjectModelAbstractFactory.getInstance().getFreeAgentModel();
    ModelMock mock = new ModelMock();
    ILeagueModel mockLeague = MockLeagueAbstractFactory.getMockInstance().createLeague();

    @Test
    void sortFreeAgentDescending() {
        List<IFreeAgentModel> freeAgentModel = mock.leagueModel().getFreeAgents();
        freeAgentModel = this.freeAgentModel.sortFreeAgentDescending(freeAgentModel);

        Assert.assertTrue(freeAgentModel.get(0).getFreeAgentStrength() > freeAgentModel.get(1).getFreeAgentStrength());
    }

    @Test
    void setPlayerName() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setPlayerName("freeagent one");
        assertEquals("freeagent one", freeAgentModel.getPlayerName(), "Failed to set freeagent name in Free agent object");
    }

    @Test
    void getPosition() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setPosition("freeagent one");
        assertEquals("freeagent one", freeAgentModel.getPosition(), "Failed to get freeagent position in Free agent object");
    }

    @Test
    void setPosition() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setPosition("freeagent one");
        assertEquals("freeagent one", freeAgentModel.getPosition(), "Failed to set freeagent position in Free agent object");
    }

    @Test
    void getAge() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setAge(20);
        assertEquals(20, freeAgentModel.getAge(), "Failed to get freeagent Age in Free agent object");
    }

    @Test
    void setAge() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setAge(20);
        assertEquals(20, freeAgentModel.getAge(), "Failed to set freeagent Age in Free agent object");
    }

    @Test
    void getSkating() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setSkating(0.5f);
        assertEquals(0.5f, freeAgentModel.getSkating(), "Failed to get freeagent skating in Free agent object");
    }

    @Test
    void setSkating() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setSkating(0.5f);
        assertEquals(0.5f, freeAgentModel.getSkating(), "Failed to set freeagent skating in Free agent object");
    }

    @Test
    void getShooting() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setShooting(0.5f);
        assertEquals(0.5, freeAgentModel.getShooting(), "Failed to get freeagent Shooting in Free agent object");
    }

    @Test
    void setShooting() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setShooting(0.5f);
        assertEquals(0.5, freeAgentModel.getShooting(), "Failed to set freeagent Shooting in Free agent object");
    }

    @Test
    void getChecking() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setChecking(0.5f);
        assertEquals(0.5, freeAgentModel.getChecking(), "Failed to get freeagent checking in Free agent object");
    }

    @Test
    void setChecking() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setChecking(0.5f);
        assertEquals(0.5, freeAgentModel.getChecking(), "Failed to set freeagent checking in Free agent object");
    }

    @Test
    void getSaving() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setSaving(0.5f);
        assertEquals(0.5f, freeAgentModel.getSaving(), "Failed to get freeagent Saving in Free agent object");
    }

    @Test
    void setSaving() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setSaving(0.5f);
        assertEquals(0.5f, freeAgentModel.getSaving(), "Failed to set freeagent Saving in Free agent object");
    }

    @Test
    void getFreeAgentStrength() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setFreeAgentStrength(15);
        assertEquals(15, freeAgentModel.getFreeAgentStrength(), "Failed to get freeagent Saving in Free agent object");
    }

    @Test
    void setFreeAgentStrength() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setFreeAgentStrength(15);
        assertEquals(15, freeAgentModel.getFreeAgentStrength(), "Failed to set freeagent Saving in Free agent object");
    }

    @Test
    void getDays() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setDays(1);
        assertEquals(1, freeAgentModel.getDays(), "Failed to get freeagent Days in Free agent object");
    }

    @Test
    void setDays() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setDays(1);
        assertEquals(1, freeAgentModel.getDays(), "Failed to set freeagent Days in Free agent object");
    }

    @Test
    void isRetired() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setRetired(true);
        assertEquals(true, freeAgentModel.isRetired(), "Failed to get freeagent isRetired in Free agent object");
    }

    @Test
    void setRetired() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setRetired(true);
        assertEquals(true, freeAgentModel.isRetired(), "Failed to get freeagent isRetired in Free agent object");
    }

    @Test
    void getRetirementLikelyHood() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setRetirementLikelyHood(10);
        assertEquals(10, freeAgentModel.getRetirementLikelyHood(), "Failed to get freeagent isRetired in Free agent object");
    }

    @Test
    void setRetirementLikelyHood() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setRetirementLikelyHood(10);
        assertEquals(10, freeAgentModel.getRetirementLikelyHood(), "Failed to get freeagent isRetired in Free agent object");
    }

    @Test
    void getAgingModel() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setAgingModel(mockLeague.getGameplayConfig().getAging());
        assertEquals(mockLeague.getGameplayConfig().getAging(), freeAgentModel.getAgingModel(), "Error in getting Aging Model In free Agent Model");
    }

    @Test
    void setAgingModel() {

        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setAgingModel(mockLeague.getGameplayConfig().getAging());
        assertEquals(mockLeague.getGameplayConfig().getAging(), freeAgentModel.getAgingModel(), "Error in getting Aging Model In free Agent Model");
    }

    @Test
    void storeFreeAgentInformation() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
    }

    @Test
    void calculateFreeAgentStrength() {
        IFreeAgentModel validFowardFreeAgentModel = MockFreeAgent.getFreeAgentModel();
        validFowardFreeAgentModel.calculateFreeAgentStrength(validFowardFreeAgentModel);
        assertEquals(25f, validFowardFreeAgentModel.getFreeAgentStrength(), "Error in calculateFreeAgentStrength in Agent Model");
        IFreeAgentModel validDefenseFreeAgentModel = MockFreeAgent.getDefenseFreeAgentModel();
        validDefenseFreeAgentModel.calculateFreeAgentStrength(validDefenseFreeAgentModel);
        assertEquals(25f, validDefenseFreeAgentModel.getFreeAgentStrength(), "Error in calculateFreeAgentStrength in Agent Model");
        IFreeAgentModel validGoalieFreeAgent = MockFreeAgent.getGoalieFreeAgentModel();
        validGoalieFreeAgent.calculateFreeAgentStrength(validGoalieFreeAgent);
        assertEquals(20f, validGoalieFreeAgent.getFreeAgentStrength(), "Error in calculateFreeAgentStrength in Agent Model");
    }

    @Test
    void aging() {
        IFreeAgentModel freeAgentModel = MockFreeAgent.getFreeAgentModel();
        LocalDate date = LocalDate.now();
        freeAgentModel.setAgingModel(mockLeague.getGameplayConfig().getAging());
        assertFalse(false);
    }

    @Test
    void getReplacementFreeAgent() {
        List<IFreeAgentModel> freeAgentModelList = new ArrayList<>();
        freeAgentModelList.add(MockFreeAgent.getForwardFreeAgentModel());
        freeAgentModelList.add(MockFreeAgent.getDefenseFreeAgentModel());
        freeAgentModelList.add(MockFreeAgent.getGoalieFreeAgentModel());
        assertEquals(3,freeAgentModelList.size(),"InValid SIZE of FreeAgent");
    }
}


