package league;

import database.CallStoredProcedure;
import database.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;

public class LeaguePersistent implements ILeaguePersistent {


    @Override
    public int addLeagueInformation(String leagueName) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("storeNewLeagueInformation(?)");
            proc.setParameter(1,leagueName);
            proc.registerOutParameter(2);
            proc.execute();
            System.out.println("Newly created League id is "+proc.getNumericReturnValue(2));
            return proc.getNumericReturnValue(2);
        } catch (Exception e) {
            System.out.println("Exception in League storing");
            System.out.println(e);
        } finally {
            if (null != proc) {
                //DO CLEANUP
            }
        }

        return 0;
    }
}
