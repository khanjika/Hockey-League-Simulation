package leagueobjectmodel;

import java.util.ArrayList;
import java.util.List;

public class MockTeam {
    public static List<PlayerModel> validTeamPlayers(){
        List<PlayerModel> teamsPlayers = new ArrayList<>();
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
