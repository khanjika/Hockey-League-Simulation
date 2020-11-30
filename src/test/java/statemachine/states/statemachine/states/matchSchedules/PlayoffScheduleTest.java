package statemachine.states.statemachine.states.matchSchedules;

import LeagueMockObject.MockLeagueAbstractFactory;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.TeamsModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import statemachine.jsonparser.IParser;
import statemachine.jsonparser.Parser;
import statemachine.jsonparser.ParserAbstractFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayoffScheduleTest {

    IPlayoffSchedule playoffSchedule;

    @BeforeEach
    void createObj(){
       playoffSchedule= MatchScheduleAbstractFactory.getMatchScheduleInstance().getPLayOff();
    }

    @Test
    void generatePlayoffSchedule() {
        ILeagueModel leagueModel= MockLeagueAbstractFactory.getMockInstance().createLeague();
        List<List<ITeamsModel>> schedule= playoffSchedule.generatePlayoffSchedule(leagueModel);
        assertNotNull(schedule);
    }

}
