package statemachine.playerdraft;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.IPlayerModel;
import leagueobjectmodel.ITeamsModel;

import java.util.List;

public interface IDraftSelectionOrder {
    abstract List<ITeamsModel> getSelectionOrderList();

    abstract void setSelectionOrderList(List<ITeamsModel> selectionOrderList);

    List<ITeamsModel> getTeamStandingList(ILeagueModel leagueModel);

    void draftingRounds(List<IPlayerModel> newDraftedPlayers);
}
