package teams;

import players.PlayerModel;

import java.util.List;

public class TeamsModel implements  ITeamsModel{

    private String teamName;
    private String generalManager;
    private String headCoach;
    private List<PlayerModel> players;
    private PlayerModel playerModel;
    private ITeamsPersistent iTeamsPersistent;


    public TeamsModel() {
        playerModel = new PlayerModel();
        iTeamsPersistent = new TeamsPersistent();
    }

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

    public boolean storeTeamInformation(TeamsModel teamsModel, int divisionId) {
        if (isTeamAlreadyExist(teamsModel.getTeamName(), divisionId)) {
            System.out.println("Team already Exist in the DB");
            return false;
        } else {
            //Store head coach
            int headCoachId =0 ;
            //store general manager
            int generalManagerName = 0;
            //Store team Information
            int teamId =0;
            for (PlayerModel playerModel : teamsModel.getPlayers()) {
                this.playerModel.storePlayerInformation(playerModel, teamId);
            }
        }
        return false;
    }

    @Override
    public boolean isTeamAlreadyExist(String teamName, int divisionId) {
        return false;
    }

    @Override
    public int getTeamId(String teamName, int divisionId) {
        return 0;
    }

    private int storeHeadCoachInfirmation(String headCoachName){
        return 0;
    }

    private int storeGeneralManagerInformation(String generalManagerName){
        return 0;
    }
}
