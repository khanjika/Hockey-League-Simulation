package leagueobjectmodel;

import com.google.gson.annotations.Expose;

public class GameResolverModel implements IGameResolverModel {
    @Expose
    private float randomWinChance;

    public float getRandomWinChance() {
        return randomWinChance;
    }

    public void setRandomWinChance(float randomWinChance) {
        this.randomWinChance = randomWinChance;
    }


}
