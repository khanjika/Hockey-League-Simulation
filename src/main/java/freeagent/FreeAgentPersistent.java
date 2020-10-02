package freeagent;

import database.CallStoredProcedure;

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
}
