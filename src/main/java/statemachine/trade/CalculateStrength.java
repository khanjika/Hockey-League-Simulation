package statemachine.trade;

import leagueobjectmodel.*;

import java.util.HashMap;
import java.util.List;

public class CalculateStrength implements ICalculateStrength {
    private float averageForwardStrength = 0;
    private float averageDefenseStrength = 0;
    private float averageGoalieStrength = 0;

    @Override
    public int totalStrengthCounter(ITeamsModel team, HashMap strengthMap, ILeagueModel league) {
        int counterForward = 0;
        int counterDefense = 0;
        int counterGoalie = 0;
        int totalCounter;
        findAveragePositionStrength (league);
        if ((float) strengthMap.get (PlayerPosition.FORWARD.toString ()) > averageForwardStrength) {
            counterForward += 1;
        }
        if ((float) strengthMap.get (PlayerPosition.DEFENSE.toString ()) > averageDefenseStrength) {
            counterDefense += 1;
        }
        if ((float) strengthMap.get (PlayerPosition.GOALIE.toString ()) > averageGoalieStrength) {
            counterGoalie += 1;
        }
        team.setIsDefenseStrong (counterDefense);
        team.setIsForwardStrong (counterForward);
        team.setIsGoalieStrong (counterGoalie);
        totalCounter = counterForward + counterDefense + counterGoalie;
        return totalCounter;

    }

    @Override
    public HashMap findPositionStrength(ITeamsModel team) {
        float totalForwardStrength = 0;
        float totalDefenseStrength = 0;
        float totalGoalieStrength = 0;
        HashMap<String, Float> strengthMap = new HashMap<> ();
        List<PlayerModel> playerList = team.getPlayers ();
        for (int i = 0; i < playerList.size (); i++) {
            if (playerList.get (i).getPosition ().equals (PlayerPosition.FORWARD.toString ())) {
                float forwardStrength = playerList.get (i).getPlayerStrength ();
                totalForwardStrength += forwardStrength;
            } else if (playerList.get (i).getPosition ().equals (PlayerPosition.DEFENSE.toString ())) {
                float defenseStrength = playerList.get (i).getPlayerStrength ();
                totalDefenseStrength += defenseStrength;
            } else {
                float goalieStrength = playerList.get (i).getPlayerStrength ();
                totalGoalieStrength += goalieStrength;
            }
        }
        strengthMap.put (PlayerPosition.FORWARD.toString (), totalForwardStrength);
        strengthMap.put (PlayerPosition.DEFENSE.toString (), totalDefenseStrength);
        strengthMap.put (PlayerPosition.GOALIE.toString (), totalGoalieStrength);
        return strengthMap;
    }

    @Override
    public float findTeamStrength(List<PlayerModel> players) {
        float totalStrength = 0;
        for (int i = 0; i < players.size (); i++) {
            totalStrength += players.get (i).getPlayerStrength ();
        }
        return totalStrength;
    }

    @Override
    public void findAveragePositionStrength(ILeagueModel league) {
        int totalTeam = 0;
        float totalForward = 0;
        float totaldefense = 0;
        float totalGoalie = 0;
        for (IConferenceModel conference : league.getConferences ()) {
            for (IDivisonModel division : conference.getDivisions ()) {
                for (ITeamsModel team : division.getTeams ()) {
                    totalTeam += 1;
                    HashMap map = findPositionStrength (team);
                    totalForward = totalForward + (float) map.get ("forward");
                    totaldefense = totaldefense + (float) map.get ("defense");
                    totalGoalie = totalGoalie + (float) map.get ("goalie");
                }
            }
        }
        averageForwardStrength = totalForward / totalTeam;
        averageForwardStrength = (float) (averageForwardStrength + (averageForwardStrength * 0.10));

        averageDefenseStrength = totaldefense / totalTeam;
        averageDefenseStrength = (float) (averageDefenseStrength + (averageDefenseStrength * 0.10));

        averageGoalieStrength = totalGoalie / totalTeam;
        averageGoalieStrength = (float) (averageGoalieStrength + (averageGoalieStrength * 0.10));

    }
}
