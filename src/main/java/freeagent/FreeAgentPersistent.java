package freeagent;

import database.CallStoredProcedure;

import java.sql.ResultSet;

public class FreeAgentPersistent implements  IFreeAgentPersistent{
    @Override
    public void addFreeAgentInformation(String freeAgentName, String freeAgnetPosition, boolean isCaptain, int leagueId) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("storeNewFreeAgentInformation(?,?,?,?)");
            proc.setParameter(1,freeAgentName);
            proc.setParameter(2,freeAgnetPosition);
            proc.setParameter(3,isCaptain);
            proc.setParameter(4,leagueId);
            proc.execute();
            System.out.println("Newly created Freeagent");

        } catch (Exception e) {
            System.out.println("Exception is FreeAgent");
            System.out.println(e);
        } finally {
            if (null != proc) {
                //DO CLEANUP
            }
        }
    }


    public void temp(){
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("temp()");
            proc.execute();
           ResultSet rs= proc.getResultSetObject();
           while (rs.next()) {
               System.out.println(rs.getInt(1));
           }

        } catch (Exception e) {
            System.out.println("Exception is FreeAgent");
            System.out.println(e);
        } finally {
            if (null != proc) {
                //DO CLEANUP
            }
        }
    }
}
