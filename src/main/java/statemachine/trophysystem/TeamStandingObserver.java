package statemachine.trophysystem;

import cli.ICli;
import leagueobjectmodel.ConferenceModel;
import leagueobjectmodel.DivisonModel;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.TeamsModel;

import java.util.*;

import static java.util.Comparator.comparing;

public class TeamStandingObserver implements IObserver{

    private final HashMap<Integer, TeamsModel> bestTeamWinners = new HashMap<>();
    private final HashMap<Integer, TeamsModel> lowestTeamWinners = new HashMap<>();

    @Override
    public void update(ILeagueModel leagueModel, int year) {
        List<TeamsModel> bestTeamOfEachDivision = new ArrayList<>();
        List<TeamsModel> lowestTeamOfEachDivison = new ArrayList<>();

        for(ConferenceModel conference : leagueModel.getConferences()){
            for(DivisonModel division : conference.getDivisions()){
                bestTeamOfEachDivision.add(Collections.max(division.getTeams(),
                        comparing(v -> v.getWinPoint())));
                lowestTeamOfEachDivison.add(Collections.max(division.getTeams(),
                        comparing(v -> v.getLossPoint())));
                System.out.println("in loop");
            }
        }
        bestTeamWinners.put(year, Collections.max(bestTeamOfEachDivision,Comparator
                .comparing(TeamsModel::getWinPoint)));
        lowestTeamWinners.put(year, Collections.max(bestTeamOfEachDivision,Comparator
                .comparing(TeamsModel::getLossPoint)));
    }

    @Override
    public void getHistoryOfWinners(ICli display){
        SortedSet<Integer> years = new TreeSet<>(bestTeamWinners.keySet()).descendingSet();
        display.printOutput(TrophySystemConstants.LineSeperator.getValue() + TrophySystemConstants.LineSpace.getValue() + TrophySystemConstants.BestTeamTrophy.getValue()
                + TrophySystemConstants.LineSpace.getValue()
                + TrophySystemConstants.LineSeperator.getValue());
        for(Integer currentYear: years){
            display.printOutput(TrophySystemConstants.Year.getValue() + currentYear
                    + TrophySystemConstants.Winner.getValue() + bestTeamWinners.get(currentYear).getTeamName()
                    + TrophySystemConstants.LineSpace.getValue());
        }
        years = new TreeSet<>(lowestTeamWinners.keySet()).descendingSet();
        display.printOutput(TrophySystemConstants.LineSeperator.getValue() + TrophySystemConstants.LineSpace.getValue() +
                TrophySystemConstants.LowestTeamTrophy.getValue()
                + TrophySystemConstants.LineSpace.getValue()
                + TrophySystemConstants.LineSeperator.getValue());
        for(Integer currentYear: years){
            display.printOutput(TrophySystemConstants.Year.getValue() + currentYear
                    + TrophySystemConstants.Winner.getValue() +lowestTeamWinners.get(currentYear).getTeamName()
                    + TrophySystemConstants.LineSpace.getValue());
        }
    }
}
