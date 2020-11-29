package statemachine.trophysystem;

import leagueobjectmodel.IHeadCoachModel;

public class CoachStandingSubject extends Subject{

    private static CoachStandingSubject unique_instance = new CoachStandingSubject();

    public static CoachStandingSubject getInstance() {
        return unique_instance;
    }

    public void notifyCoachStanding(IHeadCoachModel coachModel){
        subjectMap.put("coach", coachModel);
        System.out.println("notified");
        notifyObservers();
    }
}
