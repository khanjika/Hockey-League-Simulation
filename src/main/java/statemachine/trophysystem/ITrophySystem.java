package statemachine.trophysystem;

import leagueobjectmodel.ILeagueModel;

public interface ITrophySystem {
    void performCalculationBeforePlayOff(ILeagueModel leagueModel, int year);
    void performCalculationAfterPlayOff(ILeagueModel leagueModel,int year);
    void awardWinners();
}
