//package statemachine.states.statemachine.states.matchSchedules;
//
//import LeagueMockObject.MockLeagueAbstractFactory;
//import leagueobjectmodel.ILeagueModel;
//import leagueobjectmodel.ITeamsModel;
//import leagueobjectmodel.LeagueModelTest;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import leagueobjectmodel.TeamsModel;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//
//class RegularSeasonScheduleTest {
//
//    IRegularSeasonSchedule regularSeasonSchedule;
//
//    @BeforeEach
//    void createObj(){
//        regularSeasonSchedule= MatchScheduleAbstractFactory.getMatchScheduleInstance().getRegularSeason();
//    }
//
//    @Test
//    void generateSeasonSchedule() {
//        ILeagueModel leagueModel= MockLeagueAbstractFactory.getMockInstance().createLeague();
//        List<List<ITeamsModel>> schedule= regularSeasonSchedule.generateSeasonSchedule(leagueModel);
//        assertNotNull(schedule);
//    }
//
//}
