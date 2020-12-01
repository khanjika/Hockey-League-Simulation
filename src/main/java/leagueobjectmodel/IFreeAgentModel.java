package leagueobjectmodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;
import java.util.List;
@JsonDeserialize(as = FreeAgentModel.class)
public interface IFreeAgentModel {
    String getPlayerName();

    void setPlayerName(String playerName);

    String getPosition();

    void setPosition(String position);

    int getAge();

    abstract void setAge(int age);

    float getSkating();

    void setSkating(float skating);

    float getShooting();

    void setShooting(float shooting);

    float getChecking();

    void setChecking(float checking);

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

    IAgingModel getAgingModel();

    void setAgingModel(IAgingModel agingModel);

    int getBirthDay();

    void setBirthDay(int birthDay);

    int getBirthMonth();

    void setBirthMonth(int birthMonth);

    int getBirthYear();

    void setBirthYear(int birthYear);

    void calculateFreeAgentStrength(IFreeAgentModel freeAgentModel);

    void aging(IFreeAgentModel freeAgentModel, LocalDate date, int daysToAge);

    int checkRetirement(IFreeAgentModel freeAgentModel);

    abstract IFreeAgentModel getReplacementFreeAgent(List<IFreeAgentModel> freeAgents, String playerPosition);

    List<IFreeAgentModel> sortFreeAgentDescending(List<IFreeAgentModel> freeAgents);

}
