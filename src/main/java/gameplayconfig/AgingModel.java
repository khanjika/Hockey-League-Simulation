package gameplayconfig;

public class AgingModel implements IAgingModel{
    private int averageRetirementAge;
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
