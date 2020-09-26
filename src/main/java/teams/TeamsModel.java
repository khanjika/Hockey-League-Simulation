package teams;

import players.PlayerModel;

import java.util.List;

public class TeamsModel {

    private  String teamName;
    private  String generalManager;
    private String  headCoach;
   private List<PlayerModel> players;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getGeneralManager() {
        return generalManager;
    }

    public void setGeneralManager(String generalManager) {
        this.generalManager = generalManager;
    }

    public String getHeadCoach() {
        return headCoach;
    }

    public void setHeadCoach(String headCoach) {
        this.headCoach = headCoach;
    }


    public List<PlayerModel> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerModel> players) {
        this.players = players;
    }
}
