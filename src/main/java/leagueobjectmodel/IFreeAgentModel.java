package leagueobjectmodel;

import java.util.List;

public interface IFreeAgentModel {
    float getSaving();

    void setSaving(float saving);

    float getFreeAgentStrength();

    void setFreeAgentStrength(float freeAgentStrength);

    int getDays();

    void setDays(int days);

    boolean isRetired();

    void setRetired(boolean retired);

    int getRetirementLikelyHood();

    void setRetirementLikelyHood(int retirementLikelyHood);

    AgingModel getAgingModel();

    void setAgingModel(AgingModel agingModel);

    int getBirthDay();

    void setBirthDay(int birthDay);

    int getBirthMonth();

    void setBirthMonth(int birthMonth);

    int getBirthYear();

    void setBirthYear(int birthYear);

    abstract void calculateFreeAgentStrength(FreeAgentModel freeAgentModel);

    abstract void aging(FreeAgentModel freeAgentModel, int daysToAge);

    int checkRetirement(FreeAgentModel freeAgentModel);

    abstract FreeAgentModel getReplacementFreeAgent(List<FreeAgentModel> freeAgents, String playerPosition);
}
