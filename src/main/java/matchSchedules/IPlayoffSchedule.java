package matchSchedules;

import league.LeagueModel;
import teams.TeamsModel;

import java.util.List;

public interface IPlayoffSchedule {

    List<List<TeamsModel>> generatePlayoffSchedule(LeagueModel leagueModel);
}
