package statemachine.simulateGame.matchSchedules;

import LeagueMockObject.MockLeagueAbstractFactory;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class RegularSeasonScheduleTest {

    IRegularSeasonSchedule regularSeasonSchedule;

    @BeforeEach
    void createObj(){
        regularSeasonSchedule= MatchScheduleAbstractFactory.getMatchScheduleInstance().getRegularSeason();
    }

    @Test
    void generateSeasonSchedule() {
        ILeagueModel leagueModel= MockLeagueAbstractFactory.getMockInstance().createLeague();
        List<List<ITeamsModel>> schedule= regularSeasonSchedule.generateSeasonSchedule(leagueModel);
        assertNotNull(schedule);
    }

}
