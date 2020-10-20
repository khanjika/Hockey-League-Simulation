package gameplayconfig;

public class InjuriesValidator implements IInjuriesValidator{

    @Override
    public boolean validateInjuries(InjuriesModel injuriesModel) {
        if(isNotNull(injuriesModel.getRandomInjuryChance()) && isNotNull(injuriesModel.getInjuryDaysLow()) && isNotNull(injuriesModel.getInjuryDaysHigh())){
            return true;
        }else {
            return false;
        }
    }
    public boolean isNotNull(float value){
        if(value == 0){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isNotNull(int value){
        if(value == 0){
            return false;
        }
        else {
            return true;
        }
    }
}
