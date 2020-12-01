import cli.CliAbstractFactory;
import cli.ICli;
import leagueobjectmodel.IPlayerModel;
import leagueobjectmodel.IPlayerValidator;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import org.junit.jupiter.api.Test;
import statemachine.playerdraft.PlayerDraft;

import java.util.ArrayList;
import java.util.List;

public class RandomTest {


    @Test
    void test() {
        IPlayerModel playerModel = LeagueObjectModelAbstractFactory.getInstance().getPlayer();
        playerModel.setPlayerName("Zankrut");
        System.out.println(playerModel.getPlayerName());
        IPlayerValidator playerValidator = LeagueObjectModelAbstractFactory.getInstance().getPlayerValidator();

        ICli obj = CliAbstractFactory.getInstance().getCli();
        List<IPlayerModel> playerList = new ArrayList<>();

      PlayerDraft abc = new PlayerDraft();
        List<IPlayerModel> draftedPlayers = abc.draftPlayers(5);


    }

}
