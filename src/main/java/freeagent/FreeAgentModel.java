package freeagent;

import com.google.gson.annotations.Expose;

public class FreeAgentModel {

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

    public void storeFreeAgentInformation(FreeAgentModel freeAgentModel, int leagueId){
         iFreeAgentPersistent.addFreeAgentInformation(freeAgentModel.getPlayerName(),freeAgentModel.getPosition(),leagueId);
    }
}
