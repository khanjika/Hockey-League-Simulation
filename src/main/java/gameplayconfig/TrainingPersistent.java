package gameplayconfig;


import database.CallStoredProcedure;

import java.sql.ResultSet;

public class TrainingPersistent implements ITrainingPersistent {

    @Override
    public int storeTrainingInformation(int daysUntilStateIncreaseCheck) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("storeTrainingInformation(?, ?)");
            storedProcedure.setParameter(1, daysUntilStateIncreaseCheck);
            storedProcedure.registerOutParameter(2);
            storedProcedure.execute();
            return storedProcedure.getNumericReturnValue(2);
        } catch (Exception e) {
            System.out.println("Exception in storing league");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean();
            }
        }
        return 0;
    }

    @Override
    public TrainingModel getTrainingInformation(int gamePlayConfigId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("GetTrainingInformation(?)");
            storedProcedure.setParameter(1, gamePlayConfigId);
            TrainingModel trainingModel = new TrainingModel();
            ResultSet rs = storedProcedure.getResultSetObject();
            if (rs != null) {
                while (rs.next()) {
                    trainingModel.setDaysUntilStatIncreaseCheck(rs.getInt(2));
                }
            }
            return trainingModel;
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
