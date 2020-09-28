package freeagent;

import players.PlayerModel;

public class FreeAgentValidator implements  IFreeAgentValidator{



    @Override
    public boolean validateFreeAgentObject(FreeAgentModel freeAgentModel) {

        if (isStringValid(freeAgentModel.getPlayerName()) && isStringValid(freeAgentModel.getPosition()) && freeAgentModel.isCaptain() != null) {
            if(validatePosition(freeAgentModel.getPosition())){
                return true;
            }
            else {
                System.out.println("Position for player "+ freeAgentModel.getPlayerName() + " is not correct in Free Agent" );
                return false;
            }
        }
        else{
            return false;
        }

    }


    private boolean validatePosition(String str){

        String position= str.toLowerCase();
        if(position.equals("goalie") || position.equals("forward") || position.equals("defense")){
            return true;
        }
        else {
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
