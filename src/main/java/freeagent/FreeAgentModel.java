package freeagent;

public class FreeAgentModel {

    private  String playerName;
    private  String position;
    private Boolean captain;
    private IFreeAgentPersistent iFreeAgentPersistent;

    public FreeAgentModel() {
        iFreeAgentPersistent=new FreeAgentPersistent();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean isCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    public void storeFreeAgentInformation(FreeAgentModel freeAgentModel,int leagueId){
         iFreeAgentPersistent.addFreeAgentInformation(freeAgentModel.getPlayerName(),freeAgentModel.getPosition(),freeAgentModel.isCaptain(),leagueId);
    }
}
