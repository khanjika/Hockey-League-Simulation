package coach;

public class CoachValidator implements ICoachValidator{

    @Override
    public boolean validateCoachObject(CoachModel coachModel) {
        if (isStringValid(coachModel.getName()) && isStatValid(coachModel.getSkating()) && isStatValid(coachModel.getShooting()) && isStatValid(coachModel.getSaving()) && isStatValid(coachModel.getChecking())) {
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isStringValid(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean isStatValid(float stat){
        if(stat < 1 && stat > 0){
            return false;
        }
        return true;
    }
}
