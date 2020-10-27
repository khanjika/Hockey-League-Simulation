package matchSchedules;

import league.LeagueModelTest;
import org.junit.jupiter.api.Test;
import teams.TeamsModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegularSeasonScheduleTest {

    @Test
    void generateSeasonSchedule() {
        RegularSeasonSchedule regularSeasonSchedule=new RegularSeasonSchedule();
        List<List<TeamsModel>> schedule=regularSeasonSchedule.generateSeasonSchedule(LeagueModelTest.getLeagueObject());
        assertNotNull(schedule);
    }
}