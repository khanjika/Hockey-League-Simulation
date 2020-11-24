package leagueobjectmodel;

import java.time.LocalDate;
import java.util.List;

public interface IPlayerModel {

    int getBirthDay();

    void setBirthDay(int birthDay);

    int getBirthMonth();

    void setBirthMonth(int birthMonth);

    int getBirthYear();

    void setBirthYear(int birthYear);

    abstract void calculatePlayerStrength(PlayerModel playerModel);

    abstract void checkPlayerInjury(PlayerModel playerModel, LocalDate date);

    void recoverPlayer(PlayerModel playerModel, LocalDate date);

    abstract void aging(PlayerModel playerModel, int daysToAge, LocalDate date);

    String getPlayerName();

    void setPlayerName(String playerName);

    String getPosition();

    void setPosition(String position);

    Boolean isCaptain();

    void setCaptain(Boolean captain);

    int getAge();

    void setAge(int age);

    float getSkating();

    void setSkating(float skating);

    float getShooting();

    void setShooting(float shooting);

    float getChecking();

    void setChecking(float checking);

    float getSaving();

    void setSaving(float saving);

    float getPlayerStrength();

    void setPlayerStrength(float playerStrength);

    boolean isPlayerInjured();

    void setPlayerInjured(boolean playerInjured);

    LocalDate getInjuredDate();

    void setInjuredDate(LocalDate injuredDate);

    int getInjuryDays();

    void setInjuryDays(int injuryDays);

    LocalDate getRecoveryDate();

    void setRecoveryDate(LocalDate recoveryDate);

    Boolean isPlayerRetired();

    void setPlayerRetired(Boolean playerRetired);

    int getDays();

    void setDays(int days);

    int getRetirementLikelyHood();

    void setRetirementLikelyHood(int retirementLikelyHood);

    AgingModel getAgingModel();

    abstract void setAgingModel(AgingModel agingModel);

    List<FreeAgentModel> getFreeAgentsList();

    abstract void setFreeAgentsList(List<FreeAgentModel> freeAgentsList);

    abstract InjuriesModel getInjuriesModel();

    abstract void setInjuriesModel(InjuriesModel injuriesModel);

    void replacePlayerWithFreeAgent(PlayerModel playerModel, FreeAgentModel replacementFreeAgent);

    int checkPlayerRetirementPossibility(PlayerModel playerModel);
}
