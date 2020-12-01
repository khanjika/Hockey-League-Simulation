package leagueobjectmodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = InjuriesModel.class)
public interface IInjuriesModel {
    float getRandomInjuryChance();

    void setRandomInjuryChance(float randomInjuryChance);

    int getInjuryDaysLow();

    void setInjuryDaysLow(int injuryDaysLow);

    int getInjuryDaysHigh();

    void setInjuryDaysHigh(int injuryDaysHigh);
}
