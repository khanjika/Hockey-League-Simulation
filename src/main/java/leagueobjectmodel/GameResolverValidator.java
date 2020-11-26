package leagueobjectmodel;

public class GameResolverValidator implements IGameResolverValidator {

    @Override
    public boolean validateGameResolver(GameResolverModel gameResolverModel) {
        return isNotNull(gameResolverModel.getRandomWinChance());
    }

    public boolean isNotNull(float value) {
        return value != 0;
    }
}
