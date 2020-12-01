package statemachine.simulateGame.matchSchedules;

import LeagueMockObject.MockLeagueAbstractFactory;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayoffScheduleTest {

    IPlayoffSchedule playoffSchedule;

    @BeforeEach
    void createObj(){
       playoffSchedule= MatchScheduleAbstractFactory.getMatchScheduleInstance().getPLayOff();
    }

    @Test
    void generatePlayoffSchedule() throws Exception {
        ILeagueModel leagueModel= MockLeagueAbstractFactory.getMockInstance().createLeague();
        List<List<ITeamsModel>> schedule= playoffSchedule.generatePlayoffSchedule(leagueModel);
        assertNotNull(schedule);
    }

}
