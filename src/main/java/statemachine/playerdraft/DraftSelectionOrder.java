package statemachine.playerdraft;

import cli.CliAbstractFactory;
import cli.ICli;
import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DraftSelectionOrder implements IDraftSelectionOrder {
    final static Logger logger = Logger.getLogger(DraftSelectionOrder.class);
    private final int NO_DRAFTS_ROUNDS = 7;
    List<ITeamsModel> teamList = new ArrayList<>();
    ICli cli = CliAbstractFactory.getInstance().getCli();

    Comparator<ITeamsModel> teamModelComparator = new Comparator<ITeamsModel>() {
        @Override
        public int compare(ITeamsModel o1, ITeamsModel o2) {
            int teamOneWinPoint = o1.getWinPoint();
            int teamTwoWinPoint = o2.getWinPoint();
            return teamOneWinPoint - teamTwoWinPoint;
        }
    };
    private List<ITeamsModel> selectionOrderList;
    private IPlayerDraft playerDraft = PlayerDraftAbstractFactory.getInstance().createPlayerDraft();
    private ITeamsModel iTeamsModel = LeagueObjectModelAbstractFactory.getInstance().getTeams();

    @Override
    public List<ITeamsModel> getSelectionOrderList() {
        return selectionOrderList;
    }

    @Override
    public void setSelectionOrderList(List<ITeamsModel> selectionOrderList) {
        this.selectionOrderList = selectionOrderList;
    }

    @Override
    public List<ITeamsModel> getTeamStandingList(ILeagueModel leagueModel) {
        if (leagueModel == null) {
            logger.error("Argument null in getTeamStandingList");
            throw new NullPointerException("Argument null in getTeamStandingList");
        }
        for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (IDivisonModel divisionModel : conferenceModel.getDivisions()) {
                List<ITeamsModel> teams = divisionModel.getTeams();
                Collections.sort(teams, teamModelComparator);
                for (int i = 0; i < teams.size(); i++) {
                    teamList.add(teams.get(i));
                }
            }
        }
        return teamList;
    }

    @Override
    public void draftingRounds(List<IPlayerModel> newDraftedPlayers) {
        if(newDraftedPlayers == null){
            logger.error("Argument Null inside draftingRounds");
            throw new NullPointerException("Argument Null inside draftingRounds");
        }
        for (int i = 1; i <= NO_DRAFTS_ROUNDS; i++) {
            for (int j = 0; j < teamList.size(); j++) {
                IPlayerModel bestPlayer = Collections.max(newDraftedPlayers, Comparator.comparing(f -> f.getPlayerStrength()));
                teamList.get(j).addDrafterPlayerToTeam(bestPlayer);
                cli.printOutput("Team " + teamList.get(i) + " Picked Player " + bestPlayer + " in Draftind Round " + i);
                logger.info("Team " + teamList.get(i) + " Picked Player " + bestPlayer + " in Draftind Round " + i);
                newDraftedPlayers.remove(bestPlayer);
            }
        }
        for (int i = 0; i < teamList.size(); i++) {
            teamList.get(i).resolveRoostersToThirty();
        }
    }


}
