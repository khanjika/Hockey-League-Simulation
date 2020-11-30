package leagueobjectmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static java.time.temporal.ChronoUnit.DAYS;

public class PlayerModel implements IPlayerModel {

    @Expose
    private String playerName;
    @Expose
    private String position;
    @Expose
    @JsonProperty(required = true)
    private Boolean captain;
    @Expose
    private int age;
    private boolean isPlayerRetired;
    private int days;
    private float skating;
    @Expose
    private float shooting;
    @Expose
    private float checking;
    @Expose
    private float saving;
    @Expose
    private int birthDay;
    @Expose
    private int birthMonth;
    @Expose
    private int birthYear;
    private boolean isActive;
    private float playerStrength;
    private int retirementLikelyHood;
    private int injuryDays;
    private boolean isPlayerInjured;
    private LocalDate injuredDate;
    private LocalDate recoveryDate;
    private AgingModel agingModel;
    private InjuriesModel injuriesModel;
    private IFreeAgentModel freeAgentModel;
    private List<FreeAgentModel> freeAgentsList;
    private int saveForGoalie;
    private int goalScorerCount;
    private int currentPenaltyCount;
    private int totalPenaltyCount;


    public PlayerModel() {
        freeAgentModel = new FreeAgentModel();
    }

    public PlayerModel(String playerName, String position, Boolean captain, int age, float skating, float shooting, float checking, float saving, int birthDay, int birthMonth, int birthYear) {
        this.playerName = playerName;
        this.position = position;
        this.captain = captain;
        this.age = age;
        this.skating = skating;
        this.shooting = shooting;
        this.checking = checking;
        this.saving = saving;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }

    public int getCurrentPenaltyCount() {
        return currentPenaltyCount;
    }

    public void setCurrentPenaltyCount(int currentPenaltyCount) {
        this.currentPenaltyCount = currentPenaltyCount;
    }

    public int getTotalPenaltyCount() {
        return totalPenaltyCount;
    }

    public void setTotalPenaltyCount(int totalPenaltyCount) {
        this.totalPenaltyCount = totalPenaltyCount;
    }

    public int getGoalScorerCount() {
        return goalScorerCount;
    }

    public void setGoalScorerCount(int goalScorerCount) {
        this.goalScorerCount = goalScorerCount;
    }

    public int getSaveForGoalie() {
        return saveForGoalie;
    }

    public void setSaveForGoalie(int saveForGoalie) {
        this.saveForGoalie = saveForGoalie;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public Boolean isCaptain() {
        return captain;
    }

    @Override
    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public float getSkating() {
        return skating;
    }

    @Override
    public void setSkating(float skating) {
        this.skating = skating;
    }

    @Override
    public float getShooting() {
        return shooting;
    }

    @Override
    public void setShooting(float shooting) {
        this.shooting = shooting;
    }

    @Override
    public float getChecking() {
        return checking;
    }

    @Override
    public void setChecking(float checking) {
        this.checking = checking;
    }

    @Override
    public float getSaving() {
        return saving;
    }

    @Override
    public void setSaving(float saving) {
        this.saving = saving;
    }

    @Override
    public float getPlayerStrength() {
        return playerStrength;
    }

    @Override
    public void setPlayerStrength(float playerStrength) {
        this.playerStrength = playerStrength;
    }

    @Override
    public boolean isPlayerInjured() {
        return isPlayerInjured;
    }

    @Override
    public void setPlayerInjured(boolean playerInjured) {
        isPlayerInjured = playerInjured;
    }

    @Override
    public LocalDate getInjuredDate() {
        return injuredDate;
    }

    @Override
    public void setInjuredDate(LocalDate injuredDate) {
        this.injuredDate = injuredDate;
    }

    @Override
    public int getInjuryDays() {
        return injuryDays;
    }

    @Override
    public void setInjuryDays(int injuryDays) {
        this.injuryDays = injuryDays;
    }

    @Override
    public LocalDate getRecoveryDate() {
        return recoveryDate;
    }

    @Override
    public void setRecoveryDate(LocalDate recoveryDate) {
        this.recoveryDate = recoveryDate;
    }

    @Override
    public Boolean isPlayerRetired() {
        return isPlayerRetired;
    }

    @Override
    public void setPlayerRetired(Boolean playerRetired) {
        isPlayerRetired = playerRetired;
    }

    @Override
    public boolean getActive() {
        return isActive;
    }

    @Override
    public void setActive(boolean active) {
        this.isActive = active;
    }

    @Override
    public int getDays() {
        return days;
    }

    @Override
    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public int getRetirementLikelyHood() {
        return retirementLikelyHood;
    }

    @Override
    public void setRetirementLikelyHood(int retirementLikelyHood) {
        this.retirementLikelyHood = retirementLikelyHood;
    }

    @Override
    public AgingModel getAgingModel() {
        return agingModel;
    }

    @Override
    public void setAgingModel(AgingModel agingModel) {
        this.agingModel = agingModel;
    }

    @Override
    public List<FreeAgentModel> getFreeAgentsList() {
        return freeAgentsList;
    }

    @Override
    public void setFreeAgentsList(List<FreeAgentModel> freeAgentsList) {
        this.freeAgentsList = freeAgentsList;
    }

    @Override
    public InjuriesModel getInjuriesModel() {
        return injuriesModel;
    }

    @Override
    public void setInjuriesModel(InjuriesModel injuriesModel) {
        this.injuriesModel = injuriesModel;
    }

    @Override
    public int getBirthDay() {
        return birthDay;
    }

    @Override
    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public int getBirthMonth() {
        return birthMonth;
    }

    @Override
    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    @Override
    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public void calculatePlayerStrength(IPlayerModel playerModel) {
        try {
            float strength = 0;
            if (playerModel.getPosition().equals(PlayerPosition.FORWARD.toString())) {
                strength = calculateForwardStrength(playerModel);
            } else if (playerModel.getPosition().equals(PlayerPosition.DEFENSE.toString())) {
                strength = calculateDefenseStrength(playerModel);
            } else if (playerModel.getPosition().equals(PlayerPosition.GOALIE.toString())) {
                strength = calculateGoalieStrength(playerModel);
            }
            if (playerModel.isPlayerInjured()) {
                playerModel.setPlayerStrength(strength / 2);
            } else {
                playerModel.setPlayerStrength(strength);
            }
        } catch (Exception e) {
            System.out.println("Error in calculateStrength method of player model" + e);
        }
    }

    @Override
    public float calculateForwardStrength(IPlayerModel playerModel){
        return playerModel.getSkating() + playerModel.getShooting() + (playerModel.getChecking() / 2);
    }

    @Override
    public float calculateDefenseStrength(IPlayerModel playerModel){
        return playerModel.getSkating() + playerModel.getChecking() + (playerModel.getShooting() / 2);
    }

    @Override
    public float calculateGoalieStrength(IPlayerModel playerModel){
        return playerModel.getSkating() + playerModel.getSaving();
    }

    @Override
    public void checkPlayerInjury(IPlayerModel playerModel, LocalDate date) {
        if (playerModel.isPlayerInjured() == false) {
            float randomInjuryChance = injuriesModel.getRandomInjuryChance();
            int injuryDaysLow = injuriesModel.getInjuryDaysLow();
            int injuryDaysHigh = injuriesModel.getInjuryDaysHigh();
            Random randomObj = new Random();
            float injuryChance = randomObj.nextFloat();
            int injuryDays = randomObj.nextInt(injuryDaysHigh - injuryDaysLow) + injuryDaysLow;
            if (injuryChance > randomInjuryChance) {
                playerModel.setPlayerInjured(true);
                playerModel.setInjuryDays(injuryDays);
                playerModel.setInjuredDate(date);
                playerModel.setRecoveryDate(date.plusDays(injuryDays));
                System.out.println(playerModel.getPlayerName() + " Player Injured for " + playerModel.getInjuryDays() + " Days");
            }
        }
    }

    @Override
    public void recoverPlayer(PlayerModel playerModel, LocalDate date) {
        try {
            long recoveryDayDifference = 0;
            if (playerModel.getRecoveryDate() != null) {
                recoveryDayDifference = DAYS.between(playerModel.getRecoveryDate(), date);
            }
            if (playerModel.getRecoveryDate() == null) {
                return;
            } else if (recoveryDayDifference < 0) {
                playerModel.setPlayerInjured(false);
                playerModel.setInjuryDays(0);
                playerModel.setInjuredDate(null);
                playerModel.setRecoveryDate(null);
                System.out.println(playerModel.getPlayerName() + " Player Recovered from Injury");
            }
            if(playerModel.isPlayerInjured() == false){

            }
        } catch (Exception e) {
            System.out.println("Error in checkPlayerInjury method of player model" + e);
        }
    }

    @Override
    public void aging(PlayerModel playerModel, int daysToAge, LocalDate date) {
        try {
            if(playerModel == null){
                throw new NullPointerException("Player Model is Null inside Aging method");
            }
            LocalDate playerBirthDay = LocalDate.of(playerModel.getBirthYear(),playerModel.getBirthMonth(),playerModel.getBirthDay());

            int days = playerModel.getDays();
            int playerAge = playerModel.getAge();
            if (days + daysToAge >= 365) {
                playerModel.setAge(playerAge + 1);
                playerModel.setDays(0);
            } else {
                playerModel.setDays(days + daysToAge);
            }
            playerModel.recoverPlayer(playerModel, date);
            int retirementLikelyHood = checkPlayerRetirementPossibility(playerModel);
            if (retirementLikelyHood >= 90) {
                playerModel.setPlayerRetired(true);
            }
            if (playerModel.isPlayerRetired()) {
                String playerPosition = playerModel.getPosition();
                List<FreeAgentModel> availableFreeAgents = this.getFreeAgentsList();
                FreeAgentModel replacementFreeAgent = freeAgentModel.getReplacementFreeAgent(availableFreeAgents, playerPosition);
                System.out.println("Player " + playerModel.getPlayerName() + " is Retired and Replace with FreeAgent " + replacementFreeAgent.getPlayerName());
                replacePlayerWithFreeAgent(playerModel, replacementFreeAgent);
            }
        } catch (Exception e) {
            System.out.println("Player INFO: " +playerModel.getPlayerName()+" ---- "+playerModel.getBirthMonth());
            System.out.println("Error in aging method of player model" + e);
        }
    }

    @Override
    public void replacePlayerWithFreeAgent(PlayerModel playerModel, FreeAgentModel replacementFreeAgent) {
        try {
            if (replacementFreeAgent == null) {
                return;
            }
            System.out.println("Replacing Player " + playerModel.getPlayerName() + " With Free Agent " + replacementFreeAgent.getPlayerName());
            playerModel.setPlayerName(replacementFreeAgent.getPlayerName());
            playerModel.setPosition(replacementFreeAgent.getPosition());
            playerModel.setAge(replacementFreeAgent.getAge());
            playerModel.setSkating(replacementFreeAgent.getSkating());
            playerModel.setShooting(replacementFreeAgent.getShooting());
            playerModel.setChecking(replacementFreeAgent.getChecking());
            playerModel.setSaving(replacementFreeAgent.getSaving());
            playerModel.setPlayerStrength(replacementFreeAgent.getFreeAgentStrength());
            playerModel.setDays(replacementFreeAgent.getDays());
            playerModel.setPlayerInjured(false);
            playerModel.setInjuredDate(null);
            playerModel.setInjuryDays(0);
            playerModel.setRecoveryDate(null);
            playerModel.setRetirementLikelyHood(0);
            playerModel.setPlayerRetired(false);
        } catch (Exception e) {
            System.out.println("Error in replacePlayerWithFreeAgent method of player model");
        }
    }

    @Override
    public int checkPlayerRetirementPossibility(PlayerModel playerModel) {
        int playerAge = playerModel.getAge();
        int averageRetirementAge = agingModel.getAverageRetirementAge();
        int maximumAge = agingModel.getMaximumAge();
        int likelyHood = playerModel.getRetirementLikelyHood();
        Random randomObj = new Random();
        if (playerAge >= maximumAge) {
            likelyHood = 100;
        } else {
            int AgeDifference = averageRetirementAge - playerAge;
            if (AgeDifference >= 0) {
                likelyHood = randomObj.nextInt(50);
            } else if (AgeDifference >= -5) {
                likelyHood = randomObj.nextInt(60 - 50) + 50;
            } else if (AgeDifference >= -10) {
                likelyHood = randomObj.nextInt(70 - 60) + 60;
            } else {
                likelyHood = randomObj.nextInt(99 - 70) + 70;
            }
        }
        playerModel.setRetirementLikelyHood(likelyHood);
        return likelyHood;
    }

    @Override
    public float getShootingState(List<PlayerModel> playerModelList){
        if(playerModelList==null){
            throw new NullPointerException();
        }
        float shootingState = 0;
        for (PlayerModel playerModel : playerModelList) {
            shootingState = shootingState + playerModel.getShooting();
        }
        return shootingState;
    }

    @Override
    public float getCheckingState(List<PlayerModel> playerModelList) {
        if(playerModelList==null){
            throw new NullPointerException();
        }
        float checkingState = 0;
        for (PlayerModel playerModel : playerModelList) {
            if (playerModel.getCurrentPenaltyCount() > 0) {
                playerModel.setCurrentPenaltyCount(playerModel.getCurrentPenaltyCount() - 1);
            } else {
                checkingState = checkingState + playerModel.getChecking();
            }
        }
        return checkingState;
    }

    @Override
    public float getSavingState(List<PlayerModel> playerModelList) {
        if(playerModelList==null){
            throw new NullPointerException();
        }
        float savingSate = 0;
        for (PlayerModel playerModel : playerModelList) {
            savingSate = savingSate + playerModel.getSaving();
        }
        return savingSate;
    }

}
