package leagueobjectmodel;

import cli.CliAbstractFactory;
import cli.ICli;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static java.time.temporal.ChronoUnit.DAYS;

public class PlayerModel implements IPlayerModel {

    private final int RETIRE_LIKELIHOOD_THRESHOLD = 90;
    private final int MAX_RETIRE_LIKELIHOOD = 100;
    private final int LOW_RETIRE_LIKELIHOOD = 50;
    private final int AVERAGE_RETIRE_LIKELIHOOD = 60;
    private final int MEDIUM_RETIRE_LIKELIHOOD = 70;
    private final int HIGH_RETIRE_LIKELIHOOD = 99;
    private final int MIN_DIFFERENCE = -5;
    private final int MAX_DIFFERENCE = -10;
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
    private IAgingModel agingModel;
    private IInjuriesModel injuriesModel;
    private IFreeAgentModel freeAgentModel;
    private List<IFreeAgentModel> freeAgentsList;
    private int saveForGoalie;
    private int goalScorerCount;
    private int currentPenaltyCount;
    private int totalPenaltyCount;
    private Random random = LeagueObjectModelAbstractFactory.getInstance().createRandom();
    final static Logger logger = Logger.getLogger(PlayerModel.class);
    ICli cli = CliAbstractFactory.getInstance().getCli();
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
    public void setIsActive(boolean active) {
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
    public IAgingModel getAgingModel() {
        return agingModel;
    }

    @Override
    public void setAgingModel(IAgingModel agingModel) {
        this.agingModel = agingModel;
    }

    @Override
    public List<IFreeAgentModel> getFreeAgentsList() {
        return freeAgentsList;
    }

    @Override
    public void setFreeAgentsList(List<IFreeAgentModel> freeAgentsList) {
        this.freeAgentsList = freeAgentsList;
    }

    @Override
    public IInjuriesModel getInjuriesModel() {
        return injuriesModel;
    }

    @Override
    public void setInjuriesModel(IInjuriesModel injuriesModel) {
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
        if(playerModel==null){
            logger.error("Method argument is not set properly in calculatePlayerStrength()");
            throw new NullPointerException();
        }
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
            cli.printOutput("Error in calculateStrength method of player model" + e);
            throw e;
        }
    }

    @Override
    public float calculateForwardStrength(IPlayerModel playerModel){
        if(playerModel==null){
            logger.error("Method argument is not set properly in calculateForwardStrength()");
            throw new NullPointerException();
        }
        return playerModel.getSkating() + playerModel.getShooting() + (playerModel.getChecking() / 2);
    }

    @Override
    public float calculateDefenseStrength(IPlayerModel playerModel){
        if(playerModel==null){
            logger.error("Method argument is not set properly in calculateDefenseStrength()");
            throw new NullPointerException();
        }
        return playerModel.getSkating() + playerModel.getChecking() + (playerModel.getShooting() / 2);
    }

    @Override
    public float calculateGoalieStrength(IPlayerModel playerModel){
        if(playerModel==null){
            logger.error("Method argument is not set properly in calculateGoalieStrength()");
            throw new NullPointerException();
        }
        return playerModel.getSkating() + playerModel.getSaving();
    }

    @Override
    public void checkPlayerInjury(IPlayerModel playerModel, LocalDate date) {
        try{
            if (playerModel == null || date == null) {
                logger.error("Argument Null inside checkPlayerInjury");
                throw new NullPointerException("Argument Null inside checkPlayerInjury");
            }
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
               cli.printOutput(playerModel.getPlayerName() + " Player Injured for " + playerModel.getInjuryDays() + " Days");
            }
        }
    }catch (Exception e){
           throw e;
        }
    }

    @Override
    public void recoverPlayer(IPlayerModel playerModel, LocalDate date) {
        try {
            if (playerModel == null || date == null) {
                logger.error("Argument Null inside checkPlayerInjury");
                throw new NullPointerException("Argument is Null inside recover method");
            }
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
               cli.printOutput(playerModel.getPlayerName() + " Player Recovered from Injury");
            }
            if(playerModel.isPlayerInjured() == false){

            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void aging(IPlayerModel playerModel, int daysToAge, LocalDate date) {
        try {
            if (playerModel == null || daysToAge == 0 || date == null) {
                throw new NullPointerException("Argument is Null inside Aging method");
            }
            int playerAge = date.getYear() - playerModel.getBirthYear();
            LocalDate playerBirthDate = LocalDate.of(playerModel.getBirthYear(), playerModel.getBirthMonth(), playerModel.getBirthDay());
            LocalDate upcomingBirthDate = LocalDate.of(date.getYear(), playerModel.getBirthMonth(), playerModel.getBirthDay());
            LocalDate agingDate = date.plusDays(daysToAge);
            playerModel.setAge(playerAge);
            if (upcomingBirthDate.isBefore(agingDate)) {
                playerModel.setAge(agingDate.getYear() - playerModel.getBirthYear() + 1);
            } else {
                playerModel.setAge(agingDate.getYear() - playerModel.getBirthYear());
            }
            checkStatDecayDueToBirthDay(playerModel,date,daysToAge);
            playerModel.recoverPlayer(playerModel, date);
            int retirementLikelyHood = checkPlayerRetirementPossibility(playerModel);
            if (retirementLikelyHood >= RETIRE_LIKELIHOOD_THRESHOLD) {
               cli.printOutput("Player Retired: "+playerModel.getPlayerName());
                playerModel.setPlayerRetired(true);
            }
            if (playerModel.isPlayerRetired()) {
                String playerPosition = playerModel.getPosition();
                List<IFreeAgentModel> availableFreeAgents = this.getFreeAgentsList();
                IFreeAgentModel replacementFreeAgent = freeAgentModel.getReplacementFreeAgent(availableFreeAgents, playerPosition);
              cli.printOutput("Player " + playerModel.getPlayerName() + " is Retired and Replace with FreeAgent " + replacementFreeAgent.getPlayerName());
                replacePlayerWithFreeAgent(playerModel, replacementFreeAgent);
            }
        } catch (Exception e) {
           throw e;
        }
    }

    @Override
    public void checkStatDecayDueToBirthDay(IPlayerModel playerModel, LocalDate date, int daysToAge){
        if(playerModel == null || date == null || daysToAge == 0){
            throw new NullPointerException("Argument missing in checkStatDecayDueToBirthDay method");
        }
        LocalDate upcomingBirthDate = LocalDate.of(date.getYear(), playerModel.getBirthMonth(), playerModel.getBirthDay());
        LocalDate agingDate = date.plusDays(daysToAge);
        if(upcomingBirthDate.equals(agingDate) || upcomingBirthDate.isBefore(agingDate)){
            double statDecayChance = agingModel.getStatDecayChance()*100;
            double randomStatDecayChance = random.nextInt(101-0)+0;
            if(randomStatDecayChance <= statDecayChance){
                playerModel.setShooting(playerModel.getShooting()-1);
                playerModel.setSaving(playerModel.getSaving()-1);
                playerModel.setChecking(playerModel.getChecking()-1);
                playerModel.setSkating(playerModel.getSkating()-1);
              cli.printOutput(playerModel.getPlayerName()+" Stat decreased by 1 point on his Birthday");
            }
        }
    }


    @Override
    public void replacePlayerWithFreeAgent(IPlayerModel playerModel, IFreeAgentModel replacementFreeAgent) {
        try {
            if (replacementFreeAgent == null || playerModel == null) {
                throw new NullPointerException("Argument null in replacePlayerWithFreeAgent");
            }
           cli.printOutput("Replacing Player " + playerModel.getPlayerName() + " With Free Agent " + replacementFreeAgent.getPlayerName());
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
            playerModel.setBirthDay(freeAgentModel.getBirthDay());
            playerModel.setBirthMonth(freeAgentModel.getBirthMonth());
            playerModel.setBirthYear(freeAgentModel.getBirthYear());
        } catch (Exception e) {
          throw e;
        }
    }

    @Override
    public int checkPlayerRetirementPossibility(IPlayerModel playerModel) {
        if(playerModel == null){
            throw new NullPointerException("Argument null in checkPlayerRetirementPossibility method");
        }
        int playerAge = playerModel.getAge();
        int averageRetirementAge = agingModel.getAverageRetirementAge();
        int maximumAge = agingModel.getMaximumAge();
        int likelyHood = playerModel.getRetirementLikelyHood();
        if (playerAge >= maximumAge) {
            likelyHood = MAX_RETIRE_LIKELIHOOD;
        } else {
            int AgeDifference = averageRetirementAge - playerAge;
            if (AgeDifference >= 0) {
                likelyHood = random.nextInt(LOW_RETIRE_LIKELIHOOD);
            } else if (AgeDifference >= MIN_DIFFERENCE) {
                likelyHood = random.nextInt(AVERAGE_RETIRE_LIKELIHOOD - LOW_RETIRE_LIKELIHOOD) + LOW_RETIRE_LIKELIHOOD;
            } else if (AgeDifference >= MAX_DIFFERENCE) {
                likelyHood = random.nextInt(MEDIUM_RETIRE_LIKELIHOOD - AVERAGE_RETIRE_LIKELIHOOD) + AVERAGE_RETIRE_LIKELIHOOD;
            } else {
                likelyHood = random.nextInt(HIGH_RETIRE_LIKELIHOOD - MEDIUM_RETIRE_LIKELIHOOD) + MEDIUM_RETIRE_LIKELIHOOD;
            }
        }
        playerModel.setRetirementLikelyHood(likelyHood);
        return likelyHood;
    }


    @Override
    public float getShootingState(List<PlayerModel> playerModelList){
        if(playerModelList==null){
            logger.info("Argument not set properly in getShootingState()");
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
            logger.info("Argument not set properly in getCheckingState()");
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
            logger.info("Argument not set properly in getShootingState()");
            throw new NullPointerException();
        }
        float savingSate = 0;
        for (PlayerModel playerModel : playerModelList) {
            savingSate = savingSate + playerModel.getSaving();
        }
        return savingSate;
    }

}
