package leagueobjectmodel;

public class FreeAgentValidator implements IFreeAgentValidator {

    @Override
    public boolean validateFreeAgentObject(FreeAgentModel freeAgentModel) {
        return isStringValid(freeAgentModel.getPlayerName()) && isStringValid(freeAgentModel.getPosition())
                && isStatValid(freeAgentModel.getSkating()) && isStatValid(freeAgentModel.getShooting()) && isStatValid(freeAgentModel.getChecking()) && isStatValid(freeAgentModel.getSaving());
    }

    private boolean isStringValid(String str) {
        return str != null && !str.isEmpty();
    }

    private boolean isStatValid(float stat) {
        return !(stat < 0) || !(stat > 20);
    }

    private boolean isAgeValid(int age) {
        return age > 0;
    }
}
