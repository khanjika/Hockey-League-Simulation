package teams;

public interface ITeamsPersistent {

    int addTeamInformation(String teamName, String headCoach, String generalManager,int divisionId);

    boolean isTeamNameExist(String teamName);
}
