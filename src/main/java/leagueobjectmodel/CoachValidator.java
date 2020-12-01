package leagueobjectmodel;

public class CoachValidator implements ICoachValidator {

    @Override
    public boolean validateCoachObject(ICoachModel coachModel) {
        return isStringValid(coachModel.getName()) && isStatValid(coachModel.getSkating()) && isStatValid(coachModel.getShooting()) && isStatValid(coachModel.getSaving()) && isStatValid(coachModel.getChecking());
    }

    private boolean isStringValid(String str) {
        if(str==null || str.isEmpty()){
            return false;
        }
        else
            return true;
    }

    private boolean isStatValid(float stat) {
        return stat <= 1 && stat >= 0;
    }
}
