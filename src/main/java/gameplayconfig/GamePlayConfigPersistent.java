package gameplayconfig;

import database.CallStoredProcedure;

public class GamePlayConfigPersistent implements IGamePlayConfigPersistent {
    @Override
    public int storeGamePlayConfigInformation(int agingId, int gameResolverId, int injuriesId, int trainingId, int tradingId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("storeGamePlayConfigInformation(?, ?, ?,?,?,?)");
            storedProcedure.setParameter(1, agingId);
            storedProcedure.setParameter(2, gameResolverId);
            storedProcedure.setParameter(3, injuriesId);
            storedProcedure.setParameter(4, trainingId);
            storedProcedure.setParameter(5, tradingId);
            storedProcedure.registerOutParameter(6);
            storedProcedure.execute();
            return storedProcedure.getNumericReturnValue(6);
        } catch (Exception e) {
            System.out.println("Exception in storing Game Play Config Model");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean();
            }
        }
        return 0;
    }
}
