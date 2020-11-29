package statemachine.trophysystem;

import leagueobjectmodel.IPlayerModel;

import java.util.HashMap;

public class DefencemanStandingObserver implements IObserver{

    private HashMap<IPlayerModel, Integer> defencemanStanding;
    @Override
    public void update(Subject subject) {
        IPlayerModel playerModel = (IPlayerModel) subject.getValue("player");
    }
}
