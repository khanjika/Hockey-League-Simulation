package leagueobjectmodel;

public class GameResolverValidator implements IGameResolverValidator {

    @Override
    public boolean validateGameResolver(GameResolverModel gameResolverModel) {
        return isNotNull(gameResolverModel.getRandomWinChance());
    }

    public boolean isNotNull(float value) {
        if(value==0){
            return false;
        }
        else
            return true;
    }
}
