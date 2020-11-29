package statemachine.trophysystem;

import cli.ICli;
import leagueobjectmodel.ILeagueModel;

public interface IObserver {
    void update(ILeagueModel leagueModel,int year);
    void getHistoryOfWinners(ICli display);
}
