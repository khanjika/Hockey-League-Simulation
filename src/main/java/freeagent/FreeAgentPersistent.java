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
            storedProcedure.setParameter (3, playerPosition);
            storedProcedure.setParameter (4, age);
            storedProcedure.setParameter (5, isPlayerRetired);
            storedProcedure.setParameter (6, skating);
            storedProcedure.setParameter (7, shooting);
            storedProcedure.setParameter (8, checking);
            storedProcedure.setParameter (9, saving);
            storedProcedure.setParameter (10, agingDays);
            storedProcedure.setParameter (11, retirementLikelyHood);
            storedProcedure.execute ();
        } catch (Exception e) {
            System.out.println ("Exception in storing Free agent Information");
            System.out.println (e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
    }
}
