package leagueobjectmodel;

import com.google.gson.annotations.Expose;

import java.time.LocalDate;
import java.util.*;

public class FreeAgentModel implements IFreeAgentModel {
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
    private AgingModel agingModel;
    private int birthDay;
    private int birthMonth;
    private int birthYear;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSkating() {
        return skating;
    }

    public void setSkating(float skating) {
        this.skating = skating;
    }

    public float getShooting() {
        return shooting;
    }

    public void setShooting(float shooting) {
        this.shooting = shooting;
    }

    public float getChecking() {
        return checking;
    }

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
    public AgingModel getAgingModel() {
        return agingModel;
    }

    @Override
    public void setAgingModel(AgingModel agingModel) {
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
    public void calculateFreeAgentStrength(FreeAgentModel freeAgentModel) {
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

    @Override
    public void aging(FreeAgentModel freeAgentModel, int daysToAge) {
        LocalDate birthday = LocalDate.of(freeAgentModel.getBirthYear(),freeAgentModel.getBirthMonth(),freeAgentModel.getBirthDay());
        int days = freeAgentModel.getDays();
        int age = freeAgentModel.getAge();
        if (days + daysToAge >= 365) {
            freeAgentModel.setDays(0);
            freeAgentModel.setAge(age + 1);
        } else {
            freeAgentModel.setDays(days + daysToAge);
        }
        int retirementLikelyHood = checkRetirement(freeAgentModel);
        if (retirementLikelyHood >= 90) {
            freeAgentModel.setRetired(true);
        }
    }


    @Override
    public int checkRetirement(FreeAgentModel freeAgentModel) {
        int freeAgentAge = freeAgentModel.getAge();
        int averageRetirementAge = agingModel.getAverageRetirementAge();
        int maximumAge = agingModel.getMaximumAge();
        int likelyHood = freeAgentModel.getRetirementLikelyHood();
        Random randomObj = new Random();
        if (freeAgentAge >= maximumAge) {
            likelyHood = 100;
        } else {
            int AgeDifference = averageRetirementAge - freeAgentAge;
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
        freeAgentModel.setRetirementLikelyHood(likelyHood);
        return likelyHood;
    }

    @Override
    public FreeAgentModel getReplacementFreeAgent(List<FreeAgentModel> freeAgents, String playerPosition) {
        List<FreeAgentModel> matchedfreeAgents = new ArrayList<>();
        if (freeAgents == null) {
            return null;
        }
        for (FreeAgentModel freeAgent : freeAgents) {
            if (freeAgent.getPosition().equals(playerPosition)) {
                matchedfreeAgents.add(freeAgent);
                calculateFreeAgentStrength(freeAgent);
            }
        }
        if (matchedfreeAgents.size() == 0) {
            System.out.println("NO MATCH FOUND FOR THE PLAYER WITH POSITION " + playerPosition);
            System.exit(0);
        }
        FreeAgentModel replacementFreeAgent = Collections.max(matchedfreeAgents, Comparator.comparing(f -> f.getFreeAgentStrength()));
        freeAgents.remove(replacementFreeAgent);
        return replacementFreeAgent;

    }


}
