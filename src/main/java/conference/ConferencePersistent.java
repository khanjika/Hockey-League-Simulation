package conference;

import database.CallStoredProcedure;

public class ConferencePersistent implements IConferencePersistent{
    @Override
    public int addConferenceInformation(String conferenceName, int leagueId) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("storeNewConferenceInformation(?,?)");
            proc.setParameter(1,conferenceName);
            proc.setParameter(2,leagueId);
            proc.registerOutParameter(3);
            proc.execute();
            System.out.println("Newly created Conference id is "+proc.getNumericReturnValue(3));
            return proc.getNumericReturnValue(3);
        } catch (Exception e) {
            System.out.println("Exception is Conference");
            System.out.println(e);
        } finally {
            if (null != proc) {
                //DO CLEANUP
            }
        }

        return 0;
    }
}
