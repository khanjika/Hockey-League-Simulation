package states;

import league.LeagueModel;
import matchSchedules.Deadlines;
import matchSchedules.IDeadlines;
import matchSchedules.IRegularSeasonSchedule;
import matchSchedules.RegularSeasonSchedule;
import statemachine.StateMachine;
import teams.TeamsModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class InitializeSeasonState implements ITransition {

    IDeadlines iDeadlines;
    StateMachine stateMachine;
    LeagueModel updatedLeagueModel;
    LeagueModel initialLeagueModel;
    IRegularSeasonSchedule iRegularSeasonSchedule;
    ;
    private int year;

    public InitializeSeasonState(StateMachine stateMachine) {
    }

    public InitializeSeasonState(StateMachine stateMachine, LeagueModel updatedLeagueModel, LeagueModel initialLeagueModel, int currentYear) {
        this.stateMachine = stateMachine;
        this.updatedLeagueModel = updatedLeagueModel;
        this.initialLeagueModel = initialLeagueModel;
        year = currentYear;
        iDeadlines = new Deadlines();
    }

    @Override
    public void entry() {
        System.out.println("Seasone simualtion starts for the year-->" + year);
        System.out.println("End of Trade deadline is " + iDeadlines.getTradeDeadlineDate(year + 1));
        iRegularSeasonSchedule = new RegularSeasonSchedule();
        List<List<TeamsModel>> currentSeasonSchedule = iRegularSeasonSchedule.generateSeasonSchedule(updatedLeagueModel);
        int totalMatches = currentSeasonSchedule.size();
        long availableDaysForMatches = DAYS.between(iDeadlines.getEndOfRegularSeasonDate(year + 1), iDeadlines.getRegularSeasonStartDate(year + 1));
        long matchesPlayedInOneDay = totalMatches / availableDaysForMatches;

        int temp=0;
        for (int i = 1; i <= availableDaysForMatches; i++) {

            if(i%100==0){
                //call the method for training
            }
            for(int j=(i-1)*(int)matchesPlayedInOneDay;j<i*matchesPlayedInOneDay;j++){
                System.out.println(currentSeasonSchedule.get(j).get(0)+"---"+ currentSeasonSchedule.get(j).get(1));
            }
            System.out.println();

        }
        task();
    }

    @Override
    public void task() {
        exit();
    }

    @Override
    public void exit() {
        System.out.println("Season simulation ends");
    }
}
