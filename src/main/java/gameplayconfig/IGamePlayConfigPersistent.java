package gameplayconfig;

public interface IGamePlayConfigPersistent {

    int storeGamePlayConfigInformation(int agingId, int gameResolverId, int injuriesId, int trainingId, int tradingId);
}
