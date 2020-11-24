import leagueobjectmodel.IPlayerModel;
import leagueobjectmodel.IPlayerValidator;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import leagueobjectmodel.PlayerModel;
import org.junit.jupiter.api.Test;

public class RandomTest {


    @Test
    void test(){
        IPlayerModel playerModel = LeagueObjectModelAbstractFactory.getInstance().getPlayer();
        playerModel.setPlayerName("Zankrut");
        System.out.println(playerModel.getPlayerName());
        IPlayerValidator playerValidator = LeagueObjectModelAbstractFactory.getInstance().getPlayerValidator();
    }
}
