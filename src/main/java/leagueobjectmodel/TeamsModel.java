package leagueobjectmodel;

import com.google.gson.annotations.Expose;

import java.util.List;

public class TeamsModel implements ITeamsModel {

    @Expose
    private String teamName;
    @Expose
    private GeneralManagersModel generalManager;
    @Expose
    private HeadCoachModel headCoach;
    @Expose
    private List<PlayerModel> players;
    private final IPlayerModel playerModel;
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
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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

    public GeneralManagersModel getGeneralManager() {
        return generalManager;
    }

    public void setGeneralManager(GeneralManagersModel generalManager) {
        this.generalManager = generalManager;
    }

    @Override
    public void calculateTeamStrength(TeamsModel teamsModel) {
        teamsModel.teamStrength = 0;
        for (PlayerModel playerModel : teamsModel.getPlayers()) {
            this.teamStrength += playerModel.getPlayerStrength();
        }
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
