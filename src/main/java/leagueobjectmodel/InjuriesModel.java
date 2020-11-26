package leagueobjectmodel;

import com.google.gson.annotations.Expose;

public class InjuriesModel implements IInjuriesModel {
    @Expose
    private float randomInjuryChance;
    @Expose
    private int injuryDaysLow;
    @Expose
    private int injuryDaysHigh;

    @Override
    public float getRandomInjuryChance() {
        return randomInjuryChance;
    }

    @Override
    public void setRandomInjuryChance(float randomInjuryChance) {
        this.randomInjuryChance = randomInjuryChance;
    }

    @Override
    public int getInjuryDaysLow() {
        return injuryDaysLow;
    }

    @Override
    public void setInjuryDaysLow(int injuryDaysLow) {
        this.injuryDaysLow = injuryDaysLow;
    }

    @Override
    public int getInjuryDaysHigh() {
        return injuryDaysHigh;
    }

    @Override
    public void setInjuryDaysHigh(int injuryDaysHigh) {
        this.injuryDaysHigh = injuryDaysHigh;
    }

}
