package leagueobjectmodel;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = CoachModel.class)
public interface ICoachModel {
    String getName();

    void setName(String name);

    float getSkating();

    void setSkating(float skating);

    float getShooting();

    void setShooting(float shooting);

    float getChecking();

    void setChecking(float checking);

    float getSaving();

    void setSaving(float saving);
}
