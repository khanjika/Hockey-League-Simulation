package leagueobjectmodel;

public class HeadCoachValidator implements IHeadCoachValidator {

    @Override
    public boolean validateHeadCoachObject(HeadCoachModel headCoachModel) {
        return isStringValid(headCoachModel.getName()) && isStatValid(headCoachModel.getSkating()) && isStatValid(headCoachModel.getShooting()) &&
                isStatValid(headCoachModel.getSaving()) && isStatValid(headCoachModel.getChecking());
    }

    private boolean isStringValid(String str) {

        if(str==null || str.isEmpty()){
            return false;
        }
        else
            return true;
    }

    private boolean isStatValid(float stat) {
        return stat < 1 && stat > 0;
    }

}
