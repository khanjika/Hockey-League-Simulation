package leagueobjectmodel;

import org.junit.jupiter.api.Test;
import trade.MockLeague;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerModelTest {


    public static PlayerModel getPlayerModel(String playerName, String position, boolean iscaptain, int age, float skating, float shooting, float checking, float saving) {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setCaptain(iscaptain);
        playerModel.setPlayerName(playerName);
        playerModel.setPosition(position);
        playerModel.setAge(age);
        playerModel.setSkating(skating);
        playerModel.setChecking(checking);
        playerModel.setShooting(shooting);
        playerModel.setSaving(saving);
        return playerModel;
    }

    @Test
    public void PlayerModel() {
        PlayerModel playerModel = new PlayerModel("Zankrut", "forward", true, 25, 10, 10, 10, 10,1,1,1);
        assertEquals("Zankrut", playerModel.getPlayerName(), "Faled to get player name in player constructor");
    }

    @Test
    void getPlayerName() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setPlayerName("player one");
        assertEquals("player one", playerModel.getPlayerName(), "Failed to get player name in player object");
    }

    @Test
    void setPlayerName() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setPlayerName("player one");
        assertEquals("player one", playerModel.getPlayerName(), "Failed to set player name in player object");
    }

    @Test
    void getPosition() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setPosition("player one");
        assertEquals("player one", playerModel.getPosition(), "Failed to get player position in player object");
    }

    @Test
    void setPosition() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setPosition("player one");
        assertEquals("player one", playerModel.getPosition(), "Failed to set player position in player object");
    }

    @Test
    void isCaptain() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setCaptain(true);
        assertTrue(playerModel.isCaptain(), "Failed check player is captain or not in player object");
    }

    @Test
    void setCaptain() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setCaptain(true);
        assertTrue(playerModel.isCaptain(), "Failed set player is captain or not in  player object");
    }

    @Test
    void getAge() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setAge(27);
        assertEquals(27, playerModel.getAge(), "Failed get Age in player object");
    }

    @Test
    void setAge() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setAge(27);
        assertEquals(27, playerModel.getAge(), "Failed set Age in player object");
    }

    @Test
    void getSkating() {
        PlayerModel playermodel = new PlayerModel();
        playermodel.setSkating(15);
        assertEquals(15, playermodel.getSkating(), "Failed get skating in player object");
    }

    @Test
    void setSkating() {
        PlayerModel playermodel = new PlayerModel();
        playermodel.setSkating(15);
        assertEquals(15, playermodel.getSkating(), "Failed get skating in player object");
    }

    @Test
    void getShooting() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setShooting(18);
        assertEquals(18, playerModel.getShooting(), "Failed get shooting in player object");
    }

    @Test
    void setShooting() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setShooting(18);
        assertEquals(18, playerModel.getShooting(), "Failed set shooting in player object");
    }

    @Test
    void getChecking() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setChecking(10);
        assertEquals(10, playerModel.getChecking(), "Failed get checing in player object");
    }

    @Test
    void setChecking() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setChecking(10);
        assertEquals(10, playerModel.getChecking(), "Failed get shooting in player object");
    }

    @Test
    void getSaving() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setSaving(1);
        assertEquals(1, playerModel.getSaving(), "Failed get saving in player object");
    }

    @Test
    void setSaving() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setSaving(1);
        assertEquals(1, playerModel.getSaving(), "Failed set saving in player object");
    }

    @Test
    void getPlayerStrength() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setPlayerStrength(10);
        assertEquals(10, playerModel.getPlayerStrength(), "Failed get strength in player object");
    }

    @Test
    void setPlayerStrength() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setPlayerStrength(10);
        assertEquals(10, playerModel.getPlayerStrength(), "Failed get strength in player object");
    }

    @Test
    void isPlayerInjured() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setPlayerInjured(true);
        assertEquals(true, playerModel.isPlayerInjured(), "Failed get isPlayerInjured in player object");
    }

    @Test
    void setPlayerInjured() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setPlayerInjured(true);
        assertEquals(true, playerModel.isPlayerInjured(), "Failed set isPlayerInjured in player object");
    }

    @Test
    void getInjuredDate() {
        LocalDate injuredDate = LocalDate.now();
        PlayerModel playerModel = new PlayerModel();
        playerModel.setInjuredDate(injuredDate);
        assertEquals(LocalDate.now(), playerModel.getInjuredDate(), "Failed get getInjuredDate in player object");
    }

    @Test
    void setInjuredDate() {
        LocalDate injuredDate = LocalDate.now();
        PlayerModel playerModel = new PlayerModel();
        playerModel.setInjuredDate(injuredDate);
        assertEquals(LocalDate.now(), playerModel.getInjuredDate(), "Failed set setInjuredDate in player object");
    }

    @Test
    void getInjuryDays() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setInjuryDays(100);
        assertEquals(100, playerModel.getInjuryDays(), "Failed get getInjuryDays in player object");
    }

    @Test
    void setInjuryDays() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setInjuryDays(100);
        assertEquals(100, playerModel.getInjuryDays(), "Failed get getInjuryDays in player object");
    }

    @Test
    void getRecoveryDate() {
        LocalDate injuredDate = LocalDate.now();
        PlayerModel playerModel = new PlayerModel();
        playerModel.setRecoveryDate(injuredDate);
        assertEquals(LocalDate.now(), playerModel.getRecoveryDate(), "Failed get getRecoveryDate in player object");
    }

    @Test
    void setRecoveryDate() {
        LocalDate injuredDate = LocalDate.now();
        PlayerModel playerModel = new PlayerModel();
        playerModel.setRecoveryDate(injuredDate);
        assertEquals(LocalDate.now(), playerModel.getRecoveryDate(), "Failed get getRecoveryDate in player object");
    }

    @Test
    void isPlayerRetired() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setPlayerRetired(true);
        assertEquals(true, playerModel.isPlayerRetired(), "Failed isPlayerRetired in player object");
    }

    @Test
    void setPlayerRetired() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setPlayerRetired(true);
        assertEquals(true, playerModel.isPlayerRetired(), "Failed isPlayerRetired in player object");
    }

    @Test
    void getDays() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setDays(1);
        assertEquals(1, playerModel.getDays(), "Failed getDays in player object");
    }

    @Test
    void setDays() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setDays(1);
        assertEquals(1, playerModel.getDays(), "Failed setDays in player object");
    }

    @Test
    void getRetirementLikelyHood() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setRetirementLikelyHood(10);
        assertEquals(10, playerModel.getRetirementLikelyHood(), "Failed getRetirementLikelyHood in player object");
    }

    @Test
    void setRetirementLikelyHood() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setRetirementLikelyHood(10);
        assertEquals(10, playerModel.getRetirementLikelyHood(), "Failed setRetirementLikelyHood in player object");
    }

    @Test
    void getAgingModel() {
        MockLeague leagueModel = new MockLeague();
        LeagueModel leagueModel1 = MockLeague.getLeagueObject();
        PlayerModel playerModel = new PlayerModel();
        playerModel.setAgingModel(leagueModel1.getGameplayConfig().getAging());
        assertEquals(leagueModel1.getGameplayConfig().getAging(), playerModel.getAgingModel(), "Failed getAgingModel in player object");
    }

    @Test
    void setAgingModel() {
        MockLeague leagueModel = new MockLeague();
        LeagueModel leagueModel1 = MockLeague.getLeagueObject();
        PlayerModel playerModel = new PlayerModel();
        playerModel.setAgingModel(leagueModel1.getGameplayConfig().getAging());
        assertEquals(leagueModel1.getGameplayConfig().getAging(), playerModel.getAgingModel(), "Failed getAgingModel in player object");
    }

    @Test
    void getFreeAgentsList() {
        List<FreeAgentModel> freeAgentModelList = new ArrayList<>();
        freeAgentModelList.add(MockFreeAgent.getForwardFreeAgentModel());
        freeAgentModelList.add(MockFreeAgent.getDefenseFreeAgentModel());
        freeAgentModelList.add(MockFreeAgent.getGoalieFreeAgentModel());
        PlayerModel playerModel = new PlayerModel();
        playerModel.setFreeAgentsList(freeAgentModelList);
        assertEquals(freeAgentModelList, playerModel.getFreeAgentsList(), "Failed getAgingModel in player object");
    }

    @Test
    void setFreeAgentsList() {
        List<FreeAgentModel> freeAgentModelList = new ArrayList<>();
        freeAgentModelList.add(MockFreeAgent.getForwardFreeAgentModel());
        freeAgentModelList.add(MockFreeAgent.getDefenseFreeAgentModel());
        freeAgentModelList.add(MockFreeAgent.getGoalieFreeAgentModel());
        PlayerModel playerModel = new PlayerModel();
        playerModel.setFreeAgentsList(freeAgentModelList);
        assertEquals(freeAgentModelList, playerModel.getFreeAgentsList(), "Failed getAgingModel in player object");
    }

    @Test
    void getInjuriesModel() {
        MockLeague leagueModel = new MockLeague();
        LeagueModel leagueModel1 = MockLeague.getLeagueObject();
        PlayerModel playerModel = new PlayerModel();
        playerModel.setInjuriesModel(leagueModel1.getGameplayConfig().getInjuries());
        assertEquals(leagueModel1.getGameplayConfig().getInjuries(), playerModel.getInjuriesModel(), "Failed getInjuriesModel in player object");
    }

    @Test
    void setInjuriesModel() {
        MockLeague leagueModel = new MockLeague();
        LeagueModel leagueModel1 = MockLeague.getLeagueObject();
        PlayerModel playerModel = new PlayerModel();
        playerModel.setInjuriesModel(leagueModel1.getGameplayConfig().getInjuries());
        assertEquals(leagueModel1.getGameplayConfig().getInjuries(), playerModel.getInjuriesModel(), "Failed setInjuriesModel in player object");
    }

//    @Test
//    void calculatePlayerStrength() {
//        PlayerModel validForwardPlayerModel = MockPlayer.getForwardPlayer();
//        validForwardPlayerModel.calculatePlayerStrength(validForwardPlayerModel);
//        assertEquals(25f, validForwardPlayerModel.getPlayerStrength(), "Error in calculateFreeAgentStrength in Player Model");
//        PlayerModel validDefensePlayerModel = MockPlayer.getDefensePlayer();
//        validDefensePlayerModel.calculatePlayerStrength(validDefensePlayerModel);
//        assertEquals(25f, validDefensePlayerModel.getPlayerStrength(), "Error in calculateFreeAgentStrength in Player Model");
//        PlayerModel validGoaliePlayerModel = MockPlayer.getGoaliePlayer();
//        validGoaliePlayerModel.calculatePlayerStrength(validGoaliePlayerModel);
//        assertEquals(20f, validGoaliePlayerModel.getPlayerStrength(), "Error in calculateFreeAgentStrength in Player Model");
//    }

    @Test
    void checkPlayerInjury() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        InjuriesModel injuriesModel = leagueModel.getGameplayConfig().getInjuries();
        LocalDate date = LocalDate.now();
        PlayerModel playerModel = MockPlayer.getPlayerModel();
        playerModel.setInjuriesModel(injuriesModel);
        playerModel.checkPlayerInjury(playerModel, date);
        PlayerModel playerModel1 = MockPlayer.getPlayer();
        playerModel.setInjuriesModel(injuriesModel);
        playerModel1.checkPlayerInjury(playerModel1, date);
    }

//    @Test
//    void aging() {
//        MockLeague league = new MockLeague();
//        LeagueModel leagueModel = MockLeague.getLeagueObject();
//        List<FreeAgentModel> freeAgentModelList = new ArrayList<>();
//        freeAgentModelList.add(MockFreeAgent.getForwardFreeAgentModel());
//        freeAgentModelList.add(MockFreeAgent.getDefenseFreeAgentModel());
//        freeAgentModelList.add(MockFreeAgent.getGoalieFreeAgentModel());
//        LocalDate currentdate = LocalDate.now();
//        PlayerModel playerModel = MockPlayer.getPlayerModel();
//        playerModel.setAgingModel(leagueModel.getGameplayConfig().getAging());
//        playerModel.setFreeAgentsList(freeAgentModelList);
//        playerModel.aging(playerModel, 1, currentdate);
////        assertEquals(1, playerModel.getDays(), "Error in aging method of PlayerModel");
//        playerModel.aging(playerModel, 365, currentdate);
//        assertEquals(28, playerModel.getAge(), "Error in aging method of PlayerModel");
//        playerModel.setFreeAgentsList(freeAgentModelList);
//        playerModel.aging(playerModel, 25, currentdate);
//        assertEquals(25, playerModel.getDays(), "Error in aging method of PlayerModel");
//        PlayerModel playerModel1 = MockPlayer.getRetiredPlayer();
//        playerModel1.setAgingModel(leagueModel.getGameplayConfig().getAging());
//        playerModel1.setFreeAgentsList(freeAgentModelList);
//        playerModel1.aging(playerModel1, 250, currentdate);
//        assertEquals(0, playerModel1.getRetirementLikelyHood(), "Error in aging method of PlayerModel");
//        PlayerModel playerModel2 = MockPlayer.getPlayer39();
//        playerModel2.setAgingModel(leagueModel.getGameplayConfig().getAging());
//        playerModel2.setFreeAgentsList(freeAgentModelList);
//        playerModel2.aging(playerModel2, 100, currentdate);
//        assertEquals(100, playerModel2.getDays(), "Error in aging method of PlayerModel");
//        PlayerModel playerModel3 = MockPlayer.getPlayer45();
//        playerModel3.setAgingModel(leagueModel.getGameplayConfig().getAging());
//        playerModel3.setFreeAgentsList(freeAgentModelList);
//        playerModel3.aging(playerModel3, 100, currentdate);
//        assertEquals(100, playerModel3.getDays(), "Error in aging method of PlayerModel");
//    }

    @Test
    public void storePlayerInformation() {
        MockPlayerPersistent mockPlayerPersistent = new MockPlayerPersistent();
        mockPlayerPersistent.addPlayerInformation(1, "zankrut", "forward", true, 25, false, 10, 10, 10, 10, 0, 10, 10, LocalDate.now());
    }

    @Test
    void getPlayerInformation() throws Exception {
        MockPlayerPersistent mockPlayerPersistent = new MockPlayerPersistent();
        ArrayList<PlayerModel> playerModels = mockPlayerPersistent.getPlayerInformation();
        assertEquals("Zankrut", playerModels.get(0).getPlayerName(), "Error in getting player information");
    }
}
