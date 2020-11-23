package teams;

import com.google.gson.annotations.Expose;
import players.IPlayerModel;
import players.PlayerModel;

import java.util.List;

public class TeamsModel implements ITeamsModel {

    @Expose
    private String teamName;
    @Expose
    private String generalManager;
    @Expose
    private HeadCoachModel headCoach;
    @Expose
    private List<PlayerModel> players;
    private final IPlayerModel playerModel;
    private final ITeamsPersistent iTeamsPersistent;
    private float teamStrength;
    private int winPoint;
    private int lossPoint;
    private int lossPointForTrading;


    public int getLossPointForTrading() {
        return lossPointForTrading;
    }

    public void setLossPointForTrading(int lossPointForTrading) {
        this.lossPointForTrading = lossPointForTrading;
    }

    public boolean isUserCreatedTeam() {
        return isUserCreatedTeam;
    }

    public void setUserCreatedTeam(boolean userCreatedTeam) {
        isUserCreatedTeam = userCreatedTeam;
    }

    private boolean isUserCreatedTeam;

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

    public HeadCoachModel getHeadCoach() {
        return headCoach;
    }

    public void setHeadCoach(HeadCoachModel headCoach) {
        this.headCoach = headCoach;
    }

    public List<PlayerModel> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerModel> players) {
        this.players = players;
    }

    public float getTeamStrength() {
        return teamStrength;
    }

    public void storeTeamInformation(TeamsModel teamsModel, int divisionId) {
        if (isTeamAlreadyExist(teamsModel.getTeamName(), divisionId)) {
            System.out.println("Team already Exist in the DB");
        } else {
            int headCoachId = 0;
            int generalManagerId = storeGeneralManagerInformation(teamsModel.getGeneralManager());
            int teamId = addTeamInformation(teamsModel.getTeamName(), generalManagerId, headCoachId, divisionId);
            for (PlayerModel playerModel : teamsModel.getPlayers()) {
                this.playerModel.storePlayerInformation(playerModel, teamId);
            }
        }
    }

    public int addTeamInformation(String teamName, int generalManagerId, int headCoachId, int divisionId) {
        return iTeamsPersistent.addTeamInformation(teamName, generalManagerId, headCoachId, divisionId);
    }

    @Override
    public boolean isTeamAlreadyExist(String teamName, int divisionId) {
        return iTeamsPersistent.isTeamNameExist(teamName, divisionId);
    }

    @Override
    public int getTeamId(String teamName, int divisionId) {
        return iTeamsPersistent.getTeamId(teamName, divisionId);
    }

    @Override
    public TeamPojo getTeamInformation(String teamName, int divisionId) {
        return iTeamsPersistent.getTeamInformation(teamName, divisionId);
    }

    @Override
    public void calculateTeamStrength(TeamsModel teamsModel) {
        teamsModel.teamStrength = 0;
        for (PlayerModel playerModel : teamsModel.getPlayers()) {
            this.teamStrength += playerModel.getPlayerStrength();
        }
    }

    private int storeHeadCoachInformation(String headCoachName) {
        return iTeamsPersistent.addHeadCoahDetails(headCoachName);
    }

    private int storeGeneralManagerInformation(String generalManagerName) {
        return 1;
    }

    public int getWinPoint() {
        return winPoint;
    }

    public void setWinPoint(int winPoint) {
        this.winPoint = winPoint;
    }

    public int getLossPoint() {
        return lossPoint;
    }

    public void setLossPoint(int lossPoint) {
        this.lossPoint = lossPoint;
    }
}
