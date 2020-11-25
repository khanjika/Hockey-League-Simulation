package statemachine.states.matchSchedules;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;

import java.util.List;

public interface IPlayoffSchedule {

    List<List<ITeamsModel>> generatePlayoffSchedule(ILeagueModel leagueModel);
}
