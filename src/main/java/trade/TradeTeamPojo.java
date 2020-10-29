package trade;

public class TradeTeamPojo implements ITradeTeamPojo {

    private String teamName;
    private String divisionName;
    private String conferenceName;
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


