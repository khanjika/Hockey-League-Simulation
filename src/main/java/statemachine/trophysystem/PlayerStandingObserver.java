package statemachine.trophysystem;

import cli.ICli;
import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.*;

public class PlayerStandingObserver implements IObserver{

    private HashMap<Integer, PlayerModel> playerWinner = new HashMap<>();
    final static Logger logger = Logger.getLogger(PlayerStandingObserver.class);

    @Override
    public void update(ILeagueModel leagueModel, int year) {
        logger.info(TrophySystemConstants.LogInfoPlayerUpdate.getValue());
        List<PlayerModel> bestPlayerEachTeam = new ArrayList<>();
        for(IConferenceModel conference : leagueModel.getConferences()){
            for(IDivisonModel division : conference.getDivisions()) {
                for (ITeamsModel team : division.getTeams()) {
                    bestPlayerEachTeam.add(Collections.max(team.getPlayers(),
                            Comparator.comparing(PlayerModel::getCurrentPenaltyCount)));
                }
            }
        }
        playerWinner.put(year, Collections.max(bestPlayerEachTeam,Comparator
                .comparing(PlayerModel::getCurrentPenaltyCount)));
    }

    @Override
    public void getHistoryOfWinners(ICli display) {
        logger.info(TrophySystemConstants.LogInfoPlayerDisplay.getValue());
        SortedSet<Integer> years = new TreeSet<>(playerWinner.keySet());
        display.printOutput(TrophySystemConstants.LineSeperator.getValue() + TrophySystemConstants.LineSpace.getValue() +
                TrophySystemConstants.PlayerTrophy.getValue() + TrophySystemConstants.LineSpace.getValue()
                + TrophySystemConstants.LineSeperator.getValue());
        display.printOutput(TrophySystemConstants.Year.getValue() + years.first()
                + TrophySystemConstants.Winner.getValue() +playerWinner.get(years.first()).getPlayerName()
                + TrophySystemConstants.LineSpace.getValue());
    }
}
