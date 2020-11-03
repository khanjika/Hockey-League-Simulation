package gameplayconfig;

import database.CallStoredProcedure;
import java.sql.ResultSet;

public class AgingPersistent implements IAgingPersistent{

    @Override
    public int storeAgingInfomration(int averageRetiremtAge, int maximumAge) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure ("storeAgingInfomration(?, ?, ?)");
            storedProcedure.setParameter (1, averageRetiremtAge);
            storedProcedure.setParameter (2, maximumAge);
            storedProcedure.registerOutParameter (3);
            storedProcedure.execute ();
            return storedProcedure.getNumericReturnValue (3);
        } catch (Exception e) {
            System.out.println ("Exception in storing Aging model");
            System.out.println (e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return 0;
    }

    @Override
    public AgingModel getAgingInformation(int gamePlayConfigId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure ("getAgingInformation(?)");
            storedProcedure.setParameter (1, gamePlayConfigId);
            AgingModel agingModel=new AgingModel();
            ResultSet rs = storedProcedure.getResultSetObject ();
            if (rs != null) {
                while (rs.next ()) {
                        agingModel.setAverageRetirementAge(rs.getInt(2));
                        agingModel.setMaximumAge(rs.getInt(3));
                }
            }
            return agingModel;
        } catch (Exception e) {
            System.out.println ("Exception in storing league");
            System.out.println (e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean ();
            }
        }
        return null;
    }
}
