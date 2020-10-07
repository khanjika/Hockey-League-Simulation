package league;

import database.CallStoredProcedure;
import database.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class LeaguePersistent implements ILeaguePersistent {


    @Override
    public int addLeagueInformation(String leagueName) {
//        CallStoredProcedure proc = null;
//        try {
//            proc = new CallStoredProcedure("storeNewLeagueInformation(?)");
//            proc.setParameter(1,leagueName);
//            proc.registerOutParameter(2);
//            proc.execute();
//            System.out.println("Newly created League id is "+proc.getNumericReturnValue(2));
//            return proc.getNumericReturnValue(2);
//        } catch (Exception e) {
//            System.out.println("Exception in League storing");
//            System.out.println(e);
//        } finally {
//            if (null != proc) {
//                //DO CLEANUP
//            }
//        }

        return 0;
    }

    @Override
    public boolean isLeagueAlreadyExist(String leagueName) {


        return false;
    }

    @Override
    public int getLeagueId(String teamName) {



        return 0;
    }

    @Override
    //PENDING
    public LeagueModel getLeagueInformation(int leagueId) {
        CallStoredProcedure proc = null;
//        try {
//            proc = new CallStoredProcedure("GetLeagueInfo(?)");
//            proc.setParameter(1,leagueId);
//            proc.registerOutParameter(2);
//            proc.execute();
//            ResultSet rs= proc.getResultSetObject();
//        } catch (Exception e) {
//            System.out.println("Exception in League Validation");
//            System.out.println(e);
//        } finally {
//            if (null != proc) {
//                //DO CLEANUP
//            }
//        }

        return new LeagueModel();
    }
}
