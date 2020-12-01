package leagueobjectmodel;

public class PlayerValidator implements IPlayerValidator {


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
                System.out.println("Position for player " + playerModel.getPlayerName() + " is not correct");
                return false;
            }
        } else {
            System.out.println("Error:::" + playerModel.getPlayerName() + playerModel.getPosition() + playerModel.isCaptain() + playerModel.getAge() + playerModel.getSaving() + playerModel.getShooting() + playerModel.getChecking());
            System.out.println("Player Information can not be NULL or EMPTY");
            return false;
        }
    }

    private boolean validatePosition(String str) {

        String position = str.toLowerCase();
        return position.equals(PlayerPosition.GOALIE.toString()) || position.equals(PlayerPosition.FORWARD.toString()) || position.equals(PlayerPosition.DEFENSE.toString());
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
