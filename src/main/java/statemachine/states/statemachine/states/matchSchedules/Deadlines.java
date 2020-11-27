package statemachine.states.statemachine.states.matchSchedules;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;

public class Deadlines implements IDeadlines {

    @Override
    public LocalDate getRegularSeasonStartDate(int year) {
        if(year==0){
            throw new IllegalArgumentException("variable year is not initialized properly for match schedule class");
        }
        LocalDate date = LocalDate.of(year, 10, 1);
        return date;
    }

    @Override
    public LocalDate getTradeDeadlineDate(int year) {
        if(year==0){
            throw new IllegalArgumentException("variable year is not initialized properly for match schedule class");
        }
        YearMonth ym = YearMonth.of(year, Month.FEBRUARY);
        LocalDate ld = ym.atDay(1);
        int ordinal = 4;
        LocalDate tradeDeadlineDate = ld.with(TemporalAdjusters.dayOfWeekInMonth(ordinal, DayOfWeek.MONDAY));
        return tradeDeadlineDate;
    }

    @Override
    public LocalDate getEndOfRegularSeasonDate(int year) {
        if(year==0){
            throw new IllegalArgumentException("variable year is not initialized properly for match schedule class");
        }
        YearMonth ym = YearMonth.of(year, Month.APRIL);
        LocalDate ld = ym.atDay(1);
        int ordinal = 1;
        LocalDate regularSeasonEndDate = ld.with(TemporalAdjusters.dayOfWeekInMonth(ordinal, DayOfWeek.SATURDAY));
        return regularSeasonEndDate;
    }

    @Override
    public LocalDate getPlayOffStartDate(int year) {
        if(year==0){
            throw new IllegalArgumentException("variable year is not initialized properly for match schedule class");
        }
        YearMonth ym = YearMonth.of(year, Month.APRIL);
        LocalDate ld = ym.atDay(1);
        int ordinal = 2;
        LocalDate playOffStartDate = ld.with(TemporalAdjusters.dayOfWeekInMonth(ordinal, DayOfWeek.WEDNESDAY));
        return playOffStartDate;

    }

    @Override
    public LocalDate getLastDayOfStanleyCup(int year) {
        if(year==0){
            throw new IllegalArgumentException("variable year is not initialized properly for match schedule class");
        }
        LocalDate lastDayForSatnlyCup = LocalDate.of(year, 6, 1);
        return lastDayForSatnlyCup;
    }
}
