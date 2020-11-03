package coach;

public class CoachValidator implements ICoachValidator {

    @Override
    public boolean validateCoachObject(CoachModel coachModel) {
        return isStringValid(coachModel.getName()) && isStatValid(coachModel.getSkating()) && isStatValid(coachModel.getShooting()) && isStatValid(coachModel.getSaving()) && isStatValid(coachModel.getChecking());
    }

    private boolean isStringValid(String str) {
        return str != null && !str.isEmpty();
    }

    private boolean isStatValid(float stat) {
        return stat <= 1 && stat >= 0;
    }
}
