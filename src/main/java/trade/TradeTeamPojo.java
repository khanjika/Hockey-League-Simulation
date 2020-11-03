package trade;

import com.google.gson.annotations.Expose;

public class TradeTeamPojo implements ITradeTeamPojo {
    @Expose
    private String teamName;
    @Expose
    private String divisionName;
    @Expose
    private String conferenceName;
    @Expose
    private boolean isUserCreated;

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


