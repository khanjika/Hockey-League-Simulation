package statemachine.simulateGame.matchSchedules;

import java.time.LocalDate;

public interface IDeadlines {
    LocalDate getRegularSeasonStartDate(int year);

    LocalDate getTradeDeadlineDate(int year);

    LocalDate getEndOfRegularSeasonDate(int year);

    LocalDate getPlayOffStartDate(int year);

    LocalDate getLastDayOfStanleyCup(int year);

    LocalDate getPlayerDraftStartDate(int year);
}
