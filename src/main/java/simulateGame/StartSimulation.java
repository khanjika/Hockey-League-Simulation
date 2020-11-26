package simulateGame;

import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.PlayerModel;
import leagueobjectmodel.TeamsModel;

import java.util.ArrayList;
import java.util.List;


public class StartSimulation {

    private static TeamsModel teamOneObject;
    private static TeamsModel teamTwoObject;
    private int averageShotsOnGoal = 40;
    private boolean isThisPlayOff;
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

    GameSimulationAbstractFactory objFactory;
    public StartSimulation(TeamsModel teamOne, TeamsModel teamTwo, LeagueModel leagueModel, boolean isPlayOff,GameSimulationAbstractFactory obj) {
        teamOneObject = teamOne;
        teamTwoObject = teamTwo;
        leagueModelObject = leagueModel;
        isThisPlayOff = isPlayOff;
        this.objFactory=obj;
    }
    public void separatePlayerByPosition() {
        leagueModelObject.setPenaltyChance((float) 0.5);
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
        objFactory.getGameConfig().setListOfForwardOfTeamOne(listOfForwardOfTeamOne);
        objFactory.getGameConfig().setListOfForwardOfTeamTwo(listOfForwardOfTeamTwo);
        objFactory.getGameConfig().setListOfDefenseOfTeamOne(listOfDefenseOfTeamOne);
        objFactory.getGameConfig().setListOfDefenseOfTeamTwo(listOfDefenseOfTeamTwo);
        objFactory.getGameConfig().setListOfGoalieOfTeamOne(listOfGoalieOfTeamOne);
        objFactory.getGameConfig().setListOfGoaliesOfTeamTwo(listOfGoaliesOfTeamTwo);

        objFactory.getSwapTurn().setAbstractFactoryObject(objFactory);

        setAverageShotsOnGoal();
        initializeSlots();
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
        if (teamOneShootingState >= teamTwoShootingState) {
            int skatingStateDifference= (int) (teamOneSkatingState-teamTwoSkatingState);
            if(skatingStateDifference<10){
                averageShotsOnGoal=averageShotsOnGoal-skatingStateDifference;
            }else {
                averageShotsOnGoal=averageShotsOnGoal-10;
            }

        }
        objFactory.getGameConfig().setAverageShotsOnGoal(averageShotsOnGoal);
    }

    public void initializeSlots() {
        fillCurrentShiftData();
        for (int i = 0; i < 3; i++) {
            if (i == 2 && isThisPlayOff==false) {
               replaceCurrentGoalie();
            }
            for (int j = 0; j < 40; j++) {
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
        float attackingTeamShootingState = getShootingState(objFactory.getGameConfig().getCurrentShiftForwardOfTeamOne());
        float defendingTwoShootingState = getShootingState(objFactory.getGameConfig().getCurrentShiftForwardOfTeamTwo());
        float attackingTeamCheckingState = getCheckingState(objFactory.getGameConfig().getCurrentShiftDefenseOfTeamOne());
        float defendingTeamCheckingState = getCheckingState(objFactory.getGameConfig().getCurrentShiftDefenseOfTeamTwo());
        float attackingTeamSavingState = getSavingState(objFactory.getGameConfig().getCurrentShiftGoalieOfTeamOne());
        float defendingTeamSavingState = getSavingState(objFactory.getGameConfig().getCurrentShiftGoalieOfTeamTwo());
        if (attackingTeamShootingState >= defendingTwoShootingState) {
            if (defendingTeamCheckingState >= attackingTeamCheckingState && penaltyCounter == 0) {
                double randomChanceNumber = Math.random();
                if (randomChanceNumber >= leagueModelObject.getPenaltyChance()) {
                    performPenalty(objFactory.getGameConfig().getCurrentShiftDefenseOfTeamTwo());
                }
            } else {
                if (defendingTeamSavingState >= attackingTeamSavingState) {
                    int save = objFactory.getGameConfig().getListOfGoaliesOfTeamTwo().get(0).getSaveForGoalie();
                    objFactory.getGameConfig().getListOfGoaliesOfTeamTwo().get(0).setSaveForGoalie(save + 1);
                } else {
                    int currentGaolCount = objFactory.getGameConfig().getListOfForwardOfTeamOne().get(0).getGoalScorerCount();
                    objFactory.getGameConfig().getListOfForwardOfTeamOne().get(0).setGoalScorerCount(currentGaolCount + 1);
                }
            }

        } else {
            swapTurnOfTeam();
            performOperation();
        }

    }

    public float getShootingState(List<PlayerModel> playerModelList) {
        if(playerModelList==null){
            throw new NullPointerException();
        }
        float shootingState = 0;
        for (PlayerModel playerModel : playerModelList) {
            shootingState = shootingState + playerModel.getShooting();
        }
        return shootingState;
    }

    public float getCheckingState(List<PlayerModel> playerModelList) {
        if(playerModelList==null){
            throw new NullPointerException();
        }
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
        if(playerModelList==null){
            throw new NullPointerException();
        }
        float savingSate = 0;
        for (PlayerModel playerModel : playerModelList) {
            savingSate = savingSate + playerModel.getSaving();
        }
        return savingSate;
    }


    public void swapTurnOfTeam() {
        objFactory.getSwapTurn().swapTurnOfTeam();
    }


    public void fillCurrentShiftData() {
        try {
            currentShiftDefenseOfTeamOne.add(listOfDefenseOfTeamOne.get(0));
            currentShiftDefenseOfTeamOne.add(listOfDefenseOfTeamOne.get(1));
            currentShiftForwardOfTeamOne.add(listOfForwardOfTeamOne.get(0));
            currentShiftForwardOfTeamOne.add(listOfForwardOfTeamOne.get(1));
            currentShiftForwardOfTeamOne.add(listOfForwardOfTeamOne.get(2));
           if(isThisPlayOff){
               currentShiftGoalieOfTeamOne.add(getBestGoalieFromTheTeam(listOfGoalieOfTeamOne));
               currentShiftGoalieOfTeamTwo.add(getBestGoalieFromTheTeam(listOfGoaliesOfTeamTwo));
           }
           else {
               currentShiftGoalieOfTeamOne.add(listOfGoalieOfTeamOne.get(0));
               currentShiftGoalieOfTeamTwo.add(listOfGoaliesOfTeamTwo.get(0));
           }

            currentShiftDefenseOfTeamTwo.add(listOfDefenseOfTeamTwo.get(0));
            currentShiftDefenseOfTeamTwo.add(listOfDefenseOfTeamTwo.get(1));
            currentShiftForwardOfTeamTwo.add(listOfForwardOfTeamTwo.get(0));
            currentShiftForwardOfTeamTwo.add(listOfForwardOfTeamTwo.get(1));
            currentShiftForwardOfTeamTwo.add(listOfForwardOfTeamTwo.get(2));


            objFactory.getGameConfig().setCurrentShiftDefenseOfTeamOne(currentShiftDefenseOfTeamOne);
            objFactory.getGameConfig().setCurrentShiftDefenseOfTeamTwo(currentShiftDefenseOfTeamTwo);
            objFactory.getGameConfig().setCurrentShiftForwardOfTeamOne(currentShiftForwardOfTeamOne);
            objFactory.getGameConfig().setCurrentShiftForwardOfTeamTwo(currentShiftForwardOfTeamTwo);
            objFactory.getGameConfig().setCurrentShiftGoalieOfTeamOne(currentShiftGoalieOfTeamOne);
            objFactory.getGameConfig().setCurrentShiftGoalieOfTeamTwo(currentShiftGoalieOfTeamTwo);


        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }


    public void performPenalty(List<PlayerModel> currentDefenseList) {
        try {
            currentDefenseList.get(0).setTotalPenaltyCount(currentDefenseList.get(0).getTotalPenaltyCount() + 1);
            currentDefenseList.get(0).setCurrentPenaltyCount(4);
            penaltyCounter = 4;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void replaceCurrentGoalie() {
        objFactory.getSwapTurn().swapTurnOfGoalie();
    }

    public void replaceDefenseAndForward() {
        objFactory.getSwapTurn().swapTurnOfForwardAndDefense();
    }


    public PlayerModel getBestGoalieFromTheTeam(List<PlayerModel> list) {
        if(list==null){
            throw new NullPointerException();
        }
        PlayerModel currentBestGoalie = null;
        for (PlayerModel playerModel : list) {
            if (playerModel.getPosition().equals("goalie")) {
                if (currentBestGoalie == null) {
                    currentBestGoalie = playerModel;
                } else if (playerModel.getSaving() > currentBestGoalie.getSaving()) {
                    currentBestGoalie = playerModel;
                }
            }
        }
        return currentBestGoalie;
    }
}
