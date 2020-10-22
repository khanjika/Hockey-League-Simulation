package matchSchedules;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;

public interface IDeadlines {
    LocalDate getRegularSeasonStartDate(int year);
    LocalDate getTradeDeadlineDate(int year);
    LocalDate getEndOfRegularSeasonDate(int year);
    LocalDate getPlayOffStartDate(int year);
    LocalDate getLastDayOfStanleyCup(int year);
}
