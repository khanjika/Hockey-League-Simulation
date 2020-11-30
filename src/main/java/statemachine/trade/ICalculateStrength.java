package statemachine.trade;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.PlayerModel;

import java.util.HashMap;
import java.util.List;

public interface ICalculateStrength {
    HashMap findPositionStrength(ITeamsModel team);

    int totalStrengthCounter(ITeamsModel team, HashMap strengthMap, ILeagueModel league);

    float findTeamStrength(List<PlayerModel> players);

    void findAveragePositionStrength(ILeagueModel league);
}
