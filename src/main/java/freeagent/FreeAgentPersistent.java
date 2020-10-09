package freeagent;

import database.CallStoredProcedure;

import java.sql.ResultSet;

public class FreeAgentPersistent implements  IFreeAgentPersistent{
    @Override

    public void addFreeAgentInformation(String freeAgentName, String freeAgnetPosition, boolean isCaptain, int leagueId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("storeNewFreeAgentInformation(?, ?, ? ,?)");
            storedProcedure.setParameter(1,freeAgentName);
            storedProcedure.setParameter(2,freeAgnetPosition);
            storedProcedure.setParameter(3,Boolean.toString(isCaptain));
            storedProcedure.setParameter(4,leagueId);
            storedProcedure.execute();
        } catch (Exception e) {
            System.out.println("Exception in storing free agent details");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }


    }


}
