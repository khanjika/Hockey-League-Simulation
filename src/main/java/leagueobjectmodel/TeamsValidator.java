package leagueobjectmodel;

import java.util.Objects;

public class TeamsValidator implements ITeamsValidator {
    private static final IPlayerValidator playerValidator = new PlayerValidator();
    private static final IHeadCoachValidator headCoachValidator = new HeadCoachValidator();
    private boolean isPlayerCaptain = false;
    private int playerCount = 0;

    @Override
    public boolean validateTeamObject(TeamsModel teamsModel) {
        playerCount = 0;
        if (Objects.nonNull(teamsModel.getGeneralManager()) && isStringValid(teamsModel.getTeamName())) {
            for (PlayerModel playerModel : teamsModel.getPlayers()) {
                playerCount++;
                if (playerValidator.validatePlayerObject(playerModel)) {
                    if (playerModel.isCaptain() && isPlayerCaptain == true) {
                        isPlayerCaptain = false;
                        System.out.println("There can be only one caption in the team ==>" + teamsModel.getTeamName());
                        return false;
                    } else if (playerModel.isCaptain()) {
                        isPlayerCaptain = true;
                    } else {
                        continue;
                    }
                    if (headCoachValidator.validateHeadCoachObject(teamsModel.getHeadCoach())) {
                        continue;
                    }


                } else {
                    System.out.println("Encountered Problem while validating Players in team ==> " + teamsModel.getTeamName());
                    return false;
                }
            }
        } else {
            return false;
        }
        if (isPlayerCaptain) {
            isPlayerCaptain = false;
            if (playerCount == 30) {
                return true;
            } else {
                System.out.println("Player Count is not equal to 20. Current count is==>" + playerCount);
                return true;
            }
        } else {

            System.out.println("There seems to be no captain");
            return false;
        }
    }

    private boolean isStringValid(String str) {
        return str != null && str != "";
    }
}
