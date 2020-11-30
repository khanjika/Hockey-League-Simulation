package leagueobjectmodel;

import com.google.gson.annotations.Expose;

public class HeadCoachModel implements IHeadCoachModel {
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
    private int trainingPlayerPoints;

    public HeadCoachModel() {
    }

    public HeadCoachModel(String name, float skating, float shooting, float checking, float saving) {
        this.name = name;
        this.skating = skating;
        this.shooting = shooting;
        this.checking = checking;
        this.saving = saving;
    }

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

    @Override
    public int getTrainingPlayerPoints() {
        return trainingPlayerPoints;
    }

    @Override
    public void setTrainingPlayerPoints(int trainingPlayerPoints) {
        this.trainingPlayerPoints = trainingPlayerPoints;
    }
}
