package players;

import database.CallStoredProcedure;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PlayerPersistent implements IPlayerPersistent {

    @Override
    public boolean storePlayerId(int playerId, int teamId) {
        return false;
    }


    public void addPlayerInformation(String playerName, String position, boolean caption, int teamId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure ("storeNewPlayerInformation(?, ?, ? ,?)");
            storedProcedure.setParameter (1, playerName);
            storedProcedure.setParameter (2, position);
            storedProcedure.setParameter (3, Boolean.toString (caption));
            storedProcedure.setParameter (4, teamId);
            storedProcedure.execute ();
        } catch (Exception e) {
            System.out.println ("Exception in storing player details");
            System.out.println (e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }

    }

    @Override
    public ArrayList<PlayerModel> getPlayerInformation(int teamId) {
        ArrayList<PlayerModel> playersInfo = new ArrayList<PlayerModel> ();
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure ("getPlayerInformation(?)");
            storedProcedure.setParameter (1, teamId);
            ResultSet rs = storedProcedure.getResultSetObject ();
            if (rs != null) {
                while (rs.next ()) {
                    PlayerModel player = new PlayerModel ();
                    player.setCaptain (rs.getBoolean (4));
                    player.setPosition (rs.getString (3));
                    player.setPlayerName (rs.getString (2));
                    playersInfo.add (player);
                }
            }
        } catch (Exception e) {
            System.out.println ("Exception in obtaining team information");
            System.out.println (e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return playersInfo;

    }
}
