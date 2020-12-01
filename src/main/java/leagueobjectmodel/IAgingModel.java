package leagueobjectmodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = AgingModel.class)
public interface IAgingModel {
    int getAverageRetirementAge();

    void setAverageRetirementAge(int averageRetirementAge);

    int getMaximumAge();

    void setMaximumAge(int maximumAge);

    float getStatDecayChance();

    void setStatDecayChance(float statDecayChance);

}
