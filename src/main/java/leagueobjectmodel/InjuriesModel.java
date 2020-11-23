package leagueobjectmodel;

import com.google.gson.annotations.Expose;

public class InjuriesModel implements IInjuriesModel {
    @Expose
    private float randomInjuryChance;
    @Expose
    private int injuryDaysLow;
    @Expose
    private int injuryDaysHigh;

    public float getRandomInjuryChance() {
        return randomInjuryChance;
    }

    public void setRandomInjuryChance(float randomInjuryChance) {
        this.randomInjuryChance = randomInjuryChance;
    }

    public int getInjuryDaysLow() {
        return injuryDaysLow;
    }

    public void setInjuryDaysLow(int injuryDaysLow) {
        this.injuryDaysLow = injuryDaysLow;
    }

    public int getInjuryDaysHigh() {
        return injuryDaysHigh;
    }

    public void setInjuryDaysHigh(int injuryDaysHigh) {
        this.injuryDaysHigh = injuryDaysHigh;
    }

}
