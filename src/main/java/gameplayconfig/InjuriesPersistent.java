package gameplayconfig;

import database.CallStoredProcedure;

import java.sql.ResultSet;

public class InjuriesPersistent implements IInjuriesPersistent {
    @Override
    public int storeInjuriesInformation(float randomInjuryChance, int injuryDaysLow, int injuryDaysHigh) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("storeInjuriesInformation(?,?,?,?)");
            storedProcedure.setParameter(1, randomInjuryChance);
            storedProcedure.setParameter(2, injuryDaysLow);
            storedProcedure.setParameter(3, injuryDaysHigh);
            storedProcedure.registerOutParameter(4);

            storedProcedure.execute();
            return storedProcedure.getNumericReturnValue(4);
        } catch (Exception e) {
            System.out.println("Exception in Injuries Model");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean();
            }
        }
        return 0;
    }

    @Override
    public InjuriesModel getInjuriesInformation(int gamePlayConfigId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("getAgingInformation(?)");
            storedProcedure.setParameter(1, gamePlayConfigId);
            InjuriesModel injuriesModel = new InjuriesModel();
            ResultSet rs = storedProcedure.getResultSetObject();
            if (rs != null) {
                while (rs.next()) {
                    injuriesModel.setRandomInjuryChance(rs.getFloat(2));
                    injuriesModel.setInjuryDaysLow(rs.getInt(3));
                    injuriesModel.setInjuryDaysHigh(rs.getInt(4));
                }
            }
            return injuriesModel;
        } catch (Exception e) {
            System.out.println("Exception in storing league");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean();
            }
        }
        return null;
    }

}
