package statemachine.simulateGame;

import org.apache.log4j.Logger;

public class GameSimulationAbstractFactoryConcrete extends GameSimulationAbstractFactory{

  private static ISwapTurn iSwapTurn;
  private static IGameConfiguration gameConfiguration;
  private static IStartSimulation startSimulation;
  final static Logger logger = Logger.getLogger(GameSimulationAbstractFactoryConcrete.class);

    @Override
    public ISwapTurn getSwapTurn() {
        if(iSwapTurn==null){
            iSwapTurn=new SwapTurn();
            logger.info("New Object of SwapTurn Class is created");
        }
        return iSwapTurn;
    }

    @Override
    public void setSwapTurn(ISwapTurn swapTurn) {
            iSwapTurn=swapTurn;
    }

    @Override
    public IGameConfiguration getGameConfig() {
        if(gameConfiguration==null){
            gameConfiguration=new GameConfiguration();
            logger.info("New Object of GameConfiguration Class is created");
        }
        return gameConfiguration;
    }

    @Override
    public void setGameConfig(IGameConfiguration gameConfig) {
            gameConfiguration=gameConfig;
    }

    @Override
    public IStartSimulation getStartSimulation() {
            try {
                startSimulation=new StartSimulation();
            }catch (Exception e){
               throw e;
            }
        return startSimulation;
    }

    @Override
    public void setStartSimulation(IStartSimulation simulation) {
        startSimulation=simulation;
    }
}
