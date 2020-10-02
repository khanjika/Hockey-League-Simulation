package divison;

import database.CallStoredProcedure;

public class DivisonPersistent implements IDivisonPersistent{

    @Override
    public int addDivisionInformation(String divisionName, int conferenceId) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("storeNewDivisionInformation(?,?)");
            proc.setParameter(1,divisionName);
            proc.setParameter(2,conferenceId);
            proc.registerOutParameter(3);
            proc.execute();
            System.out.println("Newly created Division id is "+proc.getNumericReturnValue(3));
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
