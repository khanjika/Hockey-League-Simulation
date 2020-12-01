package statemachine.simulateGame.matchSchedules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeadlinesTest {

    IDeadlines deadlines;

    @BeforeEach
    void createObj() {
        deadlines = MatchScheduleAbstractFactoryTest.getMatchScheduleInstance().getDeadline();
    }

    @Test
    void getRegularSeasonStartDate() {
        LocalDate expectedDate = LocalDate.of(2020, 10, 1);
        LocalDate date = deadlines.getRegularSeasonStartDate(2020);
        assertEquals(expectedDate, date);
    }

    @Test
    void getTradeDeadlineDate() {
        LocalDate expectedDate = LocalDate.of(2020, 02, 24);
        LocalDate date = deadlines.getTradeDeadlineDate(2020);
        assertEquals(expectedDate, date);
    }

    @Test
    void getEndOfRegularSeasonDate() {
        LocalDate expectedDate = LocalDate.of(2020, 04, 4);
        LocalDate date = deadlines.getEndOfRegularSeasonDate(2020);
        assertEquals(expectedDate, date);
    }

    @Test
    void getPlayOffStartDate() {
        LocalDate expectedDate = LocalDate.of(2020, 04, 8);
        LocalDate date = deadlines.getPlayOffStartDate(2020);
        assertEquals(expectedDate, date);
    }

    @Test
    void getLastDayOfStanleyCup() {
        LocalDate lastDayForSatnlyCup = LocalDate.of(2020, 6, 1);
        LocalDate date = deadlines.getLastDayOfStanleyCup(2020);
        assertEquals(lastDayForSatnlyCup, date);
    }

}
