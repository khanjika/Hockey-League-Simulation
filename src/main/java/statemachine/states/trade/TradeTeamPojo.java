package statemachine.states.trade;

import com.google.gson.annotations.Expose;
import leagueobjectmodel.PlayerModel;

import java.util.List;

public class TradeTeamPojo implements ITradeTeamPojo {
    @Expose
    private String teamName;
    @Expose
    private String divisionName;
    @Expose
    private String conferenceName;
    @Expose
    private boolean isUserCreated;
    @Expose
    private int isForwardStrong;
    @Expose
    private int isDefenseStrong;
    @Expose
    private int isGoalieStrong;
    @Expose
    private List<PlayerModel> playersList;

    public List<PlayerModel> getPlayersList() {
        return playersList;
    }

    @Override
    public void setPlayersList(List<PlayerModel> playersList) {
        this.playersList = playersList;
    }

    public int getIsForwardStrong() {
        return isForwardStrong;
    }

    @Override
    public void setIsForwardStrong(int isForwardStrong) {
        this.isForwardStrong = isForwardStrong;
    }

    public int getIsDefenseStrong() {
        return isDefenseStrong;
    }

    @Override
    public void setIsDefenseStrong(int isDefenseStrong) {
        this.isDefenseStrong = isDefenseStrong;
    }

    public int getIsGoalieStrong() {
        return isGoalieStrong;
    }

    @Override
    public void setIsGoalieStrong(int isGoalieStrong) {
        this.isGoalieStrong = isGoalieStrong;
    }

    public boolean isUserCreated() {
        return isUserCreated;
    }

    @Override
    public void setUserCreated(boolean userCreated) {
        isUserCreated = userCreated;
    }

    public String getTeamName() {
        return teamName;
    }

    @Override
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getDivisionName() {
        return divisionName;
    }

    @Override
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    @Override
    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }


}


