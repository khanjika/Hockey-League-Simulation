package leagueobjectmodel;

public interface IAgingModel {
    int getAverageRetirementAge();

    void setAverageRetirementAge(int averageRetirementAge);

    int getMaximumAge();

    void setMaximumAge(int maximumAge);

    float getStatDecayChance();

    void setStatDecayChance(float statDecayChance);

}
