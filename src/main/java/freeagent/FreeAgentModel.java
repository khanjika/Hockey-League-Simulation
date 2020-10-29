package freeagent;

import gameplayconfig.AgingModel;
import league.LeagueModel;
import players.IPlayerModel;
import players.PlayerModel;
import players.PlayerPosition;

import java.util.*;

public class FreeAgentModel implements IFreeAgentModel{

    private  String playerName;
    private  String position;
    private int age;
    private float skating;
    private float shooting;
    private float checking;
    private float saving;
    private float freeAgentStrength;
    private int days;
    private boolean isRetired;
    private int retirementLikelyHood;
    private AgingModel agingModel;


    private IFreeAgentPersistent iFreeAgentPersistent;

    public FreeAgentModel() {
        iFreeAgentPersistent=new FreeAgentPersistent();
    }

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

    public float getSaving() {
        return saving;
    }

    public void setSaving(float saving) {
        this.saving = saving;
    }

    public float getFreeAgentStrength() { return freeAgentStrength; }

    public void setFreeAgentStrength(float freeAgentStrength) { this.freeAgentStrength = freeAgentStrength; }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isRetired() {
        return isRetired;
    }

    public void setRetired(boolean retired) {
        isRetired = retired;
    }

    public int getRetirementLikelyHood() {
        return retirementLikelyHood;
    }

    public void setRetirementLikelyHood(int retirementLikelyHood) {
        this.retirementLikelyHood = retirementLikelyHood;
    }

    public AgingModel getAgingModel() {
        return agingModel;
    }

    public void setAgingModel(AgingModel agingModel) {
        this.agingModel = agingModel;
    }

    public void storeFreeAgentInformation(FreeAgentModel freeAgentModel, int leagueId){
         iFreeAgentPersistent.addFreeAgentInformation(freeAgentModel.getPlayerName(),freeAgentModel.getPosition(),leagueId);
    }

    @Override
    public void calculateFreeAgentStrength(FreeAgentModel freeAgentModel) {
        if(freeAgentModel.getPosition().equals(PlayerPosition.FORWARD.toString())){
            freeAgentModel.freeAgentStrength = freeAgentModel.getSkating() + freeAgentModel.getShooting() + (freeAgentModel.getChecking()/2);
        }
        else if(freeAgentModel.getPosition().equals(PlayerPosition.DEFENSE.toString())){
            freeAgentModel.freeAgentStrength = freeAgentModel.getSkating() + freeAgentModel.getChecking() + (freeAgentModel.getShooting()/2);
        }
        else if(freeAgentModel.getPosition().equals(PlayerPosition.GOALIE.toString())){
            freeAgentModel.freeAgentStrength = freeAgentModel.getSkating() + freeAgentModel.getShooting();
        }
    }

    @Override
    public void aging(FreeAgentModel freeAgentModel, int daysToAge) {
        int days = freeAgentModel.getDays();
        int age = freeAgentModel.getAge();
        if(days + daysToAge >=365){
            freeAgentModel.setDays(0);
            freeAgentModel.setAge(age+1);
        }
        else {
            freeAgentModel.setDays(days+daysToAge);
        }
        int retirementLikelyHood = checkRetirement(freeAgentModel);
        if(retirementLikelyHood >= 90 ){
            freeAgentModel.setRetired(true);
        }
    }

    private int checkRetirement(FreeAgentModel freeAgentModel) {
        int freeAgentAge = freeAgentModel.getAge();
        int averageRetirementAge = agingModel.getAverageRetirementAge();
        int maximumAge = agingModel.getMaximumAge();
        int likelyHood = freeAgentModel.getRetirementLikelyHood();
        Random randomObj = new Random();
        if(freeAgentAge >= maximumAge){
            likelyHood=100;
        }
        else{
            int AgeDifference = averageRetirementAge - freeAgentAge;
            if(AgeDifference >= 0 ){
                likelyHood = randomObj.nextInt(50-likelyHood)+likelyHood;
            }
            else {
                likelyHood = randomObj.nextInt(100-likelyHood)+likelyHood;
            }
        }
        freeAgentModel.setRetirementLikelyHood(likelyHood);
        return likelyHood;
    }

    @Override
    public FreeAgentModel getReplacementFreeAgent(List<FreeAgentModel> freeAgents,String playerPosition) {
        List<FreeAgentModel> matchedfreeAgents =  new ArrayList<>();
        for(FreeAgentModel freeAgent : freeAgents){
            if(freeAgent.getPosition().equals(playerPosition)) {
                matchedfreeAgents.add(freeAgent);
            }
        }
        FreeAgentModel ReplacementFreeAgent = Collections.max(matchedfreeAgents,Comparator.comparing(f->f.getFreeAgentStrength()));
        freeAgents.remove(ReplacementFreeAgent);
        return ReplacementFreeAgent;

    }

}
