package players;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IPlayerPersistent {

    void addPlayerInformation(int teamId, String playerName, String playerPosition, boolean isCaptain, int age, boolean isPlayerRetired, float skating, float shooting, float checking, float saving, int agingDays, int injuryDays, int retirementLikelyHood, LocalDate recoveryDate);

    ArrayList<PlayerModel> getPlayerInformation(int teamId);

}
