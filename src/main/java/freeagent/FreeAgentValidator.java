package freeagent;

public class FreeAgentValidator implements  IFreeAgentValidator{

    @Override
    public boolean validateFreeAgentObject(FreeAgentModel freeAgentModel) {
        if (isStringValid(freeAgentModel.getPlayerName()) && isStringValid(freeAgentModel.getPosition()) && isAgeValid(freeAgentModel.getAge())
                && isStatValid(freeAgentModel.getSkating()) && isStatValid(freeAgentModel.getShooting()) && isStatValid(freeAgentModel.getChecking()) && isStatValid(freeAgentModel.getSaving())) {
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
        if(stat < 1 && stat > 20){
            return false;
        }
        return true;
    }

    private boolean isAgeValid(int age){
        if(age <= 0){
            return false;
        }
        return true;
    }
}
