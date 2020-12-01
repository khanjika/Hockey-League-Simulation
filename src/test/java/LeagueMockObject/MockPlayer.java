package LeagueMockObject;

import leagueobjectmodel.IPlayerModel;

public class MockPlayer {

    static IPlayerModel playerModel = MockLeagueAbstractFactory.getMockInstance().createPlayer();

    public static IPlayerModel getPlayerModel() {
        playerModel.setPlayerName("Zankrut");
        playerModel.setPosition("forward");
        playerModel.setCaptain(true);
        playerModel.setAge(27);
        playerModel.setSkating(10);
        playerModel.setShooting(10);
        playerModel.setChecking(10);
        playerModel.setSaving(10);
        playerModel.setInjuryDays(0);
        playerModel.setDays(0);
        playerModel.setPlayerInjured(false);
        playerModel.setPlayerRetired(false);
        playerModel.setRetirementLikelyHood(0);
        return playerModel;
    }

    public static IPlayerModel getForwardPlayer() {
        playerModel.setPlayerName("Zankrut");
        playerModel.setPosition("forward");
        playerModel.setCaptain(true);
        playerModel.setAge(27);
        playerModel.setSkating(10);
        playerModel.setShooting(10);
        playerModel.setChecking(10);
        playerModel.setSaving(10);
        playerModel.setInjuryDays(0);
        playerModel.setDays(0);
        playerModel.setPlayerInjured(false);
        playerModel.setPlayerRetired(false);
        playerModel.setRetirementLikelyHood(0);
        return playerModel;
    }

    public static IPlayerModel getDefensePlayer() {
        playerModel.setPlayerName("Zankrut");
        playerModel.setPosition("defense");
        playerModel.setCaptain(true);
        playerModel.setAge(27);
        playerModel.setSkating(10);
        playerModel.setShooting(10);
        playerModel.setChecking(10);
        playerModel.setSaving(10);
        playerModel.setInjuryDays(0);
        playerModel.setDays(0);
        playerModel.setPlayerInjured(false);
        playerModel.setPlayerRetired(false);
        playerModel.setRetirementLikelyHood(0);
        return playerModel;
    }

    public static IPlayerModel getGoaliePlayer() {
        playerModel.setPlayerName("Zankrut");
        playerModel.setPosition("goalie");
        playerModel.setCaptain(true);
        playerModel.setAge(27);
        playerModel.setSkating(10);
        playerModel.setShooting(10);
        playerModel.setChecking(10);
        playerModel.setSaving(10);
        playerModel.setInjuryDays(0);
        playerModel.setDays(0);
        playerModel.setPlayerInjured(false);
        playerModel.setPlayerRetired(false);
        playerModel.setRetirementLikelyHood(0);
        return playerModel;
    }

    public static IPlayerModel getInvalidPlayerModel() {
        playerModel.setPlayerName("");
        playerModel.setPosition("forward");
        playerModel.setCaptain(true);
        playerModel.setAge(27);
        playerModel.setSkating(10);
        playerModel.setShooting(10);
        playerModel.setChecking(10);
        playerModel.setSaving(10);
        playerModel.setInjuryDays(0);
        playerModel.setDays(0);
        playerModel.setPlayerInjured(false);
        playerModel.setPlayerRetired(false);
        playerModel.setRetirementLikelyHood(0);
        return playerModel;
    }

    public static IPlayerModel getRetiredPlayer() {
        playerModel.setPlayerName("");
        playerModel.setPosition("forward");
        playerModel.setCaptain(true);
        playerModel.setAge(50);
        playerModel.setSkating(10);
        playerModel.setShooting(10);
        playerModel.setChecking(10);
        playerModel.setSaving(10);
        playerModel.setInjuryDays(0);
        playerModel.setDays(0);
        playerModel.setPlayerInjured(false);
        playerModel.setPlayerRetired(true);
        playerModel.setRetirementLikelyHood(0);
        return playerModel;
    }

    public static IPlayerModel getPlayer39() {
        playerModel.setPlayerName("");
        playerModel.setPosition("forward");
        playerModel.setCaptain(true);
        playerModel.setAge(40);
        playerModel.setSkating(10);
        playerModel.setShooting(10);
        playerModel.setChecking(10);
        playerModel.setSaving(10);
        playerModel.setInjuryDays(0);
        playerModel.setDays(0);
        playerModel.setPlayerInjured(false);
        playerModel.setPlayerRetired(false);
        playerModel.setRetirementLikelyHood(0);
        return playerModel;
    }

    public static IPlayerModel getPlayer45() {
        playerModel.setPlayerName("");
        playerModel.setPosition("forward");
        playerModel.setCaptain(true);
        playerModel.setAge(45);
        playerModel.setSkating(10);
        playerModel.setShooting(10);
        playerModel.setChecking(10);
        playerModel.setSaving(10);
        playerModel.setInjuryDays(0);
        playerModel.setDays(0);
        playerModel.setPlayerInjured(false);
        playerModel.setPlayerRetired(false);
        playerModel.setRetirementLikelyHood(0);
        return playerModel;
    }

    public static IPlayerModel getPlayer() {
        playerModel.setPlayerName("Zankrut");
        playerModel.setPosition("forward");
        playerModel.setCaptain(true);
        playerModel.setAge(25);
        playerModel.setSkating(10);
        playerModel.setShooting(10);
        playerModel.setChecking(10);
        playerModel.setSaving(10);
        playerModel.setInjuryDays(25);
        playerModel.setDays(0);
        playerModel.setPlayerInjured(true);
        playerModel.setPlayerRetired(false);
        playerModel.setRetirementLikelyHood(0);
        return playerModel;
    }

}
