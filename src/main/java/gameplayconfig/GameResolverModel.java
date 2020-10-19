package gameplayconfig;

public class GameResolverModel implements IGameResolverModel{
    private float randomWinChance;

    public float getRandomWinChance() {
        return randomWinChance;
    }

    public void setRandomWinChance(float randomWinChance) {
        this.randomWinChance = randomWinChance;
    }
}
