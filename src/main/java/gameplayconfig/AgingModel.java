package gameplayconfig;

import com.google.gson.annotations.Expose;

public class AgingModel implements IAgingModel {
    IAgingPersistent iAgingPersistent;
    @Expose
    private int averageRetirementAge;
    @Expose
    private int maximumAge;
    private float statDecayChance;

    public int getAverageRetirementAge() {
        return averageRetirementAge;
    }

    public void setAverageRetirementAge(int averageRetirementAge) {
        this.averageRetirementAge = averageRetirementAge;
    }

    public int getMaximumAge() {
        return maximumAge;
    }

    public void setMaximumAge(int maximumAge) {
        this.maximumAge = maximumAge;
    }

    public float getStatDecayChance() { return statDecayChance; }

    public void setStatDecayChance(float statDecayChance) { this.statDecayChance = statDecayChance; }

    public int addAgingInformation(AgingModel agingModel) {
        iAgingPersistent = new AgingPersistent();
        return iAgingPersistent.storeAgingInfomration(agingModel.getAverageRetirementAge(), agingModel.getMaximumAge());
    }
}
