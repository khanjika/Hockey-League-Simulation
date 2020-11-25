package leagueobjectmodel;

public interface ITeamsValidator {

    boolean validateTeamObject(TeamsModel teamsModel);
    boolean isTeamAlreadyExist(String teamName);
}
