package teams;

public interface ITeamsPersistent {

    int addTeamInformation(String teamName, int generalManager, int headCoach, int divisionId);

    boolean isTeamNameExist(String teamName, int divisionId);

    int getTeamId(String teamName, int divisionId);

    int addHeadCoahDetails(String headCoachName);

    int addGeneralManagerDetails(String managerName);

    TeamPojo getTeamInformation(String teamName, int divisionId);


}
