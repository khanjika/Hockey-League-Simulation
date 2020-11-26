package simulateGame;

public class GameSimulationAbstractFactoryConcrete extends GameSimulationAbstractFactory{

  private static ISwapTurn iSwapTurn;
  private static GameConfiguration gameConfiguration;


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
    public GameConfiguration getGameConfig() {
        if(gameConfiguration==null){
            gameConfiguration=new GameConfiguration();
        }
        return gameConfiguration;
    }

    @Override
    public void setGameConfig(GameConfiguration gameConfig) {
            gameConfiguration=gameConfig;
    }
}
