package simulateGame;

import league.LeagueModel;
import players.PlayerModel;
import teams.TeamsModel;

import java.util.List;

//ONE THING I NEED TO CHANGE IS RIGHT NOW LIST OF PLAYER CONTAINS ALL THE LIST OF FOR THE TEAM HOWEVER I ONLY NEED 3 PLAYER FOR DEFENSE AND
//SO ON...

//ALL THE METHOD OF CALCULATING SHOULLD HAVE SOME FORM OF PRE CONDITION
public class StartSimulation {

    private static TeamsModel teamOneObject;
    private static TeamsModel teamTwoObject;
    private static TeamsModel attackingTeam;
    private static TeamsModel defendingTeam;
    private int averageShotsOnGoal = 40;
    private static LeagueModel leagueModelObject;
    private List<PlayerModel> listOfGoalieOfTeamOne;
    private List<PlayerModel> listOfGoaliesOfTeamTwo;
    private List<PlayerModel> listOfForwardOfTeamOne;
    private List<PlayerModel> listOfForwardOfTeamTwo;
    private List<PlayerModel> listOfDefenseOfTeamOne;
    private List<PlayerModel> listOfDefenseOfTeamTwo;

    public void voidSetData(TeamsModel teamOne, TeamsModel teamTwo, LeagueModel leagueModel) {
        teamOneObject = teamOne;
        teamTwoObject = teamTwo;
        leagueModelObject = leagueModel;
    }


    public void separatePlayerByPosition() {
        for (PlayerModel playerModel : teamOneObject.getPlayers()) {

            if (playerModel.getPosition().equals("forward")) {
                listOfForwardOfTeamOne.add(playerModel);
            } else if (playerModel.getPosition().equals("goalie")) {
                listOfGoalieOfTeamOne.add(playerModel);
            } else {
                listOfDefenseOfTeamOne.add(playerModel);
            }
        }

        for (PlayerModel playerModel : teamTwoObject.getPlayers()) {

            if (playerModel.getPosition().equals("forward")) {
                listOfForwardOfTeamTwo.add(playerModel);
            } else if (playerModel.getPosition().equals("goalie")) {
                listOfGoaliesOfTeamTwo.add(playerModel);
            } else {
                listOfDefenseOfTeamTwo.add(playerModel);
            }
        }

    }


    public void setAverageShotsOnGoal() {
        float teamOneShootingState = 0;
        float teamTwoShootingState = 0;
        float teamOneSkatingState = 0;
        float teamTwoSkatingState = 0;
        for (PlayerModel playerModel : listOfDefenseOfTeamOne) {
            if (playerModel.getPosition().equals("defense")) {
                teamOneShootingState = playerModel.getShooting();
            }
            teamOneSkatingState = playerModel.getSkating();
        }
        for (PlayerModel playerModel : listOfDefenseOfTeamTwo) {
            if (playerModel.getPosition().equals("defense")) {
                teamTwoShootingState = playerModel.getShooting();
            }
            teamTwoSkatingState = playerModel.getSkating();
        }

        //change the average goal chance
        if (teamOneShootingState >= teamTwoShootingState) {

        }

    }

    public void initializeSlots() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Period started " + i);
            //first 18 minute will be played
            for (int j = 0; j < 36; j++) {
                System.out.println("Shift started " + j);
                if (j % 2 == 0) {
                    attackingTeam = teamOneObject;
                    defendingTeam = teamTwoObject;
                } else {
                    attackingTeam = teamTwoObject;
                    defendingTeam = teamOneObject;
                }
                //calling method every time
                performOperation();
            }
            //last 2 minute
            for (int x = 0; x < 4; x++) {

            }
        }
    }

    public void performOperation() {

        //here i need to make a change where i re initialize the list every time i calculate the shooting state. because team will change alternatively,
        float attackingTeamShootingState = getShootingState(listOfForwardOfTeamOne);
        float defendingTwoShootingState = getShootingState(listOfForwardOfTeamTwo);
        float attackingTeamCheckingState = getCheckingState(listOfDefenseOfTeamOne);
        float defendingTeamCheckingState = getCheckingState(listOfDefenseOfTeamTwo);
        float attackingTeamSavingState=getSavingState(listOfGoalieOfTeamOne);
        float defendingTeamSavingState=getSavingState(listOfGoaliesOfTeamTwo);
        if (attackingTeamShootingState >= defendingTwoShootingState) {
            //attacking team has made a shot
            if (defendingTeamCheckingState >= attackingTeamCheckingState) {
                //defending team has prevented the shot
                //penalty will be here
            } else {
                //now it is time for the goalie of the defending team to do all the work
                if(defendingTeamSavingState>=attackingTeamSavingState){
                    //shot is prevented by the defending team
                }
                else {
                    //goal!!!
                }
            }

        } else {
            //no shot from the attacking team.Ot is time for the defending team!!!!!!!
        }

    }


    public float getShootingState(List<PlayerModel> playerModelList) {
        float shootingState = 0;
        for (PlayerModel playerModel : playerModelList) {
            shootingState = shootingState + playerModel.getShooting();
        }
        return shootingState;
    }


    public float getCheckingState(List<PlayerModel> playerModelList) {
        float checkingState = 0;
        for (PlayerModel playerModel : playerModelList) {
            checkingState = checkingState + playerModel.getChecking();
        }
        return checkingState;
    }

    public float getSavingState(List<PlayerModel> playerModelList) {
        float savingSate = 0;
        for (PlayerModel playerModel : playerModelList) {
            savingSate = savingSate + playerModel.getSaving();
        }
        return savingSate;
    }
}
