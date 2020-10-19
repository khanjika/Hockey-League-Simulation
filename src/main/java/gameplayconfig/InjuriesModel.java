package gameplayconfig;

public class InjuriesModel implements IInjuriesModel {
    private float randomInjuryChance;
    private int injuryDaysLow;
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
