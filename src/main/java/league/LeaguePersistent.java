package league;

import database.CallStoredProcedure;
import java.sql.ResultSet;

public class LeaguePersistent implements ILeaguePersistent {
    @Override
    public int addLeagueInformation(String leagueName) {

        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("storeNewLeagueInformation(?, ?)");
            storedProcedure.setParameter(1,leagueName);
            storedProcedure.registerOutParameter(2);
            storedProcedure.execute();
            System.out.println("Newly created League id is "+storedProcedure.getNumericReturnValue(2));
            return storedProcedure.getNumericReturnValue(2);
        } catch (Exception e) {
            System.out.println("Exception in storing league");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return 0;
    }

    @Override
    public boolean isLeagueAlreadyExist(String leagueName) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("IsLeagueNameAlreadyExist(?, ?)");
            storedProcedure.setParameter(1,leagueName);
            storedProcedure.registerOutParameter(2);
            storedProcedure.execute();
            if(storedProcedure.getNumericReturnValue(2) == 0)
            {
                return false;
            }
            else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Exception in obtaining League information");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return false;
    }


    @Override
    public String getLeagueInformation(int leagueId) {
        LeagueModel league = new LeagueModel();
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("GetLeagueInfo(?,?)");
            storedProcedure.setParameter(1,leagueId);
            storedProcedure.registerOutParameterString(2);
            storedProcedure.execute();
            System.out.println("League name is "+storedProcedure.getStringReturnValue(2));
            return storedProcedure.getStringReturnValue(2);
        } catch (Exception e) {
            System.out.println("Exception in fetching League name");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }

        return null;
    }

}
