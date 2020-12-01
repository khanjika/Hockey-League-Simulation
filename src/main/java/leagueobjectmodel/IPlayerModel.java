package leagueobjectmodel;

import java.time.LocalDate;
import java.util.List;

public interface IPlayerModel {

    int getBirthDay();

    void setBirthDay(int birthDay);

    int getBirthMonth();

    void setBirthMonth(int birthMonth);

    boolean getActive();

    void setIsActive(boolean active);

    int getBirthYear();

    void setBirthYear(int birthYear);


    abstract  void checkPlayerInjury(IPlayerModel playerModel, LocalDate date);

    void recoverPlayer(IPlayerModel playerModel, LocalDate date);

    abstract void aging(IPlayerModel playerModel, int daysToAge, LocalDate date);

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

    IAgingModel getAgingModel();

    abstract void setAgingModel(IAgingModel agingModel);

    List<IFreeAgentModel> getFreeAgentsList();

    abstract void setFreeAgentsList(List<IFreeAgentModel> freeAgentsList);

    abstract IInjuriesModel getInjuriesModel();

    abstract void setInjuriesModel(IInjuriesModel injuriesModel);

    void calculatePlayerStrength(IPlayerModel playerModel);

    float calculateForwardStrength(IPlayerModel playerModel);

    float calculateDefenseStrength(IPlayerModel playerModel);

    float calculateGoalieStrength(IPlayerModel playerModel);

    void checkStatDecayDueToBirthDay(IPlayerModel playerModel, LocalDate date, int daysToAge);

    void replacePlayerWithFreeAgent(IPlayerModel playerModel, IFreeAgentModel replacementFreeAgent);

    int checkPlayerRetirementPossibility(IPlayerModel playerModel);

    float getShootingState(List<PlayerModel> playerModelList);

    float getCheckingState(List<PlayerModel> playerModelList);

    float getSavingState(List<PlayerModel> playerModelList);
}
