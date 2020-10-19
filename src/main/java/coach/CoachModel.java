package coach;

public class CoachModel implements ICoachModel {
    private String name;
    private Float skating;
    private Float shooting;
    private Float checking;
    private Float saving;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSkating() {
        return skating;
    }

    public void setSkating(Float skating) {
        this.skating = skating;
    }

    public Float getShooting() {
        return shooting;
    }

    public void setShooting(Float shooting) {
        this.shooting = shooting;
    }

    public Float getChecking() {
        return checking;
    }

    public void setChecking(Float checking) {
        this.checking = checking;
    }

    public Float getSaving() {
        return saving;
    }

    public void setSaving(Float saving) {
        this.saving = saving;
    }
}