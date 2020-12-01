package leagueobjectmodel;

import com.google.gson.annotations.Expose;

public class GameResolverModel implements IGameResolverModel {
    private float randomWinChance;

    @Override
    public float getRandomWinChance() {
        return randomWinChance;
    }

    @Override
    public void setRandomWinChance(float randomWinChance) {
        this.randomWinChance = randomWinChance;
    }


}
