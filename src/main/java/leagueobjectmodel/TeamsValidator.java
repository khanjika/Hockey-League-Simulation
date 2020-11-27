package leagueobjectmodel;

import database.serializeobject.IFileValidator;
import database.serializeobject.SerializeObjectAbstractFactory;

import java.util.Objects;

public class TeamsValidator implements ITeamsValidator {
    private static final IPlayerValidator playerValidator = new PlayerValidator();
    private static final IHeadCoachValidator headCoachValidator = new HeadCoachValidator();
    private static final IFileValidator fileValidator= SerializeObjectAbstractFactory.getInstance().getFileValidator();
    private boolean isPlayerCaptain = false;
    private int defense = 0;
    private int goalie = 0;
    private int forward = 0;

    @Override
    public boolean validateTeamObject(TeamsModel teamsModel) {
        defense = 0;
        goalie = 0;
        forward = 0;
        if (Objects.nonNull(teamsModel.getGeneralManager()) && isStringValid(teamsModel.getTeamName())) {
            for (PlayerModel playerModel : teamsModel.getPlayers()) {
                if(playerModel.getPosition().equals(PlayerPosition.DEFENSE.toString())){
                    defense++;
                }
                else if(playerModel.getPosition().equals(PlayerPosition.FORWARD.toString())){
                    forward++;
                }
                else{
                    goalie++;
                }
                if (playerValidator.validatePlayerObject(playerModel)) {
                    if (playerModel.isCaptain() && isPlayerCaptain == true) {
                        isPlayerCaptain = false;
                        System.out.println("There can be only one captain in the team ==>" + teamsModel.getTeamName());
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
            if (forward == 16 && defense == 10 && goalie == 4) {
                return true;
            } else {
                System.out.println(forward);
                System.out.println(defense);
                System.out.println(goalie);
                System.out.println("Player Position Count is not valid in team --> "+teamsModel.getTeamName());
                return false;
            }
        } else {
            System.out.println("There seems to be no captain in team -->" +teamsModel.getTeamName());
            return false;
        }
    }
    @Override
    public boolean isTeamAlreadyExist(String teamName){
        return fileValidator.isFileExist(teamName);
    }

    private boolean isStringValid(String str) {
        return str != null && str != "";
    }
}
