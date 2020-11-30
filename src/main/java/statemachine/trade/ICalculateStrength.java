package statemachine.trade;

import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.PlayerModel;

import java.util.HashMap;
import java.util.List;

public interface ICalculateStrength {
    HashMap findStrength(ITeamsModel team);

    int findTeamStrengthWeakness(ITradeTeamPojo teamPojo, HashMap strengthMap);

    float findTeamStrength(List<PlayerModel> players);
}
