package teams;

import league.LeagueModel;

public interface ITeamsPersistent {

    int addTeamInformation(String teamName, String headCoach, String generalManager,int divisionId);

    boolean isTeamNameExist(String teamName);

    void getTeamInformation(String teamName);
}
