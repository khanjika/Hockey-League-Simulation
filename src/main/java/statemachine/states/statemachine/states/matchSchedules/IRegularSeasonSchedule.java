package statemachine.states.statemachine.states.matchSchedules;

import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.TeamsModel;

import java.util.List;

public interface IRegularSeasonSchedule {
    List<List<TeamsModel>> generateSeasonSchedule(LeagueModel leagueModel);
}
