package freeagent;

import players.PlayerModel;

public class FreeAgentValidator implements  IFreeAgentValidator{

    @Override
    public boolean validateFreeAgentObject(FreeAgentModel freeAgentModel) {
        if (isStringValid(freeAgentModel.getPlayerName()) && isStringValid(freeAgentModel.getPosition()) && freeAgentModel.isCaptain() != null) {
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
}
