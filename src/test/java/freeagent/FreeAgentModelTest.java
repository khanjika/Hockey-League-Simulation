package freeagent;

import league.LeagueModel;
import mock.MockFreeAgent;
import org.junit.jupiter.api.Test;
import trade.MockLeague;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreeAgentModelTest {

    @Test
    void getPlayerName() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setPlayerName("freeagent one");
        assertEquals("freeagent one", freeAgentModel.getPlayerName(), "Failed to get freeagent name in Free agent object");
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
        MockLeague leagueModel = new MockLeague();
        LeagueModel leagueModel1 = leagueModel.getLeagueObject();
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setAgingModel(leagueModel1.getGameplayConfig().getAging());
        assertEquals(leagueModel1.getGameplayConfig().getAging(), freeAgentModel.getAgingModel(), "Error in getting Aging Model In free Agent Model");
    }

    @Test
    void setAgingModel() {
        MockLeague leagueModel = new MockLeague();
        LeagueModel leagueModel1 = leagueModel.getLeagueObject();
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setAgingModel(leagueModel1.getGameplayConfig().getAging());
        assertEquals(leagueModel1.getGameplayConfig().getAging(), freeAgentModel.getAgingModel(), "Error in getting Aging Model In free Agent Model");
    }

    @Test
    void storeFreeAgentInformation() {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
    }

    @Test
    void calculateFreeAgentStrength() {
        FreeAgentModel validFowardFreeAgentModel = MockFreeAgent.getFreeAgentModel();
        validFowardFreeAgentModel.calculateFreeAgentStrength(validFowardFreeAgentModel);
        assertEquals(25f, validFowardFreeAgentModel.getFreeAgentStrength(), "Error in calculateFreeAgentStrength in Agent Model");
        FreeAgentModel validDefenseFreeAgentModel = MockFreeAgent.getDefenseFreeAgentModel();
        validDefenseFreeAgentModel.calculateFreeAgentStrength(validDefenseFreeAgentModel);
        assertEquals(25f, validDefenseFreeAgentModel.getFreeAgentStrength(), "Error in calculateFreeAgentStrength in Agent Model");
        FreeAgentModel validGoalieFreeAgent = MockFreeAgent.getGoalieFreeAgentModel();
        validGoalieFreeAgent.calculateFreeAgentStrength(validGoalieFreeAgent);
        assertEquals(20f, validGoalieFreeAgent.getFreeAgentStrength(), "Error in calculateFreeAgentStrength in Agent Model");
    }

    @Test
    void aging() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = league.getLeagueObject();
        FreeAgentModel freeAgentModel = MockFreeAgent.getFreeAgentModel();
        freeAgentModel.setAgingModel(leagueModel.getGameplayConfig().getAging());
        freeAgentModel.aging(freeAgentModel, 1);
        assertEquals(1, freeAgentModel.getDays(), "Error in aging method of FreeAgentModel");
        freeAgentModel.aging(freeAgentModel, 365);
        assertEquals(26, freeAgentModel.getAge(), "Error in aging method of FreeAgentModel");
        assertEquals(false, freeAgentModel.isRetired(), "Error in aging method of FreeAgentModel");
    }

    @Test
    void getReplacementFreeAgent() {
        List<FreeAgentModel> freeAgentModelList = new ArrayList<FreeAgentModel>();
        freeAgentModelList.add(MockFreeAgent.getForwardFreeAgentModel());
        freeAgentModelList.add(MockFreeAgent.getDefenseFreeAgentModel());
        freeAgentModelList.add(MockFreeAgent.getGoalieFreeAgentModel());
        System.out.println(freeAgentModelList);
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        FreeAgentModel replacement = freeAgentModel.getReplacementFreeAgent(freeAgentModelList, "forward");
        assertEquals(freeAgentModelList.get(0).getPlayerName(), replacement.getPlayerName(), "Error in getReplacementFreeAgent of Free Agent Model");
        freeAgentModelList.remove(1);
    }
}
