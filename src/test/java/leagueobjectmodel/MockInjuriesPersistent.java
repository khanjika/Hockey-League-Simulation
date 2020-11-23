package leagueobjectmodel;


public class MockInjuriesPersistent {
    int storeInjuriesInformation(float randomInjuryChance, int injuryDaysLow, int injuryDaysHigh) {
        return 0;
    }

    InjuriesModel getInjuriesInformation(int gamePlayConfigId) {
        InjuriesModel injuriesModel = new InjuriesModel();
        injuriesModel.setRandomInjuryChance(0.05f);
        injuriesModel.setInjuryDaysLow(1);
        injuriesModel.setInjuryDaysHigh(250);
        return injuriesModel;
    }
}
