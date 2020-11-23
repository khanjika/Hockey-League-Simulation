package simulateGame;

import league.LeagueModel;
import players.PlayerModel;
import teams.TeamsModel;

import java.util.ArrayList;
import java.util.List;

//ONE THING I NEED TO CHANGE IS RIGHT NOW LIST OF PLAYER CONTAINS ALL THE LIST OF FOR THE TEAM HOWEVER I ONLY NEED 3 PLAYER FOR DEFENSE AND
//SO ON...

//ALL THE METHOD OF CALCULATING SHOULD HAVE SOME FORM OF PRE CONDITION

//PERFORM PANLTY COUNT NEEDS TO BE ZERO
public class StartSimulation {

    private static TeamsModel teamOneObject;
    private static TeamsModel teamTwoObject;
    private static TeamsModel attackingTeam;
    private static TeamsModel defendingTeam;
    private int averageShotsOnGoal = 40;
    private static LeagueModel leagueModelObject;
    private List<PlayerModel> listOfGoalieOfTeamOne = new ArrayList<>();
    private List<PlayerModel> listOfGoaliesOfTeamTwo = new ArrayList<>();
    private List<PlayerModel> listOfForwardOfTeamOne = new ArrayList<>();
    private List<PlayerModel> listOfForwardOfTeamTwo = new ArrayList<>();
    private List<PlayerModel> listOfDefenseOfTeamOne = new ArrayList<>();
    private List<PlayerModel> listOfDefenseOfTeamTwo = new ArrayList<>();

    private List<PlayerModel> currentShiftGoalieOfTeamOne = new ArrayList<>();
    private List<PlayerModel> currentShiftGoalieOfTeamTwo = new ArrayList<>();
    private List<PlayerModel> currentShiftDefenseOfTeamOne = new ArrayList<>();
    private List<PlayerModel> currentShiftDefenseOfTeamTwo = new ArrayList<>();
    private List<PlayerModel> currentShiftForwardOfTeamOne = new ArrayList<>();
    private List<PlayerModel> currentShiftForwardOfTeamTwo = new ArrayList<>();

    int penaltyCounter = 0;


    public StartSimulation(TeamsModel teamOne, TeamsModel teamTwo, LeagueModel leagueModel) {
        teamOneObject = teamOne;
        teamTwoObject = teamTwo;
        leagueModelObject = leagueModel;
    }

    public void separatePlayerByPosition() {

        leagueModelObject.setPenaltyChance((float) 0.5);
        System.out.println("Inside separate player");
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

        setAverageShotsOnGoal();
        initializeSlots();
    }


    public void setAverageShotsOnGoal() {
        System.out.println("inside average shots on goal");
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

        fillCurrentShiftData();
        for (int i = 0; i < 3; i++) {

            if (i == 2) {
                replaceCurrentGoalie();
            }
            for (int j = 0; j < 40; j++) {
                //calling method every time
                //swapping the postion of both the team
                if (j == 37) {
                    replaceDefenseAndForward();
                }
                performOperation();
                if (penaltyCounter > 0) {
                    penaltyCounter--;
                }
                swapTurnOfTeam();

            }
        }
    }

    public void performOperation() {
        //here i need to make a change where i re initialize the list every time i calculate the shooting state. because team will change alternatively,
        float attackingTeamShootingState = getShootingState(currentShiftForwardOfTeamOne);
        float defendingTwoShootingState = getShootingState(currentShiftForwardOfTeamTwo);
        float attackingTeamCheckingState = getCheckingState(currentShiftDefenseOfTeamOne);
        float defendingTeamCheckingState = getCheckingState(currentShiftDefenseOfTeamTwo);
        float attackingTeamSavingState = getSavingState(currentShiftGoalieOfTeamOne);
        float defendingTeamSavingState = getSavingState(currentShiftGoalieOfTeamTwo);
        if (attackingTeamShootingState >= defendingTwoShootingState) {
            //attacking team has made a shot
            if (defendingTeamCheckingState >= attackingTeamCheckingState && penaltyCounter == 0) {
                //defending team has prevented the shot
                //penalty will be here
                double randomChanceNumber = Math.random();
                if (randomChanceNumber >= leagueModelObject.getPenaltyChance()) {
                    performPenalty(currentShiftDefenseOfTeamTwo);
                }
            } else {
                //now it is time for the goalie of the defending team to do all the work
                if (defendingTeamSavingState >= attackingTeamSavingState) {
                    //shot is prevented by the defending team by the goalie
                    int save = listOfGoaliesOfTeamTwo.get(0).getSaveForGoalie();
                    //  System.out.println("Save count is "+save);
                    listOfGoaliesOfTeamTwo.get(0).setSaveForGoalie(save + 1);
                    //System.out.println("Save count after updating is "+listOfGoaliesOfTeamTwo.get(0).getSaveForGoalie()+listOfGoalieOfTeamOne.get(0));
                } else {
                    //goal!!!
                    //here setting overall team count as well as a attributing a forward for that goal
                    attackingTeam.setGoalCount(attackingTeam.getGoalCount() + 1);
                    int currentGaolCount = listOfForwardOfTeamOne.get(0).getGoalScorerCount();
                    // System.out.println(currentGaolCount+" for the player "+listOfForwardOfTeamOne.get(0).getPlayerName());
                    listOfForwardOfTeamOne.get(0).setGoalScorerCount(currentGaolCount + 1);
                }
            }

        } else {
            //no shot from the attacking team. is time for the defending team!!!!!!!
            swapTurnOfTeam();
            performOperation();
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
            if (playerModel.getCurrentPenaltyCount() > 0) {
                playerModel.setCurrentPenaltyCount(playerModel.getCurrentPenaltyCount() - 1);
            } else {
                checkingState = checkingState + playerModel.getChecking();
            }
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


    public void swapTurnOfTeam() {
        List<PlayerModel> tempDefenseList;
        List<PlayerModel> tempForwardList;
        List<PlayerModel> tempGoalieList;
        tempDefenseList = currentShiftDefenseOfTeamOne;
        tempForwardList = currentShiftForwardOfTeamOne;
        tempGoalieList = currentShiftGoalieOfTeamOne;
        currentShiftGoalieOfTeamOne = currentShiftGoalieOfTeamTwo;
        currentShiftForwardOfTeamOne = currentShiftForwardOfTeamTwo;
        currentShiftDefenseOfTeamOne = currentShiftDefenseOfTeamTwo;
        currentShiftGoalieOfTeamTwo = tempGoalieList;
        currentShiftForwardOfTeamTwo = tempForwardList;
        currentShiftDefenseOfTeamTwo = tempDefenseList;
    }


    public void fillCurrentShiftData() {
        try {
            currentShiftDefenseOfTeamOne.add(listOfDefenseOfTeamOne.get(0));
            currentShiftDefenseOfTeamOne.add(listOfDefenseOfTeamOne.get(1));
            currentShiftForwardOfTeamOne.add(listOfForwardOfTeamOne.get(0));
            currentShiftForwardOfTeamOne.add(listOfForwardOfTeamOne.get(1));
            currentShiftForwardOfTeamOne.add(listOfForwardOfTeamOne.get(2));

            currentShiftGoalieOfTeamOne.add(listOfGoalieOfTeamOne.get(0));
            currentShiftGoalieOfTeamTwo.add(listOfGoaliesOfTeamTwo.get(0));

            currentShiftDefenseOfTeamTwo.add(listOfDefenseOfTeamTwo.get(0));
            currentShiftDefenseOfTeamTwo.add(listOfDefenseOfTeamTwo.get(1));
            currentShiftForwardOfTeamTwo.add(listOfForwardOfTeamTwo.get(0));
            currentShiftForwardOfTeamTwo.add(listOfForwardOfTeamTwo.get(1));
            currentShiftForwardOfTeamTwo.add(listOfForwardOfTeamTwo.get(2));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }


    public void performPenalty(List<PlayerModel> currentDefenseList) {
        try {
            System.out.println("Penelty is occured");
            currentDefenseList.get(0).setTotalPenaltyCount(currentDefenseList.get(0).getTotalPenaltyCount() + 1);
            currentDefenseList.get(0).setCurrentPenaltyCount(4);
            penaltyCounter = 4;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void replaceCurrentGoalie() {

        try {
            currentShiftGoalieOfTeamOne.remove(0);
            currentShiftGoalieOfTeamTwo.remove(0);
            currentShiftGoalieOfTeamOne.add(listOfGoalieOfTeamOne.get(1));
            currentShiftGoalieOfTeamTwo.add(listOfGoaliesOfTeamTwo.get(1));
        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        }
    }

    public void replaceDefenseAndForward() {
        try {
            currentShiftForwardOfTeamOne.clear();
            currentShiftForwardOfTeamTwo.clear();
            currentShiftDefenseOfTeamOne.clear();
            currentShiftDefenseOfTeamTwo.clear();

            currentShiftDefenseOfTeamOne.add(listOfDefenseOfTeamOne.get(2));
            currentShiftDefenseOfTeamOne.add(listOfDefenseOfTeamOne.get(3));
            currentShiftForwardOfTeamOne.add(listOfForwardOfTeamOne.get(2));
            currentShiftForwardOfTeamOne.add(listOfForwardOfTeamOne.get(3));
            currentShiftForwardOfTeamOne.add(listOfForwardOfTeamOne.get(4));

            currentShiftDefenseOfTeamTwo.add(listOfDefenseOfTeamTwo.get(2));
            currentShiftDefenseOfTeamTwo.add(listOfDefenseOfTeamTwo.get(3));
            currentShiftForwardOfTeamTwo.add(listOfForwardOfTeamTwo.get(2));
            currentShiftForwardOfTeamTwo.add(listOfForwardOfTeamTwo.get(3));
            currentShiftForwardOfTeamTwo.add(listOfForwardOfTeamTwo.get(4));

        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        }
    }
}
