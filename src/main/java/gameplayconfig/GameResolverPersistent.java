package gameplayconfig;

import database.CallStoredProcedure;

import java.sql.ResultSet;

public class GameResolverPersistent implements IGameResolverPersistent{
    @Override
    public int storeGameResolverInformation(float randomWinChance) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure ("storeGameResolverInformation(?, ?)");
            storedProcedure.setParameter (1, randomWinChance);
            storedProcedure.registerOutParameter (2);
            storedProcedure.execute ();
            return storedProcedure.getNumericReturnValue (2);
        } catch (Exception e) {
            System.out.println ("Exception in getting id of league");
            System.out.println (e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return 0;

    }

    @Override
    public GameResolverModel getGameResolverInformation(int gamePlayConfigId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure ("getGameResolverInformation(?)");
            storedProcedure.setParameter (1, gamePlayConfigId);
            storedProcedure.execute ();
            GameResolverModel gameResolverModel=new GameResolverModel();
            ResultSet rs = storedProcedure.getResultSetObject ();
            if (rs != null) {
                while (rs.next ()) {
                    gameResolverModel.setRandomWinChance(rs.getInt(2));
                }
            }
            return gameResolverModel;
        } catch (Exception e) {
            System.out.println ("Exception in getting id of league");
            System.out.println (e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return null;
    }
}
