package players;

import database.CallStoredProcedure;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class PlayerPersistent implements IPlayerPersistent {


    @Override
    public void addPlayerInformation(int teamId, String playerName, String playerPosition, boolean isCaptain, int age, boolean isPlayerRetired, float skating, float shooting, float checking, float saving, int agingDays, int injuryDays, int retirementLikelyHood, LocalDate recoveryDate) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("storeNewPlayerInformation (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            storedProcedure.setParameter(1, teamId);
            storedProcedure.setParameter(2, playerName);
            storedProcedure.setParameter(3, playerPosition);
            storedProcedure.setParameter(4, isCaptain);
            storedProcedure.setParameter(5, age);
            storedProcedure.setParameter(6, isPlayerRetired);
            storedProcedure.setParameter(7, skating);
            storedProcedure.setParameter(8, shooting);
            storedProcedure.setParameter(9, checking);
            storedProcedure.setParameter(10, saving);
            storedProcedure.setParameter(11, agingDays);
            storedProcedure.setParameter(12, injuryDays);
            storedProcedure.setParameter(13, retirementLikelyHood);
            storedProcedure.setParameter(14, recoveryDate);

            storedProcedure.execute();

        } catch (Exception e) {
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean();
            }
        }
    }

    @Override
    public ArrayList<PlayerModel> getPlayerInformation(int teamId) {
        ArrayList<PlayerModel> playersInfo = new ArrayList<PlayerModel>();
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("getPlayerInformation(?)");
            storedProcedure.setParameter(1, teamId);
            ResultSet rs = storedProcedure.getResultSetObject();
            if (rs != null) {
                while (rs.next()) {
                    PlayerModel player = new PlayerModel();
                    player.setCaptain(rs.getBoolean(4));
                    player.setPosition(rs.getString(3));
                    player.setPlayerName(rs.getString(2));
                    playersInfo.add(player);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in obtaining team information");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean();
            }
        }
        return playersInfo;

    }
}
