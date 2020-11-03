package conference;

import database.CallStoredProcedure;

public class ConferencePersistent implements IConferencePersistent {
    @Override
    public int addConferenceInformation(String conferenceName, int leagueId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("storeNewConferenceInformation(?, ?, ?)");
            storedProcedure.setParameter(1, conferenceName);
            storedProcedure.setParameter(2, leagueId);
            storedProcedure.registerOutParameter(3);
            storedProcedure.execute();
            return storedProcedure.getNumericReturnValue(3);
        } catch (Exception e) {
            System.out.println("Exception in storing conference information.");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean();
            }
        }
        return 0;
    }

    @Override
    public boolean isConferenceAlreadyExist(String conferenceName, int leagueId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("isConferenceAlreadyExist(?,?,?)");
            storedProcedure.setParameter(1, conferenceName);
            storedProcedure.setParameter(2, leagueId);
            storedProcedure.registerOutParameter(3);
            storedProcedure.execute();
            return storedProcedure.getNumericReturnValue(3) != 0;
        } catch (Exception e) {
            System.out.println("Exception in obtaining conference information.");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean();
            }
        }
        return false;
    }

    @Override
    public int getConferenceInformation(String conferenceName, int leagueId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("getConferenceId(?,?,?)");
            storedProcedure.setParameter(1, conferenceName);
            storedProcedure.setParameter(2, leagueId);
            storedProcedure.registerOutParameter(3);
            storedProcedure.execute();
            return storedProcedure.getNumericReturnValue(3);
        } catch (Exception e) {
            System.out.println("Exception in fetching information about conference.");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean();
            }
        }
        return 0;
    }

}
