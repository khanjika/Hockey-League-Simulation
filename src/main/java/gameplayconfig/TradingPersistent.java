package gameplayconfig;

import database.CallStoredProcedure;

import java.sql.ResultSet;

public class TradingPersistent implements ITradingPersistent {
    @Override
    public int storeTradingInformation(int lossPoint, float randomTradeOfferChance, int maxPlayerPerTrade, float randomAcceptanceChance) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("storeTradingInformation(?,?,?,?,?)");
            storedProcedure.setParameter(1, lossPoint);
            storedProcedure.setParameter(2, randomTradeOfferChance);
            storedProcedure.setParameter(3, maxPlayerPerTrade);
            storedProcedure.setParameter(4, randomAcceptanceChance);
            storedProcedure.registerOutParameter(5);
            storedProcedure.execute();
            return storedProcedure.getNumericReturnValue(5);
        } catch (Exception e) {
            System.out.println("Exception in storing Trading Model");
            System.out.println(e);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.clean();
            }
        }
        return 0;

    }

    @Override
    public TradingModel getTradingInformation(int gamePlayConfigId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("getTradingInformation(?)");
            storedProcedure.setParameter(1, gamePlayConfigId);
            TradingModel tradingModel = new TradingModel();
            ResultSet rs = storedProcedure.getResultSetObject();
            if (rs != null) {
                while (rs.next()) {
                    tradingModel.setLossPoint(rs.getInt(2));
                    tradingModel.setRandomTradeOfferChance(rs.getFloat(3));
                    tradingModel.setMaxPlayersPerTrade(rs.getInt(4));
                    tradingModel.setRandomAcceptanceChance(rs.getFloat(5));
                }
            }
            return tradingModel;
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
