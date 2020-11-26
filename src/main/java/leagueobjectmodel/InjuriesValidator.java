package leagueobjectmodel;

public class InjuriesValidator implements IInjuriesValidator {

    @Override
    public boolean validateInjuries(InjuriesModel injuriesModel) {
        return isNotNull(injuriesModel.getRandomInjuryChance()) && isNotNull(injuriesModel.getInjuryDaysLow()) && isNotNull(injuriesModel.getInjuryDaysHigh());
    }

    public boolean isNotNull(float value) {
        return value != 0;
    }

    public boolean isNotNull(int value) {
        return value != 0;
    }
}
