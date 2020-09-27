package teams;

import players.IPlayerValidator;
import players.PlayerModel;
import players.PlayerValidator;

public class TeamsValidator implements ITeamsValidator {
    private static IPlayerValidator playerValidator = new PlayerValidator();
    private boolean isPlayerCaptain = false;
    private int playerCount =0;

    @Override
    public boolean validateTeamObject(TeamsModel teamsModel) {
            playerCount=0;
        if (isStringValid(teamsModel.getGeneralManager()) && isStringValid(teamsModel.getHeadCoach()) && isStringValid(teamsModel.getTeamName())) {
            for (PlayerModel playerModel : teamsModel.getPlayers()) {
               playerCount++;
//                System.out.println("Value of variable " +isPlayerCaptain);
//                System.out.println("Value of object "+ playerModel.isCaptain());
//                System.out.println("Address of Player Object "+playerModel);
                if (playerValidator.validatePlayerObject(playerModel)) {

                    //checking if there are multiple  captain or not
                    if (playerModel.isCaptain() && isPlayerCaptain == true) {
                        isPlayerCaptain=false;
                        System.out.println("There can be only one caption in the team ==>" + teamsModel.getTeamName());
                        return false;
                    }

                    //checking if the current player is captain or not
                    else if (playerModel.isCaptain()) {
                      isPlayerCaptain=true;
                    } else {
                        continue;
                    }

                } else {
                    System.out.println("Encountered Problem while validating Players in team==>"+teamsModel.getTeamName() );
                    return false;
                }
            }
        } else {
            return false;
        }
        if (isPlayerCaptain) {
            isPlayerCaptain=false;
            if(playerCount==20) {
                return true;
            }
            else {
                System.out.println("Player Count is less than 20. Current count is==>"+playerCount);
                return false;
            }
        } else {

            System.out.println("There seems to be no captain");
            return false;
        }

    }

    private boolean isStringValid(String str) {
        if (str == null || str == "") {
            return false;
        }
        return true;
    }
}
