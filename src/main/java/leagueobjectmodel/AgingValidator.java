package leagueobjectmodel;

public class AgingValidator implements IAgingValidator {

    @Override
    public boolean validateAging(AgingModel agingModel) {
        return isNotNull(agingModel.getAverageRetirementAge()) && isNotNull(agingModel.getMaximumAge());
    }

    public boolean isNotNull(int value) {
        if(value==0){
            return false;
        }
        else
            return true;
    }
}
