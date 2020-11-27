package statemachine.states.statemachine.states.simulateGame;

import leagueobjectmodel.PlayerModel;
import org.apache.log4j.Logger;

import java.util.List;

public class SwapTurn implements ISwapTurn {

    GameSimulationAbstractFactory objFactory;
    final static Logger logger = Logger.getLogger(SwapTurn.class);

    @Override
    public void swapTurnOfTeam() {

        if (objFactory == null) {
            throw new NullPointerException("Object factory is not Initialized for swap turn class");
        }
        List<PlayerModel> tempDefenseList;
        List<PlayerModel> tempForwardList;
        List<PlayerModel> tempGoalieList;
        tempDefenseList = objFactory.getGameConfig().getCurrentShiftDefenseOfTeamOne();
        tempForwardList = objFactory.getGameConfig().getCurrentShiftForwardOfTeamOne();
        tempGoalieList = objFactory.getGameConfig().getCurrentShiftGoalieOfTeamOne();
        objFactory.getGameConfig().setCurrentShiftGoalieOfTeamOne(objFactory.getGameConfig().getCurrentShiftGoalieOfTeamTwo());
        objFactory.getGameConfig().setCurrentShiftForwardOfTeamOne(objFactory.getGameConfig().getCurrentShiftForwardOfTeamTwo());
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
        } catch (NullPointerException nullPointerException) {
            logger.error("Exception occurred while performing swap of goalies ");
            throw nullPointerException;
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


        } catch (NullPointerException nullPointerException) {
            logger.error("Exception occurred while performing swap of Forward and Defense ");
            throw nullPointerException;
        }


    }

    @Override
    public void setAbstractFactoryObject(GameSimulationAbstractFactory gameSimulationAbstractFactory) {
        if (gameSimulationAbstractFactory == null) {
            throw new NullPointerException();
        }
        this.objFactory = gameSimulationAbstractFactory;
    }
}
