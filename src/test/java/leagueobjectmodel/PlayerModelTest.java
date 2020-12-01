package leagueobjectmodel;

import LeagueMockObject.MockLeagueAbstractFactory;
import LeagueMockObject.MockPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerModelTest {

    IPlayerModel playerModel;
    ILeagueModel mockLeague;

    @BeforeEach
    void initializeVariable() {
        playerModel = MockLeagueAbstractFactory.getMockInstance().createPlayer();
        mockLeague = MockLeagueAbstractFactory.getMockInstance().createLeague();
    }


    @Test
    void getPlayerName() {
        playerModel.setPlayerName("player one");
        assertEquals("player one", playerModel.getPlayerName(), "Failed to get player name in player object");
    }

    @Test
    void setPlayerName() {
        playerModel.setPlayerName("player one");
        assertEquals("player one", playerModel.getPlayerName(), "Failed to get player name in player object");
    }

    @Test
    void getPosition() {
        playerModel.setPosition("player one");
        assertEquals("player one", playerModel.getPosition(), "Failed to get player position in player object");
    }

    @Test
    void setPosition() {
        playerModel.setPosition("player one");
        assertEquals("player one", playerModel.getPosition(), "Failed to set player position in player object");
    }

    @Test
    void isCaptain() {
        playerModel.setCaptain(true);
        assertTrue(playerModel.isCaptain(), "Failed check player is captain or not in player object");
    }

    @Test
    void setCaptain() {
        playerModel.setCaptain(true);
        assertTrue(playerModel.isCaptain(), "Failed set player is captain or not in  player object");
    }

    @Test
    void getAge() {
        playerModel.setAge(27);
        assertEquals(27, playerModel.getAge(), "Failed get Age in player object");
    }

    @Test
    void setAge() {
        playerModel.setAge(27);
        assertEquals(27, playerModel.getAge(), "Failed set Age in player object");
    }

    @Test
    void getSkating() {
        playerModel.setSkating(15);
        assertEquals(15, playerModel.getSkating(), "Failed get skating in player object");
    }

    @Test
    void setSkating() {
        playerModel.setSkating(15);
        assertEquals(15, playerModel.getSkating(), "Failed get skating in player object");
    }

    @Test
    void getShooting() {
        playerModel.setShooting(18);
        assertEquals(18, playerModel.getShooting(), "Failed get shooting in player object");
    }

    @Test
    void setShooting() {
        playerModel.setShooting(18);
        assertEquals(18, playerModel.getShooting(), "Failed set shooting in player object");
    }

    @Test
    void getChecking() {
        playerModel.setChecking(10);
        assertEquals(10, playerModel.getChecking(), "Failed get checing in player object");
    }

    @Test
    void setChecking() {
        playerModel.setChecking(10);
        assertEquals(10, playerModel.getChecking(), "Failed get shooting in player object");
    }

    @Test
    void getSaving() {
        playerModel.setSaving(1);
        assertEquals(1, playerModel.getSaving(), "Failed get saving in player object");
    }

    @Test
    void setSaving() {
        playerModel.setSaving(1);
        assertEquals(1, playerModel.getSaving(), "Failed set saving in player object");
    }

    @Test
    void getPlayerStrength() {
        playerModel.setPlayerStrength(10);
        assertEquals(10, playerModel.getPlayerStrength(), "Failed get strength in player object");
    }

    @Test
    void setPlayerStrength() {
        playerModel.setPlayerStrength(10);
        assertEquals(10, playerModel.getPlayerStrength(), "Failed get strength in player object");
    }

    @Test
    void isPlayerInjured() {
        playerModel.setPlayerInjured(true);
        assertEquals(true, playerModel.isPlayerInjured(), "Failed get isPlayerInjured in player object");
    }

    @Test
    void setPlayerInjured() {
        playerModel.setPlayerInjured(true);
        assertEquals(true, playerModel.isPlayerInjured(), "Failed set isPlayerInjured in player object");
    }

    @Test
    void getInjuredDate() {
        LocalDate injuredDate = LocalDate.now();
        playerModel.setInjuredDate(injuredDate);
        assertEquals(LocalDate.now(), playerModel.getInjuredDate(), "Failed get getInjuredDate in player object");
    }

    @Test
    void setInjuredDate() {
        LocalDate injuredDate = LocalDate.now();
        playerModel.setInjuredDate(injuredDate);
        assertEquals(LocalDate.now(), playerModel.getInjuredDate(), "Failed set setInjuredDate in player object");
    }

    @Test
    void getInjuryDays() {
        playerModel.setInjuryDays(100);
        assertEquals(100, playerModel.getInjuryDays(), "Failed get getInjuryDays in player object");
    }

    @Test
    void setInjuryDays() {
        playerModel.setInjuryDays(100);
        assertEquals(100, playerModel.getInjuryDays(), "Failed get getInjuryDays in player object");
    }

    @Test
    void getRecoveryDate() {
        LocalDate injuredDate = LocalDate.now();
        playerModel.setRecoveryDate(injuredDate);
        assertEquals(LocalDate.now(), playerModel.getRecoveryDate(), "Failed get getRecoveryDate in player object");
    }

    @Test
    void setRecoveryDate() {
        LocalDate injuredDate = LocalDate.now();
        playerModel.setRecoveryDate(injuredDate);
        assertEquals(LocalDate.now(), playerModel.getRecoveryDate(), "Failed get getRecoveryDate in player object");
    }

    @Test
    void isPlayerRetired() {
        playerModel.setPlayerRetired(true);
        assertEquals(true, playerModel.isPlayerRetired(), "Failed isPlayerRetired in player object");
    }

    @Test
    void setPlayerRetired() {
        playerModel.setPlayerRetired(true);
        assertEquals(true, playerModel.isPlayerRetired(), "Failed isPlayerRetired in player object");
    }

    @Test
    void getDays() {
        playerModel.setDays(1);
        assertEquals(1, playerModel.getDays(), "Failed getDays in player object");
    }

    @Test
    void setDays() {
        playerModel.setDays(1);
        assertEquals(1, playerModel.getDays(), "Failed setDays in player object");
    }

    @Test
    void getRetirementLikelyHood() {
        playerModel.setRetirementLikelyHood(10);
        assertEquals(10, playerModel.getRetirementLikelyHood(), "Failed getRetirementLikelyHood in player object");
    }

    @Test
    void setRetirementLikelyHood() {
        playerModel.setRetirementLikelyHood(10);
        assertEquals(10, playerModel.getRetirementLikelyHood(), "Failed setRetirementLikelyHood in player object");
    }

    @Test
    void getAgingModel() {
        playerModel.setAgingModel(mockLeague.getGameplayConfig().getAging());
        assertEquals(mockLeague.getGameplayConfig().getAging(), playerModel.getAgingModel(), "Failed getAgingModel in player object");
    }

    @Test
    void setAgingModel() {
        playerModel.setAgingModel(mockLeague.getGameplayConfig().getAging());
        assertEquals(mockLeague.getGameplayConfig().getAging(), playerModel.getAgingModel(), "Failed getAgingModel in player object");
    }

    @Test
    void getFreeAgentsList() {
        List<IFreeAgentModel> freeAgentModelList = new ArrayList<>();
        freeAgentModelList.add(MockLeagueAbstractFactory.getMockInstance().createFreeAgent());
        freeAgentModelList.add(MockLeagueAbstractFactory.getMockInstance().createFreeAgent());
        freeAgentModelList.add(MockLeagueAbstractFactory.getMockInstance().createFreeAgent());
        playerModel.setFreeAgentsList(freeAgentModelList);
        assertEquals(freeAgentModelList, playerModel.getFreeAgentsList(), "Failed getAgingModel in player object");
    }

    @Test
    void setFreeAgentsList() {
        List<IFreeAgentModel> freeAgentModelList = new ArrayList<>();
        freeAgentModelList.add(MockLeagueAbstractFactory.getMockInstance().createFreeAgent());
        freeAgentModelList.add(MockLeagueAbstractFactory.getMockInstance().createFreeAgent());
        freeAgentModelList.add(MockLeagueAbstractFactory.getMockInstance().createFreeAgent());
        playerModel.setFreeAgentsList(freeAgentModelList);
        assertEquals(freeAgentModelList, playerModel.getFreeAgentsList(), "Failed getAgingModel in player object");
    }

    @Test
    void getInjuriesModel() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setInjuriesModel(mockLeague.getGameplayConfig().getInjuries());
        assertEquals(mockLeague.getGameplayConfig().getInjuries(), playerModel.getInjuriesModel(), "Failed getInjuriesModel in player object");
    }

    @Test
    void setInjuriesModel() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setInjuriesModel(mockLeague.getGameplayConfig().getInjuries());
        assertEquals(mockLeague.getGameplayConfig().getInjuries(), playerModel.getInjuriesModel(), "Failed getInjuriesModel in player object");
    }

    @Test
    void calculatePlayerStrength() {
        IPlayerModel validForwardPlayerModel = MockPlayer.getForwardPlayer();
        validForwardPlayerModel.calculatePlayerStrength(validForwardPlayerModel);
        assertEquals(25f, validForwardPlayerModel.getPlayerStrength(), "Error in calculateFreeAgentStrength in Player Model");
        IPlayerModel validDefensePlayerModel = MockPlayer.getDefensePlayer();
        validDefensePlayerModel.calculatePlayerStrength(validDefensePlayerModel);
        assertEquals(25f, validDefensePlayerModel.getPlayerStrength(), "Error in calculateFreeAgentStrength in Player Model");
        IPlayerModel validGoaliePlayerModel = MockPlayer.getGoaliePlayer();
        validGoaliePlayerModel.calculatePlayerStrength(validGoaliePlayerModel);
        assertEquals(20f, validGoaliePlayerModel.getPlayerStrength(), "Error in calculateFreeAgentStrength in Player Model");
    }

    @Test
    void checkPlayerInjury() {

        IInjuriesModel injuriesModel = mockLeague.getGameplayConfig().getInjuries();
        LocalDate date = LocalDate.now();
        IPlayerModel playerModel = MockPlayer.getPlayerModel();
        playerModel.setInjuriesModel(injuriesModel);
        playerModel.checkPlayerInjury(playerModel, date);
        IPlayerModel playerModel1 = MockPlayer.getPlayer();
        playerModel.setInjuriesModel(injuriesModel);
        playerModel1.checkPlayerInjury(playerModel1, date);
    }
}
