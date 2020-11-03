package players;

import java.time.LocalDate;
import java.util.ArrayList;

class MockPlayerPersistent {

    void addPlayerInformation(int teamId, String playerName, String playerPosition, boolean isCaptain, int age, boolean isPlayerRetired, float skating, float shooting, float checking, float saving, int agingDays, int injuryDays, int retirementLikelyHood, LocalDate recoveryDate) {
    }

    ArrayList<PlayerModel> getPlayerInformation() throws Exception {
        ArrayList<PlayerModel> playersInfo = new ArrayList<PlayerModel>();
        PlayerModel player = new PlayerModel();
        player.setPlayerName("Zankrut");
        player.setPosition("forward");
        player.setCaptain(true);
        player.setAge(27);
        player.setSkating(10);
        player.setShooting(10);
        player.setChecking(10);
        player.setSaving(10);
        player.setInjuryDays(0);
        player.setDays(0);
        player.setPlayerInjured(false);
        player.setPlayerRetired(false);
        player.setRetirementLikelyHood(0);
        playersInfo.add(player);
        return playersInfo;
    }
}
