package gameplayconfig;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameResolverModelTest {

    @Test
    void getRandomWinChance() {
        GameResolverModel gameResolverModel = new GameResolverModel();
        gameResolverModel.setRandomWinChance(0.1f);
        assertEquals(0.1f, gameResolverModel.getRandomWinChance(), "Failed to get randomWinChance in Game Resolver object");
    }

    @Test
    void setRandomWinChance() {
        GameResolverModel gameResolverModel = new GameResolverModel();
        gameResolverModel.setRandomWinChance(0.1f);
        assertEquals(0.1f, gameResolverModel.getRandomWinChance(), "Failed to set randomWinChance in Game Resolver object");
    }

    public static AgingModel getAgingModel(int averageRetirementAge, int maximumAge) {
        AgingModel agingModel = new AgingModel();
        agingModel.setAverageRetirementAge(averageRetirementAge);
        agingModel.setMaximumAge(maximumAge);
        return agingModel;
    }

    public static GameResolverModel getgameResolverModel(float randomWinChance) {
        GameResolverModel gameResolverModel = new GameResolverModel();
        gameResolverModel.setRandomWinChance(randomWinChance);
        return gameResolverModel;
    }


}
