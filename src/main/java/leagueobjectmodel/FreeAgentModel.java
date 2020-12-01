package leagueobjectmodel;

import cli.CliAbstractFactory;
import cli.ICli;
import com.google.gson.annotations.Expose;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.*;

public class FreeAgentModel implements IFreeAgentModel {
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
    private int age;
    @Expose
    private float skating;
    @Expose
    private float shooting;
    @Expose
    private float checking;
    @Expose
    private float saving;
    private float freeAgentStrength;
    private int days;
    private boolean isRetired;
    private int retirementLikelyHood;
    private IAgingModel agingModel;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private Random random = LeagueObjectModelAbstractFactory.getInstance().createRandom();
    final static Logger logger = Logger.getLogger(FreeAgentModel.class);
    ICli cli = CliAbstractFactory.getInstance().getCli();
    @Override
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
    public float getFreeAgentStrength() {
        return freeAgentStrength;
    }

    @Override
    public void setFreeAgentStrength(float freeAgentStrength) {
        this.freeAgentStrength = freeAgentStrength;
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
    public boolean isRetired() {
        return isRetired;
    }

    @Override
    public void setRetired(boolean retired) {
        isRetired = retired;
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
    public void calculateFreeAgentStrength(IFreeAgentModel freeAgentModel) {
        if (freeAgentModel == null) {
            logger.error("Null pinter exception in the calculateFreeAgentStrength method");
            throw new NullPointerException();
        } else {
            float strength = 0;
            if (freeAgentModel.getPosition().equals(PlayerPosition.FORWARD.toString())) {
                strength = freeAgentModel.getSkating() + freeAgentModel.getShooting() + (freeAgentModel.getChecking() / 2);
            } else if (freeAgentModel.getPosition().equals(PlayerPosition.DEFENSE.toString())) {
                strength = freeAgentModel.getSkating() + freeAgentModel.getChecking() + (freeAgentModel.getShooting() / 2);
            } else if (freeAgentModel.getPosition().equals(PlayerPosition.GOALIE.toString())) {
                strength = freeAgentModel.getSkating() + freeAgentModel.getShooting();
            }
            freeAgentModel.setFreeAgentStrength(strength);

        }

    }

    public void aging(IFreeAgentModel freeAgentModel, LocalDate date, int daysToAge) {
        if( freeAgentModel == null || date ==null || daysToAge == 0){
            throw new NullPointerException("Error in Aging method of free Agent");
        }
        int playerAge = date.getYear() - freeAgentModel.getBirthYear();
        LocalDate upcomingBirthDate = LocalDate.of(date.getYear(), freeAgentModel.getBirthMonth(), freeAgentModel.getBirthDay());
        LocalDate agingDate = date.plusDays(daysToAge);
        if(this.age == 0) {
            agingDate = date;
            this.setAge(agingDate.getYear() - freeAgentModel.getBirthYear());
        }
        freeAgentModel.setAge(playerAge);
        if (upcomingBirthDate.isBefore(agingDate)) {
            freeAgentModel.setAge(agingDate.getYear() - freeAgentModel.getBirthYear() + 1);
        } else {
            freeAgentModel.setAge(agingDate.getYear() - freeAgentModel.getBirthYear());
        }
        int retirementLikelyHood = checkRetirement(freeAgentModel);
        if (retirementLikelyHood >= RETIRE_LIKELIHOOD_THRESHOLD) {
            freeAgentModel.setRetired(true);
        }
    }


    @Override
    public int checkRetirement(IFreeAgentModel freeAgentModel) {
        int likelyHood;
        if (freeAgentModel == null) {
            logger.error("Null pinter exception in the calculateFreeAgentStrength method");
            throw new NullPointerException();
        } else {
            int freeAgentAge = freeAgentModel.getAge();
            int averageRetirementAge = agingModel.getAverageRetirementAge();
            int maximumAge = agingModel.getMaximumAge();
            likelyHood = freeAgentModel.getRetirementLikelyHood();
            if (freeAgentAge >= maximumAge) {
                likelyHood = MAX_RETIRE_LIKELIHOOD;
            } else {
                int AgeDifference = averageRetirementAge - freeAgentAge;
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
            freeAgentModel.setRetirementLikelyHood(likelyHood);
        }
        return likelyHood;
    }

    @Override
    public IFreeAgentModel getReplacementFreeAgent(List<IFreeAgentModel> freeAgents, String playerPosition) {
        if(freeAgents==null || playerPosition.isEmpty()){
            logger.error("Method argument is not intialized properly");
            throw new NullPointerException();
        }
        List<IFreeAgentModel> matchedFreeAgents = new ArrayList<>();
        for (IFreeAgentModel freeAgent : freeAgents) {
            if (freeAgent.getPosition().equals(playerPosition)) {
                matchedFreeAgents.add(freeAgent);
                calculateFreeAgentStrength(freeAgent);
            }
        }
        if (matchedFreeAgents.size() == 0) {
            cli.printOutput("NO MATCH FOUND FOR THE PLAYER WITH POSITION " + playerPosition);
            System.exit(0);
        }
        IFreeAgentModel replacementFreeAgent = Collections.max(matchedFreeAgents, Comparator.comparing(f -> f.getFreeAgentStrength()));
        freeAgents.remove(replacementFreeAgent);
        return replacementFreeAgent;
    }

    @Override
    public List<IFreeAgentModel> sortFreeAgentDescending(List<IFreeAgentModel> freeAgents) {
        if(freeAgents==null){
            logger.error("Method argument is not intialized properly in sortFreeAgentDescending()");
            throw new NullPointerException();
        }
        freeAgents.sort(Comparator.comparing(IFreeAgentModel::getFreeAgentStrength).reversed());
        return freeAgents;
    }


}
