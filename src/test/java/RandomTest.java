import cli.CliAbstractFactory;
import cli.ICli;
import leagueobjectmodel.IPlayerModel;
import leagueobjectmodel.IPlayerValidator;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import org.junit.jupiter.api.Test;
import statemachine.states.playerdraft.PlayerDraft;

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
        obj.printOutput("adsadsada");
        List<IPlayerModel> playerList = new ArrayList<>();

      PlayerDraft abc = new PlayerDraft();
//        PlayerDraft abc1 = new PlayerDraft();
//        System.out.println(abc.generatePlayerName());
//        System.out.println(abc.generatePlayerName());
//        System.out.println(abc.generatePlayerBirthDay(2));
//        System.out.println(abc.generatePlayerBirthYear(20));
//        System.out.println(abc.generatePlayer().getAge());
//        System.out.println(abc.generatePlayer().getAge());
//        for(int i=0;i<20;i++){
//            playerModel = abc.generatePlayer();
//            playerList.add(playerModel);
//        }
//        for(int i =0 ;i<playerList.size();i++){
//            System.out.println(playerList.get(i).getPlayerName());
//        }

//        System.out.println(abc.generatePlayerSkatingStat("goalie"));
//        System.out.println(abc.generatePlayerShootingStat("goalie"));
//        System.out.println(abc.generatePlayerCheckingStat("goalie"));
//        System.out.println(abc.generatePlayerSavingStat("goalie"));
//        for(int i =0;i<abc.draftPlayers().size();i++){
//            String name = abc.draftPlayers().get(i).getPlayerName();
//            System.out.println(name);
//        }

        List<IPlayerModel> draftedPlayers = abc.draftPlayers(5);
        System.out.println(draftedPlayers.size());
        for(int i = 0;i<draftedPlayers.size();i++){
            System.out.println(i+" - "+draftedPlayers.get(i).getPlayerName());
        }


    }

}
