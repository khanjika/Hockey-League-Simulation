package teams;

import players.IPlayerModel;
import players.PlayerModel;

import java.util.List;

public class TeamsModel implements  ITeamsModel{

    private String teamName;
    private String generalManager;
    private String headCoach;
    private List<PlayerModel> players;
    private IPlayerModel playerModel;
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

    public void storeTeamInformation(TeamsModel teamsModel, int divisionId) {
        if (isTeamAlreadyExist(teamsModel.getTeamName(), divisionId)) {
            System.out.println("Team already Exist in the DB");
        } else {
            System.out.println("Inside team method to store information="+teamsModel.getTeamName());
            //Store head coach
            int headCoachId =storeHeadCoachInfirmation(teamsModel.getHeadCoach()) ;
            System.out.println("Head coch ID=>"+headCoachId);
            //store general manager
            int generalManagerId = storeGeneralManagerInformation(teamsModel.getGeneralManager());
            System.out.println("General manager ID=>"+generalManagerId);
            //Store team Information
            int teamId =addTeamInformation(teamsModel.getTeamName(),generalManagerId,headCoachId,divisionId);
            System.out.println("New Team ID=>"+teamId);
//            for (PlayerModel playerModel : teamsModel.getPlayers()) {
//               this.playerModel.storePlayerInformation(playerModel, teamId);
//
//            }
        }

    }

    public int addTeamInformation(String teamName, int generalManagerId, int headCoachId, int divisionId){
        return iTeamsPersistent.addTeamInformation(teamName,generalManagerId,headCoachId,divisionId);
    }

    @Override
    public boolean isTeamAlreadyExist(String teamName, int divisionId) {
        return iTeamsPersistent.isTeamNameExist(teamName,divisionId);
    }

    @Override
    public int getTeamId(String teamName, int divisionId) {
        return iTeamsPersistent.getTeamId(teamName,divisionId);
    }

    private int storeHeadCoachInfirmation(String headCoachName){
        System.out.println("Storing Head coach info");
        return iTeamsPersistent.addHeadCoahDetails(headCoachName);
    }

    private int storeGeneralManagerInformation(String generalManagerName){
        System.out.println("Storing general manager info");
        return iTeamsPersistent.addGeneralManagerDetails(generalManagerName);
    }
}
