package gameplayconfig;

import com.google.gson.annotations.Expose;
import states.AgingState;

public class AgingModel implements IAgingModel{
    @Expose
    private int averageRetirementAge;
    @Expose
    private int maximumAge;

    IAgingPersistent iAgingPersistent;
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

    public int addAgingInformation(AgingModel agingModel){
        iAgingPersistent=new AgingPersistent();
        return iAgingPersistent.storeAgingInfomration(agingModel.getAverageRetirementAge(),agingModel.getMaximumAge());
    }
}
