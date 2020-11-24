package leagueobjectmodel;

import com.google.gson.annotations.Expose;

public class CoachModel implements ICoachModel {
    @Expose
    private String name;
    @Expose
    private float skating;
    @Expose
    private float shooting;
    @Expose
    private float checking;
    @Expose
    private float saving;

    public CoachModel() { }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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

}



