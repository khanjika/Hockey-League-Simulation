package statemachine.states;

import leagueobjectmodel.*;
import statemachine.StateMachine;
import statemachine.states.playerdraft.PlayerDraft;

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
        PlayerDraft playerDraft = new PlayerDraft();
        List<IPlayerModel> newDraftedPlayers =  playerDraft.draftPlayers();
        for(int i=0; i<newDraftedPlayers.size();i++){
            System.out.println("Drafted Player Name" + newDraftedPlayers.get(i).getPlayerName());
        }
        playerDraft.getTeamStandingList(leagueModel);
    }

    @Override
    public void exit() {

    }
}
