package statemachine.states.statemachine.states.matchSchedules;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;

import java.util.List;

public interface IRegularSeasonSchedule {
    List<List<ITeamsModel>> generateSeasonSchedule(ILeagueModel leagueModel);
}
