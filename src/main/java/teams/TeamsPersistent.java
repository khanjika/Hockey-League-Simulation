package teams;

import database.CallStoredProcedure;

import java.sql.ResultSet;

public class TeamsPersistent implements ITeamsPersistent{


    @Override
    public int addTeamInformation(String teamName, int generalManager , int headCoach, int divisionId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("storeNewTeamInformation(?, ?, ? ,?, ?)");
            storedProcedure.setParameter(1,teamName);
            storedProcedure.setParameter(2,generalManager);
            storedProcedure.setParameter(3,headCoach);
            storedProcedure.setParameter(4,divisionId);
            storedProcedure.registerOutParameter(5);
            storedProcedure.execute();
           // System.out.println("Newly created Team id is "+storedProcedure.getNumericReturnValue(5));
            return storedProcedure.getNumericReturnValue(5);
        } catch (Exception e) {
            System.out.println("Exception in storing team details");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return 0;
    }

    @Override
    public boolean isTeamNameExist(String teamName, int divisionId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("isTeamNameAlreadyExist(?,?,?)");
            storedProcedure.setParameter(1,teamName);
            storedProcedure.setParameter(2,divisionId);
            storedProcedure.registerOutParameter(3);
            storedProcedure.execute();
            if(storedProcedure.getNumericReturnValue(3) == 0)
            {
                return false;
            }
            else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Exception in obtaining team information");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return false;
    }

    @Override
    public int getTeamId(String teamName, int divisionId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("getTeamId(?,?,?)");
            storedProcedure.setParameter(1,teamName);
            storedProcedure.setParameter(2,divisionId);
            storedProcedure.registerOutParameter(3);
            storedProcedure.execute();
          //  System.out.println("Team id is "+storedProcedure.getNumericReturnValue(3));
            return storedProcedure.getNumericReturnValue(3);
        } catch (Exception e) {
            System.out.println("Exception in fetching information about team");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return 0;
    }

    @Override
    public int addHeadCoahDetails(String headCoachName) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("storeHeadCoackInformation(?,?)");
            storedProcedure.setParameter(1,headCoachName);
            storedProcedure.registerOutParameter(2);
            storedProcedure.execute();
          //  System.out.println("Head Coach id is "+storedProcedure.getNumericReturnValue(2));
            return storedProcedure.getNumericReturnValue(2);
        } catch (Exception e) {
            System.out.println("Exception in fetching information about head coach");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return 0;
    }

    @Override
    public int addGeneralManagerDetails(String managerName) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("storeGeneralManagerInformation(?,?)");
            storedProcedure.setParameter(1,managerName);
            storedProcedure.registerOutParameter(2);
            storedProcedure.execute();
          //  System.out.println("General Manager id is "+storedProcedure.getNumericReturnValue(2));
            return storedProcedure.getNumericReturnValue(2);
        } catch (Exception e) {
            System.out.println("Exception in fetching information about general manager");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return 0;
    }

    @Override
    public TeamPojo getTeamInformation(String teamName, int divisionId) {
        TeamPojo team = new TeamPojo();
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("getTeamInformation(?,?)");
            storedProcedure.setParameter(1,teamName);
            storedProcedure.setParameter(2,divisionId);
            ResultSet rs= storedProcedure.getResultSetObject();
            if(rs != null) {
                while (rs.next ()) {
                    team.setTeamId(rs.getInt (1));
                    team.setGeneralManagerName(rs.getString (2));
                    team.setHeadCoach(rs.getString (3));
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in obtaining team information");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return team;
    }

}
