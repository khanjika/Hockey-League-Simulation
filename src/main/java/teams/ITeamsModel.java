package teams;

public interface ITeamsModel {

    void storeTeamInformation(TeamsModel teamsModel,int divId);
    boolean isTeamAlreadyExist(String teamName, int divisionId);
    int getTeamId(String teamName, int divisionId);
    TeamPojo getTeamInformation(String teamName, int divisionId);
    void calculateTeamStrength(TeamsModel teamsModel);
}
