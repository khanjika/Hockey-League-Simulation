package statemachine.trophysystem;

import leagueobjectmodel.IHeadCoachModel;

import java.util.*;

public class CoachStandingObserver implements IObserver {

    private HashMap<IHeadCoachModel, Integer> coachStanding;

    public CoachStandingObserver(){
        this.coachStanding = new HashMap<>();
    }

    @Override
    public void update(Subject subject) {
        IHeadCoachModel coachModel = (IHeadCoachModel) subject.getValue("coach");

        if (coachStanding.containsKey(coachModel)){
            coachStanding.put(coachModel, coachStanding.get(coachModel) + 1);
        }else{
            coachStanding.put(coachModel, 1);
        }
        System.out.println("in update");
    }

    public IHeadCoachModel getBestCoach(){
        return getFirstCoach("desc");
    }

    private IHeadCoachModel getFirstCoach(String order){
        if(coachStanding.isEmpty()){
            return null;
        }
        Set<Map.Entry<IHeadCoachModel, Integer>> entrySet = coachStanding.entrySet();
        List<Map.Entry<IHeadCoachModel, Integer>> standingsList = new LinkedList<>(entrySet);
        standingsList.sort((o1, o2) -> {
            if (order.equals("desc")){
                return o1.getValue().compareTo(o2.getValue());
            } else{
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return standingsList.get(0).getKey();
    }
}
