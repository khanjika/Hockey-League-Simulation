package leagueobjectmodel;

import java.util.List;

public interface IAfterTradingTeamValidator {
    LeagueModel teamIsValid(List<PlayerModel> players, LeagueModel leagueModel);

    List<PlayerModel> isCaptainPresent(List<PlayerModel> playersList);
}
