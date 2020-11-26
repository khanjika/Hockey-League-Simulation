package statemachine.states.statemachine.states.simulateGame;

import leagueobjectmodel.PlayerModel;

import java.util.List;

public class SwapTurn implements ISwapTurn{

    GameSimulationAbstractFactory objFactory;
    @Override
    public void swapTurnOfTeam() {

        List<PlayerModel> tempDefenseList;
        List<PlayerModel> tempForwardList;
        List<PlayerModel> tempGoalieList;
        tempDefenseList = objFactory.getGameConfig().getCurrentShiftDefenseOfTeamOne();
        tempForwardList = objFactory.getGameConfig().getCurrentShiftForwardOfTeamOne();
        tempGoalieList = objFactory.getGameConfig().getCurrentShiftGoalieOfTeamOne();
        objFactory.getGameConfig().setCurrentShiftGoalieOfTeamOne(objFactory.getGameConfig().getCurrentShiftGoalieOfTeamTwo());
        objFactory.getGameConfig().setCurrentShiftForwardOfTeamOne( objFactory.getGameConfig().getCurrentShiftForwardOfTeamTwo());
        objFactory.getGameConfig().setCurrentShiftDefenseOfTeamOne(objFactory.getGameConfig().getCurrentShiftDefenseOfTeamTwo());
        objFactory.getGameConfig().setCurrentShiftGoalieOfTeamTwo(tempGoalieList);
        objFactory.getGameConfig().setCurrentShiftForwardOfTeamTwo(tempForwardList);
        objFactory.getGameConfig().setCurrentShiftDefenseOfTeamTwo(tempDefenseList);
    }

    @Override
    public void swapTurnOfGoalie() {
        try {
            objFactory.getGameConfig().getCurrentShiftGoalieOfTeamOne().remove(0);
            objFactory.getGameConfig().getCurrentShiftGoalieOfTeamTwo().remove(0);
            objFactory.getGameConfig().getCurrentShiftGoalieOfTeamOne().add(objFactory.getGameConfig().getListOfGoalieOfTeamOne().get(1));
            objFactory.getGameConfig().getCurrentShiftGoalieOfTeamTwo().add(objFactory.getGameConfig().getListOfGoaliesOfTeamTwo().get(1));
        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        }
    }

    @Override
    public void swapTurnOfForwardAndDefense() {

        try {
            objFactory.getGameConfig().getCurrentShiftForwardOfTeamOne().clear();
            objFactory.getGameConfig().getCurrentShiftForwardOfTeamTwo().clear();
            objFactory.getGameConfig().getCurrentShiftDefenseOfTeamOne().clear();
            objFactory.getGameConfig().getCurrentShiftDefenseOfTeamTwo().clear();

            objFactory.getGameConfig().getCurrentShiftDefenseOfTeamOne().add(objFactory.getGameConfig().getListOfDefenseOfTeamOne().get(2));
            objFactory.getGameConfig().getCurrentShiftDefenseOfTeamOne().add(objFactory.getGameConfig().getListOfDefenseOfTeamOne().get(3));
            objFactory.getGameConfig().getCurrentShiftForwardOfTeamOne().add(objFactory.getGameConfig().getListOfForwardOfTeamOne().get(2));
            objFactory.getGameConfig().getCurrentShiftForwardOfTeamOne().add(objFactory.getGameConfig().getListOfForwardOfTeamOne().get(3));
            objFactory.getGameConfig().getCurrentShiftForwardOfTeamOne().add(objFactory.getGameConfig().getListOfForwardOfTeamOne().get(4));

            objFactory.getGameConfig().getCurrentShiftDefenseOfTeamTwo().add(objFactory.getGameConfig().getListOfDefenseOfTeamTwo().get(2));
            objFactory.getGameConfig().getCurrentShiftDefenseOfTeamTwo().add(objFactory.getGameConfig().getListOfDefenseOfTeamTwo().get(3));
            objFactory.getGameConfig().getCurrentShiftForwardOfTeamTwo().add(objFactory.getGameConfig().getListOfForwardOfTeamTwo().get(2));
            objFactory.getGameConfig().getCurrentShiftForwardOfTeamTwo().add(objFactory.getGameConfig().getListOfForwardOfTeamTwo().get(3));
            objFactory.getGameConfig().getCurrentShiftForwardOfTeamTwo().add(objFactory.getGameConfig().getListOfForwardOfTeamTwo().get(4));


        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        }


    }

    @Override
    public void setAbstractFactoryObject(GameSimulationAbstractFactory gameSimulationAbstractFactory) {
        this.objFactory=gameSimulationAbstractFactory;
    }
}
