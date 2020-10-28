package players;

import com.fasterxml.jackson.annotation.JsonProperty;
import conference.ConferenceModel;
import divison.DivisonModel;
import freeagent.FreeAgentModel;
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
    private String playerName;
    private String position;
    @JsonProperty(required = true)
    private Boolean captain;
    private Boolean isPlayerRetired;
    private int age;
    private int days;
    private float skating;
    private float shooting;
    private float checking;
    private float saving;
    private float playerStrength;
    private boolean isPlayerInjured;
    private LocalDate injuredDate;
    private int injuryDays;
    private LocalDate recoveryDate;


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
    public void checkPlayerInjury(LeagueModel leagueModel, TeamsModel teamsModel, LocalDate date) {
        for(PlayerModel playerModel : teamsModel.getPlayers()){
            if(playerModel.isPlayerInjured){
                continue;
            }
            else {
                GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
                InjuriesModel injuriesModel =  gamePlayConfigModel.getInjuries();
                float randomInjuryChance = injuriesModel.getRandomInjuryChance();
                int injuryDaysLow = injuriesModel.getInjuryDaysLow();
                int injuryDaysHigh = injuriesModel.getInjuryDaysHigh();
                Random randomObj =new Random();
                float injuryChance= randomObj.nextFloat();
                int injuryDays = randomObj.nextInt(injuryDaysHigh - injuryDaysLow)+injuryDaysLow;
                for(ConferenceModel conferenceModel : leagueModel.getConferences()){
                    for(DivisonModel divisonModel : conferenceModel.getDivisions()){
                        for(TeamsModel teamsModel1 : divisonModel.getTeams()){
                            if(teamsModel1.getTeamName().equals(teamsModel.getTeamName())){
                                for(PlayerModel playerModel1: teamsModel1.getPlayers()){
                                    if(injuryChance > randomInjuryChance){
                                        playerModel1.setPlayerInjured(true);
                                        playerModel1.setInjuryDays(injuryDays);
                                        playerModel1.setInjuredDate(date);
                                        playerModel1.setRecoveryDate(date.plusDays(injuryDays));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void recoverPlayer(LeagueModel leagueModel, TeamsModel teamsModel, LocalDate date) {
        for(ConferenceModel conferenceModel : leagueModel.getConferences()){
            for(DivisonModel divisonModel : conferenceModel.getDivisions()){
                for(TeamsModel teamsModel1 : divisonModel.getTeams()){
                    if(teamsModel1.getTeamName().equals(teamsModel.getTeamName())){
                        for(PlayerModel playerModel : teamsModel1.getPlayers()){
                            if(playerModel.getRecoveryDate().equals(date)){
                                playerModel.setPlayerInjured(false);
                                playerModel.setInjuryDays(0);
                                playerModel.setInjuredDate(null);
                                playerModel.setRecoveryDate(null);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void aging(LeagueModel leagueModel, LocalDate date) {
        for(ConferenceModel conferenceModel : leagueModel.getConferences()){
            for(DivisonModel divisonModel : conferenceModel.getDivisions()){
                for(TeamsModel teamsModel : divisonModel.getTeams()){
                    for(PlayerModel playerModel : teamsModel.getPlayers()){
                        int days = playerModel.getDays();
                        int playerAge = playerModel.getAge();
                        if(playerModel.getDays() >= 365){
                            playerModel.setAge(playerAge+1);
                            playerModel.setDays(0);
                        }
                        else {
                            playerModel.setDays(days+1);
                        }
                        int RetirementLikelyHood = checkPlayerRetirementPossibility(leagueModel,playerModel);
                        if(RetirementLikelyHood>=85){
                            playerModel.setPlayerRetired(true);
                        }
                        if(playerModel.getPlayerRetired()){
                            String playerPosition = playerModel.getPosition();
                            FreeAgentModel freeAgent = getReplacementFreeAgent(leagueModel,playerPosition);
                            playerModel.setPlayerName(freeAgent.getPlayerName());
                            playerModel.setPosition(freeAgent.getPosition());
                            playerModel.setAge(freeAgent.getAge());
                            playerModel.setSkating(freeAgent.getSkating());
                            playerModel.setShooting(freeAgent.getShooting());
                            playerModel.setChecking(freeAgent.getChecking());
                            playerModel.setSaving(freeAgent.getSaving());
                        }
                    }
                }
            }
        }
    }

    private int checkPlayerRetirementPossibility(LeagueModel leagueModel,PlayerModel playerModel) {
        GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        AgingModel agingModel = gamePlayConfigModel.getAging();
        int playerAge = playerModel.getAge();
        int averageRetirementAge = agingModel.getAverageRetirementAge();
        int maximumAge = agingModel.getMaximumAge();
        int likelyHood =0;
        Random randomObj = new Random();
        if(playerAge >= maximumAge){
            likelyHood=100;
        }
        else{
            int AgeDifference = averageRetirementAge -  playerAge;
            if(AgeDifference >= 0 ){
                likelyHood = randomObj.nextInt(50);
            }
            else {
                likelyHood = randomObj.nextInt(100-50)+50;
            }
        }
        return likelyHood;
    }

    private FreeAgentModel getReplacementFreeAgent(LeagueModel leagueModel, String playerPosition) {
        List<FreeAgentModel> freeAgents = new ArrayList<FreeAgentModel>();
        List<FreeAgentModel> matchedFreeAgents = new ArrayList<FreeAgentModel>();
        freeAgents = leagueModel.getFreeAgents();
        for(FreeAgentModel freeAgent : freeAgents){
            if(freeAgent.getPosition().equals(playerPosition)){
                matchedFreeAgents.add(freeAgent);
            }
        }
        FreeAgentModel ReplacementfreeAgent = Collections.max(matchedFreeAgents, Comparator.comparing(f->f.getFreeAgentStrength()));
        freeAgents.remove(ReplacementfreeAgent);
        leagueModel.setFreeAgents(freeAgents);
        return ReplacementfreeAgent;
    }

    @Override
    public ArrayList<PlayerModel> getPlayerInformation(int teamId) {
        return iPlayerPersistent.getPlayerInformation(teamId);
    }
}
