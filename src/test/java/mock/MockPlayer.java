package mock;

import players.PlayerModel;

public class MockPlayer {
    public static PlayerModel getPlayerModel(){
        PlayerModel playerModel = new PlayerModel();
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

    public static PlayerModel getForwardPlayer(){
        PlayerModel playerModel = new PlayerModel();
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

    public static PlayerModel getDefensePlayer(){
        PlayerModel playerModel = new PlayerModel();
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

    public static PlayerModel getGoaliePlayer(){
        PlayerModel playerModel = new PlayerModel();
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

    public static PlayerModel getInvalidPlayerModel(){
        PlayerModel playerModel = new PlayerModel();
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

    public static PlayerModel getRetiredPlayer(){
        PlayerModel playerModel = new PlayerModel();
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

    public static PlayerModel getPlayer39(){
        PlayerModel playerModel = new PlayerModel();
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

    public static PlayerModel getPlayer45(){
        PlayerModel playerModel = new PlayerModel();
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

    public static PlayerModel getPlayer(){
        PlayerModel playerModel = new PlayerModel();
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
