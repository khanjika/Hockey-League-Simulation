package players;

import database.CallStoredProcedure;

public class PlayerPersistent implements IPlayerPersistent{
    @Override
    public void addPlayerInformation(String playerName, String position, boolean captaion, int teamId) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("storeNewPlayerInformation(?,?,?,?)");
            proc.setParameter(1,playerName);
            proc.setParameter(2,position);
            proc.setParameter(3,captaion);
            proc.setParameter(4,teamId);
            proc.execute();
            System.out.println("Newly created Player");

        } catch (Exception e) {
            System.out.println("Exception is Player");
            System.out.println(e);
        } finally {
            if (null != proc) {
                //DO CLEANUP
            }
        }
    }
}
