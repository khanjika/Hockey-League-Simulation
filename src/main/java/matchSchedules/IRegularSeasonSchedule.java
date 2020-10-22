package matchSchedules;

import league.LeagueModel;
import teams.TeamsModel;

import java.util.List;

public interface IRegularSeasonSchedule {

    List<List<TeamsModel>> generateSeasonSchedule(LeagueModel leagueModel);
}
