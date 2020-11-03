package coach;

import database.CallStoredProcedure;

public class CoachPersistent implements ICoachPersistent{
    @Override
    public int storeCoachesInformation(String  leagueId, String headCoachName, float skating, float shooting, float checking, float saving) {

        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure ("storeAvailableCoachesInformation(?, ?, ?,?,?,?,?)");
            storedProcedure.setParameter (1, leagueId);
            storedProcedure.setParameter (2, headCoachName);
            storedProcedure.setParameter (3, skating);
            storedProcedure.setParameter (4, shooting);
            storedProcedure.setParameter (5, checking);
            storedProcedure.setParameter (6, saving);

            storedProcedure.registerOutParameter (7);
            storedProcedure.execute ();
            return storedProcedure.getNumericReturnValue (7);
        } catch (Exception e) {
            System.out.println ("Exception in storing List of coaches");
            System.out.println (e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return 0;
    }
}
