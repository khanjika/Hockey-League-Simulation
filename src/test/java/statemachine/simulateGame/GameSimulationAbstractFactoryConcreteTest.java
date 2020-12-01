package statemachine.simulateGame;

import leagueobjectmodel.PlayerModel;

import java.util.ArrayList;
import java.util.List;

public class GameSimulationAbstractFactoryConcreteTest extends GameSimulationAbstractFactoryTest {


    @Override
    public ISwapTurn getSwapTurn() {
        return GameSimulationAbstractFactory.getGameSimulationInstance().getSwapTurn();
    }

    @Override
    public void setSwapTurn(ISwapTurn swapTurn) {
        GameSimulationAbstractFactory.getGameSimulationInstance().setSwapTurn(swapTurn);
    }

    @Override
    public IGameConfiguration getGameConfig() {
        return GameSimulationAbstractFactory.getGameSimulationInstance().getGameConfig();
    }

    @Override
    public void setGameConfig(IGameConfiguration gameConfig) {
        GameSimulationAbstractFactory.getGameSimulationInstance().setGameConfig(gameConfig);
    }

    @Override
    public IStartSimulation getStartSimulation() {
        return GameSimulationAbstractFactory.getGameSimulationInstance().getStartSimulation();
    }

    @Override
    public void setStartSimulation(IStartSimulation simulation) {
        GameSimulationAbstractFactory.getGameSimulationInstance().setStartSimulation(simulation);
    }

    @Override
    public List<PlayerModel> getMockList() {
        List<PlayerModel> playerModels=new ArrayList<>();
        playerModels.add(new PlayerModel());
        playerModels.add(new PlayerModel());
        playerModels.add(new PlayerModel());
        playerModels.add(new PlayerModel());
        playerModels.add(new PlayerModel());
        playerModels.add(new PlayerModel());

        return playerModels;
    }
}
