package coach;

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
    private ICoachPersistent iCoachPersistent;

    public CoachModel(){
        iCoachPersistent = new CoachPersistent();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    @Override
    public void storeCoachInformation(CoachModel coachModel, int leagueId) {
        iCoachPersistent.storeCoachesInformation(leagueId,coachModel.getName(),coachModel.getSkating(),getShooting(),getChecking(),getSaving());
    }
}