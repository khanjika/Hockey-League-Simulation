package teams;

public class HeadCoachValidator implements IHeadCoachValidator {

    @Override
    public boolean validateHeadCoachObject(HeadCoachModel headCoachModel) {
        if(isStringValid(headCoachModel.getName()) && isStatValid(headCoachModel.getSkating()) && isStatValid(headCoachModel.getShooting()) &&
        isStatValid(headCoachModel.getSaving()) && isStatValid(headCoachModel.getChecking())){
            return true;
        }else {
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
            return true;
        }
        return false;
    }

}
