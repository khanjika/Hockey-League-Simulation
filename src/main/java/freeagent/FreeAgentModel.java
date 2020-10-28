package freeagent;

import com.google.gson.annotations.Expose;
import players.PlayerPosition;

public class FreeAgentModel implements IFreeAgentModel{
    @Expose
    private  String playerName;
    @Expose
    private  String position;
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
}
