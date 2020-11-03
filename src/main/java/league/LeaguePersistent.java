package league;

import database.CallStoredProcedure;

public class LeaguePersistent implements ILeaguePersistent {

    public int addLeagueInformation(String leagueName, int gamePlayConfigId, int timePassedId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure ("storeNewLeagueInformation(?,?,?,?)");
            storedProcedure.setParameter (1, leagueName);
            storedProcedure.setParameter(2,gamePlayConfigId);
            storedProcedure.setParameter(3,timePassedId);
            storedProcedure.registerOutParameter (4);
            storedProcedure.execute ();
            return storedProcedure.getNumericReturnValue (4);
        } catch (Exception e) {
            System.out.println ("Exception in storing league");
            System.out.println (e);
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
            storedProcedure = new CallStoredProcedure ("isLeagueNameAlreadyExist(?, ?)");
            storedProcedure.setParameter (1, leagueName);
            storedProcedure.registerOutParameter (2);
            storedProcedure.execute ();
            if (storedProcedure.getNumericReturnValue (2) == 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println ("Exception in obtaining League information");
            System.out.println (e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return false;
    }

    @Override
    public void storeAvailableGeneralManagerInformation(int leagueId, String generalManagerName) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("storeAvailableGeneralManagerInformation(?, ?, ?)");
            storedProcedure.setParameter(1, leagueId);
            storedProcedure.setParameter(2, generalManagerName);
            storedProcedure.registerOutParameter (3);
            storedProcedure.execute ();
        } catch (Exception e) {
            System.out.println("Exception in storing league");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean();
            }
        }
    }


    @Override
    public String getLeagueInformation(int leagueId) {
        LeagueModel league = new LeagueModel ();
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure ("getLeagueInfo(?,?)");
            storedProcedure.setParameter (1, leagueId);
            storedProcedure.registerOutParameterString (2);
            storedProcedure.execute ();
            return storedProcedure.getStringReturnValue (2);
        } catch (Exception e) {
            System.out.println ("Exception in fetching League name");
            System.out.println (e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }

        return null;
    }

    @Override
    public int getLeagueId(String leagueName) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure ("getLeagueId(?, ?)");
            storedProcedure.setParameter (1, leagueName);
            storedProcedure.registerOutParameter (2);
            storedProcedure.execute ();
            return storedProcedure.getNumericReturnValue (2);
        } catch (Exception e) {
            System.out.println ("Exception in getting id of league");
            System.out.println (e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return 0;

    }

}
