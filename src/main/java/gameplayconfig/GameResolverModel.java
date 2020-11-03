package gameplayconfig;

import com.google.gson.annotations.Expose;

public class GameResolverModel implements IGameResolverModel{
    @Expose
    private float randomWinChance;
    IGameResolverPersistent iGameResolverPersistent;

    public float getRandomWinChance() {
        return randomWinChance;
    }

    public void setRandomWinChance(float randomWinChance) {
        this.randomWinChance = randomWinChance;
    }

    public int addGameResolverInformation(GameResolverModel gameResolverModel){
        iGameResolverPersistent=new GameResolverPersistent();
        return iGameResolverPersistent.storeGameResolverInformation(gameResolverModel.getRandomWinChance());
    }
}
