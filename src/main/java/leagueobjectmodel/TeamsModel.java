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

    @Override
    public void setLossPointForTrading(int lossPointForTrading) {
        this.lossPointForTrading = lossPointForTrading;
    }

    @Override
    public boolean isUserCreatedTeam() {
        return isUserCreatedTeam;
    }

    @Override
    public void setUserCreatedTeam(boolean userCreatedTeam) {
        isUserCreatedTeam = userCreatedTeam;
    }

    private boolean isUserCreatedTeam;

    public TeamsModel() {
        playerModel = new PlayerModel();
    }

    @Override
    public String getTeamName() {
        return teamName;
    }

    @Override
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    @Override
    public HeadCoachModel getHeadCoach() {
        return headCoach;
    }

    @Override
    public void setHeadCoach(HeadCoachModel headCoach) {
        this.headCoach = headCoach;
    }

    @Override
    public List<PlayerModel> getPlayers() {
        return players;
    }

    @Override
    public void setPlayers(List<PlayerModel> players) {
        this.players = players;
    }

    @Override
    public float getTeamStrength() {
        return teamStrength;
    }

    @Override
    public GeneralManagersModel getGeneralManager() {
        return generalManager;
    }

    @Override
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

    @Override
    public int getWinPoint() {
        return winPoint;
    }

    @Override
    public void setWinPoint(int winPoint) {
        this.winPoint = winPoint;
    }

    @Override
    public int getLossPoint() {
        return lossPoint;
    }

    @Override
    public void setLossPoint(int lossPoint) {
        this.lossPoint = lossPoint;
    }


    @Override
    public PlayerModel getBestGoalieFromTheTeam(List<PlayerModel> list) {
        if(list==null){
            throw new NullPointerException();
        }
        PlayerModel currentBestGoalie = null;
        for (PlayerModel playerModel : list) {
            if (playerModel.getPosition().equals("goalie")) {
                if (currentBestGoalie == null) {
                    currentBestGoalie = playerModel;
                } else if (playerModel.getSaving() > currentBestGoalie.getSaving()) {
                    currentBestGoalie = playerModel;
                }
            }
        }
        return currentBestGoalie;
    }
}
