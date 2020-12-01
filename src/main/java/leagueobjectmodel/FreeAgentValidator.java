package leagueobjectmodel;

public class FreeAgentValidator implements IFreeAgentValidator {

    @Override
    public boolean validateFreeAgentObject(IFreeAgentModel freeAgentModel) {
        return isStringValid(freeAgentModel.getPlayerName()) && isStringValid(freeAgentModel.getPosition())
                && isStatValid(freeAgentModel.getSkating()) && isStatValid(freeAgentModel.getShooting()) && isStatValid(freeAgentModel.getChecking()) && isStatValid(freeAgentModel.getSaving());
    }

    private boolean isStringValid(String str) {
        if(str==null || str.isEmpty()){
            return false;
        }
        else
            return true;
    }

    private boolean isStatValid(float stat) {

        if(stat<0 || stat>20){
            return false;
        }
        else {
            return true;
        }

    }

    private boolean isAgeValid(int age) {
        return age > 0;
    }
}
