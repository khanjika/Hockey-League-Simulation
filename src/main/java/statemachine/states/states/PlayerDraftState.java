package statemachine.states.states;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.IPlayerModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import org.apache.log4j.Logger;
import statemachine.playerdraft.IDraftSelectionOrder;
import statemachine.playerdraft.IPlayerDraft;
import statemachine.playerdraft.PlayerDraftAbstractFactory;
import statemachine.states.StateMachine;

import java.util.ArrayList;
import java.util.List;

public class PlayerDraftState implements ITransition {

    StateMachine stateMachine;
    ILeagueModel leagueModel;
    List<ITeamsModel> teamList = new ArrayList<>();
    ITeamsModel teamsModel;
    final static Logger logger = Logger.getLogger(PlayerDraftState.class);
    public PlayerDraftState(StateMachine stateMachine) {
        logger.info("Initializing PlayerDraft State");
        this.stateMachine = stateMachine;
    }

    @Override
    public void entry() {
        this.leagueModel = LeagueObjectModelAbstractFactory.getInstance().getLeague();
        this.teamsModel = LeagueObjectModelAbstractFactory.getInstance().getTeams();
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
        IPlayerDraft playerDraft = PlayerDraftAbstractFactory.getInstance().createPlayerDraft();
        IDraftSelectionOrder draftSelectionOrder = PlayerDraftAbstractFactory.getInstance().createDraftSelectionOrder();

        try {
            List<ITeamsModel> teamStandingList = draftSelectionOrder.getTeamStandingList(leagueModel);
            int totalTeams = teamStandingList.size();
            List<IPlayerModel> newDraftedPlayers = playerDraft.draftPlayers(totalTeams);
            draftSelectionOrder.draftingRounds(newDraftedPlayers);
        }catch (Exception e){
            logger.error("Exception while performing player draft in the state");
            throw e;
        }
    }

    @Override
    public void exit() { }
}
