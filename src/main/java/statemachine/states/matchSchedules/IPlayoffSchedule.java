package statemachine.states.matchSchedules;

import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.TeamsModel;

import java.util.List;

public interface IPlayoffSchedule {

    List<List<TeamsModel>> generatePlayoffSchedule(LeagueModel leagueModel);
}
