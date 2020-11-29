package statemachine.trophysystem;

import cli.IDisplay;
import leagueobjectmodel.ILeagueModel;

public interface IObserver {
    void update(ILeagueModel leagueModel,int year);
    void getHistoryOfWinners(IDisplay display);
}
