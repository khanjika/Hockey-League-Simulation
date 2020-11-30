package leagueobjectmodel;

import com.google.gson.annotations.Expose;

public class AgingModel implements IAgingModel {
    @Expose
    private int averageRetirementAge;
    @Expose
    private int maximumAge;
    @Expose
    private float statDecayChance;

    @Override
    public int getAverageRetirementAge() {
        return averageRetirementAge;
    }

    @Override
    public void setAverageRetirementAge(int averageRetirementAge) {
        this.averageRetirementAge = averageRetirementAge;
    }

    @Override
    public int getMaximumAge() {
        return maximumAge;
    }

    @Override
    public void setMaximumAge(int maximumAge) {
        this.maximumAge = maximumAge;
    }

    @Override
    public float getStatDecayChance() {
        return statDecayChance;
    }

    @Override
    public void setStatDecayChance(float statDecayChance) {
        this.statDecayChance = statDecayChance;
    }

}
