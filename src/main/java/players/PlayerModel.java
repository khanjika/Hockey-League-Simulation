package players;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import jdk.nashorn.internal.runtime.ECMAException;
import teams.TeamPojo;
import java.util.ArrayList;
import conference.ConferenceModel;
import divison.DivisonModel;
import freeagent.FreeAgentModel;
import freeagent.IFreeAgentModel;
import gameplayconfig.AgingModel;
import gameplayconfig.GamePlayConfigModel;
import gameplayconfig.InjuriesModel;
import league.LeagueModel;
import teams.TeamsModel;
import java.time.LocalDate;
import java.util.*;


public class PlayerModel implements IPlayerModel {

    private IPlayerPersistent iPlayerPersistent;

    public PlayerModel() {
        iPlayerPersistent = new PlayerPersistent();
    }
    @Expose
    private String playerName;
    @Expose
    private String position;
    @Expose
    @JsonProperty(required = true)
    private Boolean captain;
    @Expose
    private int age;
    @Expose
    private Boolean isPlayerRetired;
    private int days;
    private float skating;
    @Expose
    private float shooting;
    @Expose
    private float checking;
    @Expose
    private float saving;
    private float playerStrength;
    private boolean isPlayerInjured;
    private LocalDate injuredDate;
    private int injuryDays;
    private LocalDate recoveryDate;
    private AgingModel agingModel;
    private InjuriesModel injuriesModel;
    private int retirementLikelyHood;
    private IFreeAgentModel freeAgentModel;
    private List<FreeAgentModel> freeAgentsList;


    public PlayerModel(String playerName, String position, Boolean captain, int age, float skating, float shooting, float checking, float saving) {
        this.playerName = playerName;
        this.position = position;
        this.captain = captain;
        this.age = age;
        this.skating = skating;
        this.shooting = shooting;
        this.checking = checking;
        this.saving = saving;
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

    public Boolean isCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public float getSkating() { return skating; }

    public void setSkating(float skating) { this.skating = skating; }

    public float getShooting() { return shooting;}

    public void setShooting(float shooting) { this.shooting = shooting; }

    public float getChecking() { return checking; }

    public void setChecking(float checking) { this.checking = checking; }

    public float getSaving() { return saving; }

    public void setSaving(float saving) { this.saving = saving; }

    public float getPlayerStrength() { return playerStrength; }

    //public void setPlayerStrength(float playerStrength) throws Exception { this.playerStrength = playerStrength; }

    public boolean isPlayerInjured() {
        return isPlayerInjured;
    }

    public void setPlayerInjured(boolean playerInjured) {
        isPlayerInjured = playerInjured;
    }

    public LocalDate getInjuredDate() {
        return injuredDate;
    }

    public void setInjuredDate(LocalDate injuredDate) {
        this.injuredDate = injuredDate;
    }

    public int getInjuryDays() {
        return injuryDays;
    }

    public void setInjuryDays(int injuryDays) {
        this.injuryDays = injuryDays;
    }

    public LocalDate getRecoveryDate() {
        return recoveryDate;
    }

    public void setRecoveryDate(LocalDate recoveryDate) {
        this.recoveryDate = recoveryDate;
    }

    public void storePlayerInformation(PlayerModel playerModel, int teamId) {
        iPlayerPersistent.addPlayerInformation(playerModel.getPlayerName(), playerModel.getPosition(), playerModel.isCaptain(), teamId);
    }

    public Boolean getPlayerRetired() {
        return isPlayerRetired;
    }

    public void setPlayerRetired(Boolean playerRetired) {
        isPlayerRetired = playerRetired;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
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

    public List<FreeAgentModel> getFreeAgentsList() {
        return freeAgentsList;
    }

    public void setFreeAgentsList(List<FreeAgentModel> freeAgentsList) {
        this.freeAgentsList = freeAgentsList;
    }

    public InjuriesModel getInjuriesModel() {
        return injuriesModel;
    }

    public void setInjuriesModel(InjuriesModel injuriesModel) {
        this.injuriesModel = injuriesModel;
    }

    @Override
    public void calculatePlayerStrength(PlayerModel playerModel) {
        if(playerModel.getPosition().equals(PlayerPosition.FORWARD.toString())){
            playerModel.playerStrength = playerModel.getSkating()+ playerModel.getShooting() + (playerModel.getChecking()/2);
        }
        else if(playerModel.getPosition().equals(PlayerPosition.DEFENSE.toString())){
            playerModel.playerStrength = playerModel.getSkating() + playerModel.getChecking() + (playerModel.getShooting()/2);
        }
        else if(playerModel.getPosition().equals(PlayerPosition.GOALIE.toString())){
            playerModel.playerStrength = playerModel.getSkating() + playerModel.getShooting();
        }
    }

    @Override
    public void checkPlayerInjury(PlayerModel playerModel, LocalDate date) {
            if(playerModel.isPlayerInjured){
                return;
            }
            else {
                float randomInjuryChance = injuriesModel.getRandomInjuryChance();
                int injuryDaysLow = injuriesModel.getInjuryDaysLow();
                int injuryDaysHigh = injuriesModel.getInjuryDaysHigh();
                Random randomObj = new Random();
                float injuryChance= randomObj.nextFloat();
                int injuryDays = randomObj.nextInt(injuryDaysHigh - injuryDaysLow)+injuryDaysLow;
                if(injuryChance > randomInjuryChance){
                    playerModel.setPlayerInjured(true);
                    playerModel.setInjuryDays(injuryDays);
                    playerModel.setInjuredDate(date);
                    playerModel.setRecoveryDate(date.plusDays(injuryDays));
                }
            }
    }

    @Override
    public void recoverPlayer(PlayerModel playerModel, LocalDate date) {
        if(playerModel.getRecoveryDate().equals(date)){
            playerModel.setPlayerInjured(false);
            playerModel.setInjuryDays(0);
            playerModel.setInjuredDate(null);
            playerModel.setRecoveryDate(null);
        }
    }

    @Override
    public void aging(PlayerModel playerModel, int daysToAge) {
        int days = playerModel.getDays();
        int playerAge = playerModel.getAge();
        if(days + daysToAge >= 365){
            playerModel.setAge(playerAge+1);
            playerModel.setDays(0);
        }
        else {
            playerModel.setDays(days+daysToAge);
        }
        int retirementLikelyHood = checkPlayerRetirementPossibility(playerModel);
        if(retirementLikelyHood>=90){
            playerModel.setPlayerRetired(true);
        }
        if(playerModel.getPlayerRetired()){
            String playerPosition = playerModel.getPosition();
            List<FreeAgentModel> availableFreeAgents = playerModel.getFreeAgentsList();
            freeAgentModel =new FreeAgentModel();
            FreeAgentModel replacementFreeAgent = freeAgentModel.getReplacementFreeAgent(availableFreeAgents,playerPosition);
            playerModel.setPlayerName(replacementFreeAgent.getPlayerName());
            playerModel.setPosition(replacementFreeAgent.getPosition());
            playerModel.setAge(replacementFreeAgent.getAge());
            playerModel.setSkating(replacementFreeAgent.getSkating());
            playerModel.setShooting(replacementFreeAgent.getShooting());
            playerModel.setChecking(replacementFreeAgent.getChecking());
            playerModel.setSaving(replacementFreeAgent.getSaving());
        }
    }

    private int checkPlayerRetirementPossibility(PlayerModel playerModel) {
        int playerAge = playerModel.getAge();
        int averageRetirementAge = agingModel.getAverageRetirementAge();
        int maximumAge = agingModel.getMaximumAge();
        int likelyHood = playerModel.getRetirementLikelyHood();
        Random randomObj = new Random();
        if(playerAge >= maximumAge){
            likelyHood=100;
        }
        else{
            int AgeDifference = averageRetirementAge -  playerAge;
            if(AgeDifference >= 0 ){
                likelyHood = randomObj.nextInt(50-likelyHood)+likelyHood;
            }
            else {
                likelyHood = randomObj.nextInt(100-likelyHood)+likelyHood;
            }
        }
        playerModel.setRetirementLikelyHood(likelyHood);
        return likelyHood;
    }

    @Override
    public ArrayList<PlayerModel> getPlayerInformation(int teamId) {
        return iPlayerPersistent.getPlayerInformation(teamId);
    }
}
