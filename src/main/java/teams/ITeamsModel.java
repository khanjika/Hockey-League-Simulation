package teams;

public interface ITeamsModel {

    boolean isTeamAlreadyExist(String teamName, int divisionId);
    int getTeamId(String teamName, int divisionId);
}
