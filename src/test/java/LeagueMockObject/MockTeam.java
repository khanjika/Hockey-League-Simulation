package LeagueMockObject;

import LeagueMockObject.MockPlayer;
import leagueobjectmodel.IPlayerModel;

import java.util.ArrayList;
import java.util.List;

public class MockTeam {
    public static List<IPlayerModel> validTeamPlayers(){
        List<IPlayerModel> teamsPlayers = new ArrayList<>();
        for (int i=0;i<16;i++) {
            teamsPlayers.add(MockPlayer.getForwardPlayer());
        }
        for (int i=0;i<10;i++){
            teamsPlayers.add(MockPlayer.getDefensePlayer());
        }
        for(int i=0;i<8;i++){
            teamsPlayers.add(MockPlayer.getGoaliePlayer());
        }
        return teamsPlayers;
    }
}
