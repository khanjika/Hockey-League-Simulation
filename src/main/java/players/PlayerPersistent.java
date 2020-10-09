package players;

import database.CallStoredProcedure;

public class PlayerPersistent implements IPlayerPersistent{
    @Override
    public void addPlayerInformation(String playerName, String position, boolean caption, int teamId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("storeNewPlayerInformation(?, ?, ? ,?)");
            storedProcedure.setParameter(1,playerName);
            storedProcedure.setParameter(2,position);
            storedProcedure.setParameter(3,caption);
            storedProcedure.setParameter(4,teamId);
            storedProcedure.execute();
        } catch (Exception e) {
            System.out.println("Exception in storing player details");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }

    }
}
