package leagueobjectmodel;

import cli.CliAbstractFactory;
import cli.ICli;

public class PlayerValidator implements IPlayerValidator {

    ICli cli = CliAbstractFactory.getInstance().getCli();

    public PlayerValidator() {
    }

    @Override
    public boolean validatePlayerObject(IPlayerModel playerModel) {
        if (isStringValid(playerModel.getPlayerName()) && isStringValid(playerModel.getPosition()) && playerModel.isCaptain() != null &&
                isStatValid(playerModel.getSaving()) && isStatValid(playerModel.getShooting()) &&
                isStatValid(playerModel.getSkating()) && isStatValid(playerModel.getChecking())) {
            if (validatePosition(playerModel.getPosition())) {
                return true;
            } else {
             cli.printOutput("Position for player " + playerModel.getPlayerName() + " is not correct");
                return false;
            }
        } else {
            cli.printOutput("Error:::" + playerModel.getPlayerName() + playerModel.getPosition() + playerModel.isCaptain() + playerModel.getAge() + playerModel.getSaving() + playerModel.getShooting() + playerModel.getChecking());
            cli.printOutput("Player Information can not be NULL or EMPTY");
            return false;
        }
    }

    private boolean validatePosition(String str) {

        String position = str.toLowerCase();
        return position.equals(PlayerPosition.GOALIE.toString()) || position.equals(PlayerPosition.FORWARD.toString()) || position.equals(PlayerPosition.DEFENSE.toString());
    }

        private boolean isStringValid(String str) {
            if(str==null || str.isEmpty()){
                return false;
            }
            else
                return true;
        }

    private boolean isStatValid(float stat) {
        if(stat<0 ||stat>20){
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
