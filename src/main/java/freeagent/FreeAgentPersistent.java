package freeagent;

import database.CallStoredProcedure;

public class FreeAgentPersistent implements IFreeAgentPersistent {


    @Override
    public void addFreeAgentInformation(int leagueId, String playerName, String playerPosition, int age, Boolean isPlayerRetired, float skating, float shooting, float checking, float saving, int agingDays, int retirementLikelyHood) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure ("storeFreeAgentInformation(?, ?, ?, ?,?,?,?,?,?,?,?)");
            storedProcedure.setParameter (1, leagueId);
            storedProcedure.setParameter (2, playerName);
            storedProcedure.setParameter (3, playerName);
            storedProcedure.setParameter (4, playerName);
            storedProcedure.setParameter (5, playerName);
            storedProcedure.setParameter (6, playerName);
            storedProcedure.setParameter (7, playerName);
            storedProcedure.setParameter (8, playerName);
            storedProcedure.setParameter (9, playerName);
            storedProcedure.setParameter (10, playerName);
            storedProcedure.setParameter (11, playerName);
            storedProcedure.execute ();
        } catch (Exception e) {
            System.out.println ("Exception in storing league");
            System.out.println (e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
    }
}
