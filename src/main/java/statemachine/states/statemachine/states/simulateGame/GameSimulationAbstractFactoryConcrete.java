package statemachine.states.statemachine.states.simulateGame;

public class GameSimulationAbstractFactoryConcrete extends GameSimulationAbstractFactory{

  private static ISwapTurn iSwapTurn;
  private static IGameConfiguration gameConfiguration;
  private static IStartSimulation startSimulation;


    @Override
    public ISwapTurn getSwapTurn() {
        if(iSwapTurn==null){
            iSwapTurn=new SwapTurn();
        }
        return iSwapTurn;
    }

    @Override
    public void setSwapTurn(ISwapTurn swapTurn) {
            this.iSwapTurn=swapTurn;
    }

    @Override
    public IGameConfiguration getGameConfig() {
        if(gameConfiguration==null){
            gameConfiguration=new GameConfiguration();
        }
        return gameConfiguration;
    }

    @Override
    public void setGameConfig(IGameConfiguration gameConfig) {
            gameConfiguration=gameConfig;
    }

    @Override
    public IStartSimulation getStartSimulation() {
        if(startSimulation==null){
            try {
                startSimulation=new StartSimulation();
            }catch (Exception e){

            }
        }
        return startSimulation;
    }

    @Override
    public void setStartSimulation(IStartSimulation simulation) {
        startSimulation=simulation;
    }
}
