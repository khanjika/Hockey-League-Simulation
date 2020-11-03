package gameplayconfig;

public interface IGameResolverPersistent {

    int storeGameResolverInformation(float randomWinChance);

    GameResolverModel getGameResolverInformation(int gamePlayConfigId);
}
