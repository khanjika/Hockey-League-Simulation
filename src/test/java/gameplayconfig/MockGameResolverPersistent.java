package gameplayconfig;

public class MockGameResolverPersistent {
    int storeGameResolverInformation(float randomWinChance) {
        return 0;
    }

    GameResolverModel getGameResolverInformation(int gamePlayConfigId) {
        GameResolverModel gameResolverModel = new GameResolverModel();
        gameResolverModel.setRandomWinChance(0.1f);
        return gameResolverModel;
    }
}
