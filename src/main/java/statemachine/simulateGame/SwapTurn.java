package statemachine.simulateGame;

import leagueobjectmodel.PlayerModel;
import org.apache.log4j.Logger;

import java.util.List;

public class SwapTurn implements ISwapTurn {

    GameSimulationAbstractFactory objFactory;
    IGameConfiguration gameConfiguration;
    final static Logger logger = Logger.getLogger(SwapTurn.class);

    @Override
    public void swapTurnOfTeam() {

        if (objFactory == null) {
            throw new NullPointerException("Object factory is not Initialized for swap turn class");
        }
        List<PlayerModel> tempDefenseList;
        List<PlayerModel> tempForwardList;
        List<PlayerModel> tempGoalieList;
        tempDefenseList = gameConfiguration.getCurrentShiftDefenseOfTeamOne();
        tempForwardList = gameConfiguration.getCurrentShiftForwardOfTeamOne();
        tempGoalieList = gameConfiguration.getCurrentShiftGoalieOfTeamOne();
        gameConfiguration.setCurrentShiftGoalieOfTeamOne(gameConfiguration.getCurrentShiftGoalieOfTeamTwo());
        gameConfiguration.setCurrentShiftForwardOfTeamOne(gameConfiguration.getCurrentShiftForwardOfTeamTwo());
        gameConfiguration.setCurrentShiftDefenseOfTeamOne(gameConfiguration.getCurrentShiftDefenseOfTeamTwo());
        gameConfiguration.setCurrentShiftGoalieOfTeamTwo(tempGoalieList);
        gameConfiguration.setCurrentShiftForwardOfTeamTwo(tempForwardList);
        gameConfiguration.setCurrentShiftDefenseOfTeamTwo(tempDefenseList);
    }

    @Override
    public void swapTurnOfGoalie() {
        try {
            gameConfiguration.getCurrentShiftGoalieOfTeamOne().remove(0);
            gameConfiguration.getCurrentShiftGoalieOfTeamTwo().remove(0);
            gameConfiguration.getCurrentShiftGoalieOfTeamOne().add(gameConfiguration.getListOfGoalieOfTeamOne().get(1));
            gameConfiguration.getCurrentShiftGoalieOfTeamTwo().add(gameConfiguration.getListOfGoaliesOfTeamTwo().get(1));
        } catch (NullPointerException nullPointerException) {
            logger.error("Exception occurred while performing swap of goalies ");
            throw nullPointerException;
        }
    }

    @Override
    public void swapTurnOfForwardAndDefense() {
        try {
            gameConfiguration.getCurrentShiftForwardOfTeamOne().clear();
            gameConfiguration.getCurrentShiftForwardOfTeamTwo().clear();
            gameConfiguration.getCurrentShiftDefenseOfTeamOne().clear();
            gameConfiguration.getCurrentShiftDefenseOfTeamTwo().clear();

            gameConfiguration.getCurrentShiftDefenseOfTeamOne().add(gameConfiguration.getListOfDefenseOfTeamOne().get(2));
            gameConfiguration.getCurrentShiftDefenseOfTeamOne().add(gameConfiguration.getListOfDefenseOfTeamOne().get(3));
            gameConfiguration.getCurrentShiftForwardOfTeamOne().add(gameConfiguration.getListOfForwardOfTeamOne().get(2));
            gameConfiguration.getCurrentShiftForwardOfTeamOne().add(gameConfiguration.getListOfForwardOfTeamOne().get(3));
            gameConfiguration.getCurrentShiftForwardOfTeamOne().add(gameConfiguration.getListOfForwardOfTeamOne().get(4));

            gameConfiguration.getCurrentShiftDefenseOfTeamTwo().add(gameConfiguration.getListOfDefenseOfTeamTwo().get(2));
            gameConfiguration.getCurrentShiftDefenseOfTeamTwo().add(gameConfiguration.getListOfDefenseOfTeamTwo().get(3));
            gameConfiguration.getCurrentShiftForwardOfTeamTwo().add(gameConfiguration.getListOfForwardOfTeamTwo().get(2));
            gameConfiguration.getCurrentShiftForwardOfTeamTwo().add(gameConfiguration.getListOfForwardOfTeamTwo().get(3));
            gameConfiguration.getCurrentShiftForwardOfTeamTwo().add(gameConfiguration.getListOfForwardOfTeamTwo().get(4));


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
        this.gameConfiguration=gameSimulationAbstractFactory.getGameConfig();
    }

}
