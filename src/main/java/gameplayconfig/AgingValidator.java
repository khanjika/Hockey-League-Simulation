package gameplayconfig;

public class AgingValidator implements IAgingValidator{

    @Override
    public boolean validateAging(AgingModel agingModel) {
        if(isNotNull(agingModel.getAverageRetirementAge()) && isNotNull(agingModel.getMaximumAge())){
            return true;
        }
        else {
            return false;
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
