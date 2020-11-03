package divison;

import database.CallStoredProcedure;

public class DivisonPersistent implements IDivisonPersistent {

    @Override
    public int addDivisionInformation(String divisionName, int conferenceId) {

        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("storeNewDivisionInformation(?, ?, ?)");
            storedProcedure.setParameter(1, divisionName);
            storedProcedure.setParameter(2, conferenceId);
            storedProcedure.registerOutParameter(3);
            storedProcedure.execute();
            return storedProcedure.getNumericReturnValue(3);
        } catch (Exception e) {
            System.out.println("Exception in storing division information.");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean();
            }
        }
        return 0;
    }

    @Override
    public boolean isDivisionAlreadyExist(String divisionName, int conferenceId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("isDivisionAlreadyExist(?,?,?)");
            storedProcedure.setParameter(1, divisionName);
            storedProcedure.setParameter(2, conferenceId);
            storedProcedure.registerOutParameter(3);
            storedProcedure.execute();
            return storedProcedure.getNumericReturnValue(3) != 0;
        } catch (Exception e) {
            System.out.println("Exception in obtaining division information");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean();
            }
        }
        return false;
    }

    @Override
    public int getDivisionInformation(String divisionName, int conferenceId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("getDivisionId(?,?,?)");
            storedProcedure.setParameter(1, divisionName);
            storedProcedure.setParameter(2, conferenceId);
            storedProcedure.registerOutParameter(3);
            storedProcedure.execute();
            return storedProcedure.getNumericReturnValue(3);
        } catch (Exception e) {
            System.out.println("Exception in fetching information about division");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean();
            }
        }

        return 0;
    }

}
