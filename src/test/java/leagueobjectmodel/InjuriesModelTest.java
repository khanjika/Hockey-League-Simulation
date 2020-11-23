package leagueobjectmodel;

import leagueobjectmodel.InjuriesModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InjuriesModelTest {

    @Test
    void getRandomInjuryChance() {
        InjuriesModel injuriesModel = new InjuriesModel();
        injuriesModel.setRandomInjuryChance(0.05f);
        assertEquals(0.05f, injuriesModel.getRandomInjuryChance(), "Failed to get randomInjuryChance in Injuries object");
    }

    @Test
    void setRandomInjuryChance() {
        InjuriesModel injuriesModel = new InjuriesModel();
        injuriesModel.setRandomInjuryChance(0.05f);
        assertEquals(0.05f, injuriesModel.getRandomInjuryChance(), "Failed to set randomInjuryChance in Injuries object");
    }

    @Test
    void getInjuryDaysLow() {
        InjuriesModel injuriesModel = new InjuriesModel();
        injuriesModel.setInjuryDaysLow(1);
        assertEquals(1, injuriesModel.getInjuryDaysLow(), "Failed to get InjuryDaysLow in Injuries object");
    }

    @Test
    void setInjuryDaysLow() {
        InjuriesModel injuriesModel = new InjuriesModel();
        injuriesModel.setInjuryDaysLow(1);
        assertEquals(1, injuriesModel.getInjuryDaysLow(), "Failed to set InjuryDaysLow in Injuries object");
    }

    @Test
    void getInjuryDaysHigh() {
        InjuriesModel injuriesModel = new InjuriesModel();
        injuriesModel.setInjuryDaysHigh(250);
        assertEquals(250, injuriesModel.getInjuryDaysHigh(), "Failed to get InjuryDaysHigh in Injuries object");
    }

    @Test
    void setInjuryDaysHigh() {
        InjuriesModel injuriesModel = new InjuriesModel();
        injuriesModel.setInjuryDaysHigh(250);
        assertEquals(250, injuriesModel.getInjuryDaysHigh(), "Failed to set InjuryDaysHigh in Injuries object");
    }

    public static InjuriesModel getInjuriesModel(float randomInjuryChance, int injuryDaysLow, int injuryDaysHigh) {
        InjuriesModel injuriesModel = new InjuriesModel();
        injuriesModel.setRandomInjuryChance(randomInjuryChance);
        injuriesModel.setInjuryDaysLow(injuryDaysLow);
        injuriesModel.setInjuryDaysHigh(injuryDaysHigh);
        return injuriesModel;
    }
}
