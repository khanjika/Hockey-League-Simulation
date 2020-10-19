package gameplayconfig;

public class GameResolverValidator implements IGameResolverValidator{

    @Override
    public boolean validateGameResolver(GameResolverModel gameResolverModel) {
        if(isNotNull(gameResolverModel.getRandomWinChance())){
            return true;
        }else {
            return false;
        }
    }
    public boolean isNotNull(float value){
        if(value == 0){
            return false;
        }
        else {
            return true;
        }
    }
}
