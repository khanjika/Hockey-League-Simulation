package leagueobjectmodel;

import java.util.List;

public interface ITeamsValidator {

    boolean validateTeamObject(ITeamsModel teamsModel);
    boolean isTeamAlreadyExist(String teamName);

    List<PlayerModel> isCaptainPresent(List<PlayerModel> teamPlayers);

    ILeagueModel NoOfPlayersInTeam(List<PlayerModel> teamPlayers, ILeagueModel leagueModel);
}
