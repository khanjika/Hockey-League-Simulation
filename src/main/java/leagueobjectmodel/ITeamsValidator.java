package leagueobjectmodel;

import java.util.List;

public interface ITeamsValidator {

    boolean validateTeamObject(ITeamsModel teamsModel);

    boolean isTeamAlreadyExist(String teamName);

    List<PlayerModel> isCaptainPresent(List<PlayerModel> teamPlayers);

    ILeagueModel NoOfPlayersInTeam(List<PlayerModel> teamPlayers, ILeagueModel leagueModel);

    List<PlayerModel> addingPlayer(IFreeAgentModel f, List<PlayerModel> players);

    List<IFreeAgentModel> addingFreeAgent(PlayerModel p, List<IFreeAgentModel> freeAgents);

    List<IFreeAgentModel> removePlayers(int noOfRemovedPlayers, List<PlayerModel> players, List<IFreeAgentModel> freeAgents, String position);

    List<IFreeAgentModel> addFromFreeAgent(int playersRequired, List<PlayerModel> players, List<IFreeAgentModel> freeAgents, String position);
}
