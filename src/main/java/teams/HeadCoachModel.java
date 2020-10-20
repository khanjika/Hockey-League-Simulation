package teams;

public class HeadCoachModel implements IHeadCoachModel{
    private String name;
    private float skating;
    private float shooting;
    private float checking;
    private float saving;

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
}
