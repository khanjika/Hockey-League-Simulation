package gameplayconfig;

import com.google.gson.annotations.Expose;

public class AgingModel implements IAgingModel{
    @Expose
    private int averageRetirementAge;
    @Expose
    private int maximumAge;

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
}
