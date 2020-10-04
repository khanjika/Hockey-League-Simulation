package teams;

import database.CallStoredProcedure;

public class TeamsPersistent implements ITeamsPersistent{


    @Override
    public int addTeamInformation(String teamName, String headCoach, String generalManager, int divisionId) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("storeNewTeamInformation(?,?,?,?)");
            proc.setParameter(1,teamName);
            proc.setParameter(2,generalManager);
            proc.setParameter(3,headCoach);
            proc.setParameter(4,divisionId);
            proc.registerOutParameter(5);
            proc.execute();
            System.out.println("Newly created Team id is "+proc.getNumericReturnValue(5));
            return proc.getNumericReturnValue(5);
        } catch (Exception e) {
            System.out.println("Exception is Team");
            System.out.println(e);
        } finally {
            if (null != proc) {
                //DO CLEANUP
            }
        }
        return 0;
    }

    @Override
    public boolean isTeamNameExist(String teamName) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("IsLeagueNameAlreadyExist(?)");
            proc.setParameter(1,teamName);
            proc.registerOutParameter(2);
            proc.execute();
            int newlyReturedValue= proc.getNumericReturnValue(2);
            if(newlyReturedValue == 1){
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception is Team");
            System.out.println(e);
        } finally {
            if (null != proc) {
                //DO CLEANUP
            }
        }
        return false;
    }
}
