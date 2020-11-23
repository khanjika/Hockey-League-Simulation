package statemachine.states.matchSchedules;

import leagueobjectmodel.LeagueModelTest;
import org.junit.jupiter.api.Test;
import leagueobjectmodel.TeamsModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RegularSeasonScheduleTest {

    @Test
    void generateSeasonSchedule() {
        RegularSeasonSchedule regularSeasonSchedule = new RegularSeasonSchedule();
        List<List<TeamsModel>> schedule = regularSeasonSchedule.generateSeasonSchedule(LeagueModelTest.getLeagueObject());
        assertNotNull(schedule);
    }
}
