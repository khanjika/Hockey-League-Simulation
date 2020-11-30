package statemachine.states.statemachine.states;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.IPlayerModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import statemachine.states.playerdraft.IDraftSelectionOrder;
import statemachine.states.playerdraft.IPlayerDraft;
import statemachine.states.playerdraft.PlayerDraftAbstractFactory;
import statemachine.states.statemachine.StateMachine;

import java.util.ArrayList;
import java.util.List;

public class PlayerDraftState implements ITransition {

    StateMachine stateMachine;
    ILeagueModel leagueModel;
    List<ITeamsModel> teamList = new ArrayList<>();
    ITeamsModel teamsModel;

    public PlayerDraftState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void entry() {
        this.leagueModel = LeagueObjectModelAbstractFactory.getInstance().getLeague();
        this.teamsModel = LeagueObjectModelAbstractFactory.getInstance().getTeams();

        System.out.println(leagueModel);
        task();
    }

    public List<ITeamsModel> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<ITeamsModel> teamList) {
        this.teamList = teamList;
    }

    @Override
    public void task() {
        System.out.println(" Task Method of Player Draft State");
        IPlayerDraft playerDraft = PlayerDraftAbstractFactory.getInstance().createPlayerDraft();
        IDraftSelectionOrder draftSelectionOrder = PlayerDraftAbstractFactory.getInstance().createDraftSelectionOrder();
        List<ITeamsModel> teamStandingList = draftSelectionOrder.getTeamStandingList(leagueModel);
        int totalTeams = teamStandingList.size();
        List<IPlayerModel> newDraftedPlayers = playerDraft.draftPlayers(totalTeams);
        draftSelectionOrder.draftingRounds(newDraftedPlayers);
    }

    @Override
    public void exit() {

    }
}
